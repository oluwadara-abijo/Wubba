package com.dara.core.network.data

import kotlinx.serialization.Serializable

@Serializable
internal data class CharacterApiModel(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginApiModel,
    val location: LocationApiModel,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String,
)