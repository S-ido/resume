package com.chebdowski.resume.core.di

import com.chebdowski.resume.features.resume.PersonRepository
import org.koin.dsl.module

val applicationModule = module {
    single { PersonRepository() }
}