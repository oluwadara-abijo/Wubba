package com.dara.core.test

import com.dara.core.network.data.Character
import com.dara.core.network.data.CharacterApiModel
import com.dara.core.network.data.CharactersApiModel
import com.dara.core.network.data.InfoApiModel
import com.dara.core.network.data.LocationApiModel
import com.dara.core.network.data.OriginApiModel

val fakeInfoApiModel = InfoApiModel(
    count = 1,
    pages = 2,
    next = "https=//rickandmortyapi.com/api/character/?page=2",
    prev = null
)

val fakeCharacterApiModels = listOf(
    CharacterApiModel(
        id = 1,
        name = "Rick Sanchez",
        status = "Alive",
        species = "Human",
        type = "",
        gender = "Male",
        origin = OriginApiModel(
            name = "Earth (C-137)",
            url = "https=//rickandmortyapi.com/api/location/1"
        ),
        location = LocationApiModel(
            name = "Citadel of Ricks",
            url = "https=//rickandmortyapi.com/api/location/3"
        ),
        image = "https=//rickandmortyapi.com/api/character/avatar/1.jpeg",
        episode = emptyList(),
        url = "https=//rickandmortyapi.com/api/character/1",
        created = "2017-11-04T18=48=46.250Z"
    ),
    CharacterApiModel(
        id = 2,
        name = "Morty Smith",
        status = "Alive",
        species = "Human",
        type = "",
        gender = "Male",
        origin = OriginApiModel(
            name = "unknown",
            url = ""
        ),
        location = LocationApiModel(
            name = "Citadel of Ricks",
            url = "https=//rickandmortyapi.com/api/location/3"
        ),
        image = "https=//rickandmortyapi.com/api/character/avatar/2.jpeg",
        episode = emptyList(),
        url = "https=//rickandmortyapi.com/api/character/2",
        created = "2017-11-04T18=50=21.651Z"
    )
)

val fakeApiResponse = CharactersApiModel(
    info = fakeInfoApiModel,
    characters = fakeCharacterApiModels
)

val fakeEmptyInfoApiModel = InfoApiModel(
    count = 0,
    pages = 1,
    next = "",
    prev = null
)

val fakeEmptyApiResponse = CharactersApiModel(
    info = fakeEmptyInfoApiModel,
    characters = emptyList()
)

val fakeCharacters = listOf(
    Character(
        name = "Summer Smith",
        status = "Alive",
        species = "Human",
        gender = "Female",
        origin = "Earth (Replacement Dimension)",
        location = "Earth (Replacement Dimension)",
        image = "https=//rickandmortyapi.com/api/character/avatar/3.jpeg"
    ),
    Character(
        name = "Beth Smith",
        status = "Alive",
        species = "Human",
        gender = "Female",
        origin = "Earth (Replacement Dimension)",
        location = "Earth (Replacement Dimension)",
        image = "https=//rickandmortyapi.com/api/character/avatar/4.jpeg"
    )
)
