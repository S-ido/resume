package com.chebdowski.resume.core.di

import com.chebdowski.resume.features.resume.PersonApi
import com.chebdowski.resume.features.resume.PersonRepository
import org.koin.dsl.module

val applicationModule = module {
    single { providePersonRepository(get()) }
}

fun providePersonRepository(api: PersonApi): PersonRepository {
    return PersonRepository.RemotePersonRepository(api)
}
