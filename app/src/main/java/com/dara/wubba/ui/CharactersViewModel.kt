package com.dara.wubba.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.dara.core.network.CharactersRepository
import com.dara.core.network.data.Character
import com.dara.core.network.utils.ErrorHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val repository: CharactersRepository,
    private val errorHandler: ErrorHandler,
    private val coroutineScope: CoroutineScope,
) : ViewModel() {

    private val _uiState = mutableStateOf(CharactersUiState())
    val uiState: State<CharactersUiState> = _uiState

    init {
        getCharacters()
    }

    private fun getCharacters() {
        updateState(isLoading = true)
        coroutineScope.launch {
            val result = repository.fetchCharacters()
            result.fold(
                onSuccess = { characters ->
                    updateState(
                        characters = characters,
                        isLoading = false
                    )
                },
                onFailure = { exception ->
                    updateState(
                        isLoading = false,
                        errorMessage = errorHandler.getErrorMessage(exception)
                    )
                })
        }
    }

    // Updates the current state of the UI
    private fun updateState(
        characters: List<Character>? = null,
        isLoading: Boolean? = null,
        errorMessage: String? = null
    ) {
        _uiState.value = _uiState.value.copy(
            characters = characters ?: _uiState.value.characters,
            isLoading = isLoading ?: _uiState.value.isLoading,
            errorMessage = errorMessage ?: _uiState.value.errorMessage
        )
    }
}
