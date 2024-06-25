package com.dara.core.test

import com.dara.core.network.CharactersApi
import com.dara.core.network.CharactersRepository
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class CharactersRepositoryTest {

    @RelaxedMockK
    private lateinit var mockApi: CharactersApi
    private lateinit var underTest: CharactersRepository

    @BeforeEach
    fun setUp() {
        underTest = CharactersRepository(mockApi)
    }

    @Test
    fun `given server returns characters list, when getting characters, then all characters are returned`() =
        runTest {
            // Given
            coEvery { mockApi.getCharacters() } returns fakeApiResponse.also {
                println("Mock repository.fetchCharacters() called")
            }
            val expectedCharacters = fakeApiResponse.characters

            // When
            val repositoryResult = underTest.fetchCharacters()

            // Then
            with(repositoryResult) {
                assert(isSuccess)
                assert(getOrNull()?.size == expectedCharacters.size)
            }
        }

    @Test
    fun `given server returns empty list, when getting characters, then empty list is returned`() =
        runTest {
            // Given
            coEvery { mockApi.getCharacters() } returns fakeEmptyApiResponse

            // When
            val repositoryResult = underTest.fetchCharacters()

            // Then
            with(repositoryResult) {
                assert(isSuccess)
                assert(getOrNull()?.size == 0)
            }
        }


    @Test
    fun `given server returns error, when getting characters, then error is returned`() =
        runTest {
            // Given
            coEvery { mockApi.getCharacters() } throws Exception()

            // When
            val repositoryResult = underTest.fetchCharacters()

            // Then
            assert(repositoryResult.isFailure)
            assert(repositoryResult.exceptionOrNull() is Exception)
        }
}
