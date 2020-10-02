package com.chebdowski.resume.core.di

import com.chebdowski.data.PersonApi
import com.chebdowski.data.RemotePersonRepository
import com.chebdowski.domain.person.PersonRepository
import com.chebdowski.interactors.GetPerson
import com.chebdowski.resume.features.resume.ResumeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module {
    single { providePersonRepository(get()) }
    factory { provideGetPersonUseCase(get()) }
    viewModel { provideResumeViewModel() }
}

fun providePersonRepository(api: PersonApi): PersonRepository = RemotePersonRepository(api)

fun provideGetPersonUseCase(personRepository: PersonRepository) = GetPerson(personRepository)

fun provideResumeViewModel() = ResumeViewModel()
