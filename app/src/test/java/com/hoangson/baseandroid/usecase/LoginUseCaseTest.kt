package com.hoangson.baseandroid.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.hoangson.baseandroid.core.models.ErrorType
import com.hoangson.baseandroid.core.models.Output
import com.hoangson.baseandroid.domain.model.LoginEntity
import com.hoangson.baseandroid.domain.repository.LoginRepository
import com.hoangson.baseandroid.domain.usecase.LoginUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


class LoginUseCaseTest {


    companion object {

        private val USERNAME = "hani"
        private val PASSWORD = "password"

    }

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var loginRepository: LoginRepository

    lateinit var loginUseCase: LoginUseCase

    @Before
    fun setup() {

        MockitoAnnotations.initMocks(this)

        loginUseCase = LoginUseCase(loginRepository)

    }


    @Test
    fun loginUseCase_wrongCredentianls_invalid() {

        Mockito.`when`(loginRepository.login(USERNAME, PASSWORD))
            .thenReturn(Output.Error(ErrorType.DATA,"Invalid"))

        val output = runBlocking { loginUseCase.run(LoginUseCase.Params(USERNAME, PASSWORD)) }

        assert(output is Output.Error)

    }


    @Test
    fun loginUseCase_correctCredentials_login() {

        Mockito.`when`(loginRepository.login(USERNAME, PASSWORD))
            .thenReturn(Output.Success(LoginEntity.loggedIn()))

        runBlocking { loginUseCase.run(LoginUseCase.Params(USERNAME, PASSWORD)) }

        Mockito.verify(loginRepository).login(USERNAME, PASSWORD)

        Mockito.verifyNoMoreInteractions(loginRepository)

    }
}