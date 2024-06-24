package com.dara.wubba.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import com.dara.wubba.ui.SharedViewModel
import com.dara.wubba.ui.theme.Dimens

@Composable
fun CharacterDetailScreen(viewModel: SharedViewModel) {
    CharacterDetailScreenContent(viewModel = viewModel)
}

@Composable
fun CharacterDetailScreenContent(
    viewModel: SharedViewModel
) {

    val character by viewModel.selectedCharacter

    if (character != null) {
        Text(
            text = character!!.name,
            fontSize = Dimens.TextSizeLarge,
            color = Color.White,
            modifier = Modifier.padding(
                start = Dimens.PaddingHalf,
                top = Dimens.PaddingHalf
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}
