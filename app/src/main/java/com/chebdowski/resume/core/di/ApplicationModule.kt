package com.chebdowski.resume.core.di

import com.chebdowski.resume.features.resume.GetPerson
import com.chebdowski.resume.features.resume.PersonApi
import com.chebdowski.resume.features.resume.PersonRepository
import com.chebdowski.resume.features.resume.ResumeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module {
    single { providePersonRepository(get()) }
    factory { provideGetPersonUseCase(get()) }
    viewModel { provideResumeViewModel() }
}

fun providePersonRepository(api: PersonApi): PersonRepository = PersonRepository.RemotePersonRepository(api)

fun provideGetPersonUseCase(personRepository: PersonRepository) = GetPerson(personRepository)

fun provideResumeViewModel() = ResumeViewModel()
