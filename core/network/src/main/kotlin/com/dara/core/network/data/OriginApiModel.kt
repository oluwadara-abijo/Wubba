package com.dara.core.network.data

import kotlinx.serialization.Serializable

@Serializable
data class OriginApiModel(
    val name: String,
    val url: String
)
