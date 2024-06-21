package com.dara.core.network.data

import kotlinx.serialization.Serializable

@Serializable
data class Character(
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val origin: String,
    val location: String,
    val image: String,
)
