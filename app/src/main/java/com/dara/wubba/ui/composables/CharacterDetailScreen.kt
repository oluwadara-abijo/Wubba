package com.dara.wubba.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import com.dara.wubba.ui.theme.Dimens

@Composable
fun CharacterDetailScreen() {
    Text(
        text = "Character detail screen",
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
