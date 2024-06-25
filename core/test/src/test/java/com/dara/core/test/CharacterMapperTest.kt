package com.dara.core.test

import com.dara.core.network.toCharacter
import org.junit.jupiter.api.Test

class CharacterMapperTest {
    @Test
    fun `given CharacterApiModel, when mapped, then a Character object is returned`() {
        // Given
        val fakeApiModel = fakeCharacterApiModels[0]

        // When
        val character = fakeApiModel.toCharacter()

        // Then
        with(character) {
            assert(name == fakeApiModel.name)
            assert(status == fakeApiModel.status)
            assert(species == fakeApiModel.species)
            assert(gender == fakeApiModel.gender)
            assert(origin == fakeApiModel.origin.name)
            assert(location == fakeApiModel.location.name)
            assert(image == fakeApiModel.image)

        }
    }

}
