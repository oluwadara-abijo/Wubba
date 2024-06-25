package com.dara.core.test

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dara.core.network.CharactersRepository
import com.dara.core.network.utils.ErrorHandler
import com.dara.wubba.ui.CharactersViewModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CharactersViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val repository: CharactersRepository = mockk()
    private val errorHandler: ErrorHandler = mockk()
    private val testScope = CoroutineScope(Dispatchers.Unconfined)

    private lateinit var underTest: CharactersViewModel

    @Test
    fun `given repository call succeeds, ui state updates`() =
        runTest {
            // Given
            coEvery { repository.fetchCharacters() } returns Result.success(fakeCharacters)

            // When
            underTest = CharactersViewModel(repository, errorHandler, testScope)
            val uiState = underTest.uiState.value

            // Then
            coVerify { repository.fetchCharacters() }
            assertEquals(fakeCharacters, uiState.characters)
            assertFalse(uiState.isLoading)
            assertNull(uiState.errorMessage)
        }

    @Test
    fun `given repository call fails, error message is displayed`() =
        runTest {
            // Given
            val exception = Exception("Network error")
            coEvery { repository.fetchCharacters() } returns Result.failure(exception)
            every { errorHandler.getErrorMessage(exception) } returns "An error occurred"

            // When
            underTest = CharactersViewModel(repository, errorHandler, testScope)
            val uiState = underTest.uiState.value

            // Then
            coVerify { repository.fetchCharacters() }
            coVerify { errorHandler.getErrorMessage(exception) }
            assertTrue(uiState.characters.isEmpty())
            assertFalse(uiState.isLoading)
            assertEquals("An error occurred", uiState.errorMessage)
        }
}
