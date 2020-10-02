package com.chebdowski.resume.features.resume

import com.chebdowski.core.UnitTest
import com.chebdowski.core.functional.Either
import com.chebdowski.resume.core.interactor.UseCase.None
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.*
import org.mockito.Mock
import org.mockito.Mockito

class GetPersonTest : UnitTest() {

    private lateinit var getPerson: GetPerson

    @Mock
    private lateinit var personRepository: PersonRepository

    @Before
    fun setup() {
        getPerson = GetPerson(personRepository)
    }

    @Test
    fun `get person should get correct data from repository`() {
        given(personRepository.person()).willReturn(Either.Right(Person.empty()))

        runBlocking { getPerson.run(None()) }

        Mockito.verify(personRepository).person()
        verifyNoMoreInteractions(personRepository)
    }
}