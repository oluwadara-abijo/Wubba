package com.dara.core.network

import com.dara.core.network.data.Character
import javax.inject.Inject

class CharactersRepository @Inject internal constructor(
    private val charactersApi: CharactersApi
) {

    suspend fun fetchCharacters(): Result<List<Character>> {
        return try {
            // Get server response
            val apiResponse = charactersApi.getCharacters()
            // Get list of characters from server response
            val characterApiModels = apiResponse.characters
            // Map each character api model to domain model
            val characters = characterApiModels.map { it.toCharacter() }
            Result.success(characters)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}
