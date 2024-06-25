package com.dara.core.test

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dara.wubba.ui.SharedViewModel
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SharedViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @RelaxedMockK
    private val underTest: SharedViewModel = SharedViewModel()

    @Test
    fun `selected character is updated successfully`() =
        runTest {
            // Given
            val character = fakeCharacters[0]

            // When
            underTest.selectCharacter(character)

            // Then
            assertEquals(character, underTest.selectedCharacter.value)
        }

}
