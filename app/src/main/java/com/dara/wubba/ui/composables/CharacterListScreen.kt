package com.dara.wubba.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.hilt.navigation.compose.hiltViewModel
import com.dara.core.network.data.Character
import com.dara.wubba.R
import com.dara.wubba.ui.CharactersViewModel
import com.dara.wubba.ui.theme.Dimens.PaddingDefault
import com.dara.wubba.ui.theme.Dimens.TextSizeTitle
import kotlinx.coroutines.launch

@Composable
fun CharacterListScreen(
    openCharacterDetail: (Character) -> Unit
) {
    CharacterListScreenContent(
        viewModel = hiltViewModel(),
        openCharacterDetail = openCharacterDetail
    )
}

@Composable
private fun CharacterListScreenContent(
    viewModel: CharactersViewModel,
    openCharacterDetail: (Character) -> Unit
) {

    val state by viewModel.uiState
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }


    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { paddingValues ->
        if (!state.errorMessage.isNullOrEmpty()) {
            LaunchedEffect(key1 = state.errorMessage) {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar(state.errorMessage!!)
                }
            }
        }

        Column(modifier = Modifier.padding(paddingValues)) {
            Text(
                text = stringResource(R.string.characters),
                fontWeight = Bold,
                fontSize = TextSizeTitle
            )

            Spacer(modifier = Modifier.padding(PaddingDefault))

            ProgressBar(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                loading = state.isLoading
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(top = PaddingDefault)
            ) {
                items(state.characters) { item ->
                    CharacterCard(
                        character = item,
                        openCharacterDetail = openCharacterDetail
                    )
                }

            }
        }
    }
}
