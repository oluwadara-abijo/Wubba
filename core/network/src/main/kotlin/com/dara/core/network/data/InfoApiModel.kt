package com.dara.core.network.data

import kotlinx.serialization.Serializable

@Serializable
data class InfoApiModel(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?,
)
