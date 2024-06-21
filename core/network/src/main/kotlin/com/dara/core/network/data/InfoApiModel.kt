package com.dara.core.network.data

import kotlinx.serialization.Serializable

@Serializable
internal data class InfoApiModel(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?,
)
