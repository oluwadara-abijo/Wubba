package com.dara.network.data

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class InfoApiModel(
    val count: Int,
    val pages: Int,
    val next: String,
    @Contextual val prev: Any?,
)
