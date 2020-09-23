package com.chebdowski.resume.features.resume

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.DensityAmbient
import com.chebdowski.resume.R
import com.chebdowski.resume.core.exception.Failure
import com.chebdowski.resume.core.extension.failure
import com.chebdowski.resume.core.extension.observe
import com.chebdowski.resume.core.platform.BaseFragment
import dev.chrisbanes.accompanist.coil.CoilImage
import org.koin.android.viewmodel.ext.android.viewModel

class ResumeFragment : BaseFragment() {

    private val viewModel: ResumeViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return ComposeView(context = requireContext()).apply {
            setContent {
                observe(viewModel.person, ::HandlePerson)
                failure(viewModel.failure, ::HandleFailure)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadPerson()
    }

    @Composable
    private fun HandlePerson(person: Person?) {
        println("handle Person")

        val scrollState = rememberScrollState()

        ScrollableColumn(
            modifier = Modifier.fillMaxSize(),
            scrollState = scrollState
        ) {
            if (person == null) {
                TODO("Handle null person data")
            } else {
                Header(scrollState, person)
            }
        }
    }

    @Composable
    fun Header(scrollState: ScrollState, person: Person) {
        val offset = scrollState.value / 2
        val offsetDp = with(DensityAmbient.current) { offset.toDp() }

        CoilImage(
            data = person.pictureUrl,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = offsetDp),
            contentScale = ContentScale.Crop
        )
    }

    @Composable
    fun HandleFailure(failure: Failure?) {
        println("handle Failure")
        when (failure) {
            is Failure.ServerError -> notify(getString(R.string.failure_server_error))
        }
    }
}