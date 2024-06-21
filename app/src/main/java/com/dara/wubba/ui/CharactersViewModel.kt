package com.dara.wubba.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dara.core.network.CharactersRepository
import com.dara.core.network.data.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val repository: CharactersRepository
) : ViewModel() {

    private val _uiState = mutableStateOf(CharactersUiState())
    val uiState: State<CharactersUiState> = _uiState

    init {
        getCharacters()
    }

    private fun getCharacters() {
        updateState(isLoading = true)
        viewModelScope.launch {
            val result = repository.fetchCharacters()
            result.fold(
                onSuccess = { characters ->
                    println("Success: $characters")
                    updateState(
                        characters = characters,
                        isLoading = false
                    )
                },
                onFailure = { exception ->
                    println("Exception: $exception")
                    updateState(
                        isLoading = false
                    )
                })
        }
    }

    // Updates the current state of the UI
    private fun updateState(
        characters: List<Character>? = null,
        isLoading: Boolean? = null
    ) {
        if (characters != null) {
            _uiState.value = _uiState.value.copy(characters = characters)
        }
        if (isLoading != null) {
            _uiState.value = _uiState.value.copy(isLoading = isLoading)
        }
    }
}
