package com.chebdowski.resume.core.di

import com.chebdowski.resume.features.resume.PersonApi
import com.chebdowski.resume.features.resume.PersonRepository
import com.chebdowski.resume.features.resume.ResumeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module {
    single { providePersonRepository(get()) }
    viewModel { provideResumeViewModel() }
}

fun providePersonRepository(api: PersonApi) = PersonRepository.RemotePersonRepository(api)

fun provideResumeViewModel() = ResumeViewModel()
