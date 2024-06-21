package com.dara.core.network

import com.dara.core.network.data.CharactersApiModel
import retrofit2.http.GET

internal interface CharactersApi {

    @GET("character")
    suspend fun getCharacters(): CharactersApiModel
}
