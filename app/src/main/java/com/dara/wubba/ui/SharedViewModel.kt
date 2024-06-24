package com.dara.wubba.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.dara.core.network.data.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Facilitates data sharing between the list and the detail screens.
 * When a character is selected from the list screen, it is stored in the selectedCharacter state
 * so that it can be used in the detail screen.
 */
@HiltViewModel
class SharedViewModel @Inject constructor() : ViewModel() {

    private val _selectedCharacter = mutableStateOf<Character?>(null)
    val selectedCharacter: State<Character?> = _selectedCharacter

    fun selectCharacter(character: Character) {
        _selectedCharacter.value = character
    }
}
