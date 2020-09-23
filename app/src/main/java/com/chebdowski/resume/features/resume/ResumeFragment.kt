package com.chebdowski.resume.features.resume

import android.os.Bundle
import com.chebdowski.resume.R
import com.chebdowski.resume.core.exception.Failure
import com.chebdowski.resume.core.extension.failure
import com.chebdowski.resume.core.extension.observe
import com.chebdowski.resume.core.platform.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class ResumeFragment : BaseFragment() {

    private val viewModel: ResumeViewModel by viewModel()

    override fun layoutId() = R.layout.resume_fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observe(viewModel.person, ::handlePerson)
        failure(viewModel.failure, ::handleFailure)
    }

    private fun handlePerson(person: Person?) {
        println("handle Person")
    }

    private fun handleFailure(failure: Failure?) {
        when (failure) {
            is Failure.ServerError -> notify(R.string.failure_server_error)
        }
    }
}