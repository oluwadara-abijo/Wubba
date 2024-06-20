package com.dara.network.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CharactersApiModel(
    val info: InfoApiModel,
    @SerialName("characters") val result: List<CharacterApiModel>
)
