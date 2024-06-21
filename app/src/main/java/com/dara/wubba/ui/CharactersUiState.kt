package com.dara.wubba.ui

import com.dara.core.network.data.Character

data class CharactersUiState(
    val characters: List<Character> = emptyList(),
    val isLoading: Boolean = false
)

