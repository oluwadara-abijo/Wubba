package com.dara.core.network.data

import kotlinx.serialization.Serializable

@Serializable
internal data class OriginApiModel(
    val name: String,
    val url: String
)
