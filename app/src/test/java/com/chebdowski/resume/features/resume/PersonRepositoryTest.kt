package com.chebdowski.resume.features.resume

import android.accounts.NetworkErrorException
import com.chebdowski.core.UnitTest
import com.chebdowski.core.exception.Failure.ServerError
import com.chebdowski.core.functional.Either
import com.chebdowski.core.functional.Either.Right
import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.`should be instance of`
import org.amshove.kluent.`should be`
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito.verify
import retrofit2.Call
import retrofit2.Response

class PersonRepositoryTest : UnitTest() {
    private lateinit var personRepository: PersonRepository.RemotePersonRepository

    @Mock
    private lateinit var api: PersonApi

    @Mock
    private lateinit var personCall: Call<PersonEntity>

    @Mock
    private lateinit var personResponse: Response<PersonEntity>

    @Before
    fun setup() {
        personRepository = PersonRepository.RemotePersonRepository(api)
    }

    @Test
    fun `repository should return empty person by default`() {
        given(personResponse.body()).willReturn(null)
        given(personResponse.isSuccessful).willReturn(true)
        given(personCall.execute()).willReturn(personResponse)
        given(api.person()).willReturn(personCall)

        val person = personRepository.person()

        person `should be equal to` Right(Person.empty())
        verify(api).person()
    }

    @Test
    fun `repository should return person from api`() {
        given(personResponse.body()).willReturn(getMockedPersonEntity())
        given(personResponse.isSuccessful).willReturn(true)
        given(personCall.execute()).willReturn(personResponse)
        given(api.person()).willReturn(personCall)

        val person = personRepository.person()

        person `should be equal to` Right(getMockedPerson())
        verify(api).person()
    }

    @Test
    fun `repository should return server error if no successful response`() {
        given(personResponse.isSuccessful).willReturn(false)
        given(personCall.execute()).willReturn(personResponse)
        given(api.person()).willReturn(personCall)

        val person = personRepository.person()

        person `should be instance of` Either::class.java
        person.isLeft `should be` true
        person.either({ failure -> failure `should be instance of` ServerError::class.java }, { /** ignore right **/ })
    }

    @Test
    fun `repository should catch exceptions`() {
        given(personCall.execute()).willAnswer { throw NetworkErrorException() }
        given(api.person()).willReturn(personCall)

        val person = personRepository.person()

        person `should be instance of` Either::class.java
        person.isLeft `should be` true
        person.either({ failure -> failure `should be instance of` ServerError::class.java }, { /** ignore right **/ })
    }

    private fun getMockedPerson() = Person("", "Piotr", "Mocked", "", "", "")
    private fun getMockedPersonEntity() = PersonEntity("", "Piotr", "Mocked", "", "", "")
}