package com.dara.core.network.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharactersApiModel(
    val info: InfoApiModel,
    @SerialName("results") val characters: List<CharacterApiModel>
)
