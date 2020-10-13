package com.chebdowski.resume.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import com.chebdowski.core.exception.Failure
import com.chebdowski.domain.person.Person
import com.chebdowski.resume.R
import com.chebdowski.resume.composition.ComposeResume
import com.chebdowski.resume.composition.Loading
import com.chebdowski.resume.composition.ResumeTheme
import com.chebdowski.resume.composition.notify
import com.chebdowski.resume.extension.failureAsState
import com.chebdowski.resume.extension.observeAsState
import com.chebdowski.resume.platform.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class ResumeFragment : BaseFragment() {

    private val viewModel: ResumeViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return ComposeView(context = requireContext()).apply {
            setContent {
                ResumeTheme {
                    HandlePerson(observeAsState(viewModel.person))
                    HandleFailure(failureAsState(viewModel.failure), context)
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadPerson()
    }

    @Composable
    private fun HandlePerson(person: Person?) {
        if (person != null) {
            ComposeResume(person)
        } else {
            Loading()
        }
    }

    @Composable
    private fun HandleFailure(failure: Failure?, context: Context) {
        when (failure) {
            is Failure.BadRequest -> notify(context.getString(R.string.failure_bad_request))
            is Failure.Unauthorized -> notify(context.getString(R.string.failure_unauthorized))
            is Failure.Forbidden -> notify(context.getString(R.string.failure_forbidden))
            is Failure.NotFound -> notify(context.getString(R.string.failure_not_found))
            is Failure.RequestTimeout -> notify(context.getString(R.string.failure_request_timeout))
            is Failure.ServerError -> notify(context.getString(R.string.failure_server_error))
            is PersonFailure.PersonNotAvailable -> notify(context.getString(R.string.failure_person_not_available))
            is Failure.RequestError -> notify(context.getString(R.string.failure_request))
            is Failure.UnhandledError -> notify(context.getString(R.string.failure_unhandled_request, failure.errorCode))
        }
    }
}