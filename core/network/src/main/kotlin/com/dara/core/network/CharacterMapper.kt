package com.dara.core.network

import com.dara.core.network.data.Character
import com.dara.core.network.data.CharacterApiModel

internal fun CharacterApiModel.toCharacter(): Character = Character(
    name = name,
    status = status,
    species = species,
    gender = gender,
    origin = origin.name,
    location = location.name,
    image = image,
)
