package com.dara.core.network.data

import kotlinx.serialization.Serializable

@Serializable
internal data class LocationApiModel(
    val name: String,
    val url: String
)
