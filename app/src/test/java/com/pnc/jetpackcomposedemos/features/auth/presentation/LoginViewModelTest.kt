package com.pnc.jetpackcomposedemos.features.auth.presentation

import com.pnc.jetpackcomposedemos.features.auth.domain.LoginUseCase
import com.pnc.jetpackcomposedemos.testutil.builders.aUser
import junit.framework.TestCase.assertEquals
import com.pnc.jetpackcomposedemos.features.auth.domain.RecordingAuthRepository
import com.pnc.jetpackcomposedemos.testutil.MainDispatcherRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
class LoginViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()
    // Note: when using this rule approach (instead of @before and @after)
    // do not create the viewmodel in a class constructor, or
    // property initializer - those execute before the test starting
    // method in our MainDispatcherRule
    // (create the ViewModel inside the test, or in its own @Before fun)

    @Test
    fun `given valid credentials, when logging in, then state is Success`() = runTest {
        val user = aUser()
        val repo = RecordingAuthRepository(result = Result.success(user))
        val viewModel = LoginViewModel(LoginUseCase(repo))

        viewModel.login("hello", "world")
        advanceUntilIdle() // wait until the coroutine launched by login() is finished

        assertEquals(LoginUiState.Success(user), viewModel.uiState.value)

    }
}