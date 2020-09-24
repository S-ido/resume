package com.chebdowski.resume.features.resume

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import com.chebdowski.resume.core.extension.failureAsState
import com.chebdowski.resume.core.extension.observeAsState
import com.chebdowski.resume.core.platform.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class ResumeFragment : BaseFragment() {

    private val viewModel: ResumeViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return ComposeView(context = requireContext()).apply {
            setContent {
                HandlePerson(observeAsState(viewModel.person))
                HandleFailure(failureAsState(viewModel.failure), context)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadPerson()
    }
}