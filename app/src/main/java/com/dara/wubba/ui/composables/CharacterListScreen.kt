package com.dara.wubba.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.hilt.navigation.compose.hiltViewModel
import com.dara.wubba.ui.CharactersViewModel
import com.dara.wubba.ui.theme.Dimens.PaddingDefault
import com.dara.wubba.ui.theme.Dimens.TextSizeTitle

@Composable
fun CharacterListScreen() {
    CharacterListScreenContent(viewModel = hiltViewModel())
}

@Composable
private fun CharacterListScreenContent(
    viewModel: CharactersViewModel
) {

    val state by viewModel.uiState

    Column(modifier = Modifier.padding(PaddingDefault)) {
        Text(
            text = "Characters",
            fontWeight = Bold,
            fontSize = TextSizeTitle
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(top = PaddingDefault)
        ) {
            items(state.characters) { item ->
                CharacterCard(character = item)
            }

        }
    }

}
