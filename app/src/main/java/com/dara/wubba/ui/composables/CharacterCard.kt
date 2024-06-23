package com.dara.wubba.ui.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis
import coil.compose.AsyncImage
import com.dara.core.network.data.Character
import com.dara.wubba.R
import com.dara.wubba.ui.theme.BlackText
import com.dara.wubba.ui.theme.Dimens.CardHeight
import com.dara.wubba.ui.theme.Dimens.PaddingDefault
import com.dara.wubba.ui.theme.Dimens.PaddingHalf
import com.dara.wubba.ui.theme.Dimens.PaddingLarge
import com.dara.wubba.ui.theme.Dimens.PaddingSmall
import com.dara.wubba.ui.theme.Dimens.TextSizeDefault
import com.dara.wubba.ui.theme.Dimens.TextSizeLarge
import com.dara.wubba.ui.theme.GreyText

@Composable
fun CharacterCard(
    character: Character,
    openCharacterDetail: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = White),
        modifier = Modifier
            .height(CardHeight)
            .padding(
                bottom = PaddingLarge,
                end = PaddingDefault
            ),
        onClick = { openCharacterDetail() }
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxWidth(),
            model = character.image,
            contentDescription = character.name,
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = character.name,
            fontSize = TextSizeLarge,
            color = BlackText,
            modifier = Modifier.padding(
                start = PaddingHalf,
                top = PaddingHalf
            ),
            maxLines = 1,
            overflow = Ellipsis
        )
        Row(
            modifier = Modifier.padding(
                start = PaddingHalf,
                top = PaddingSmall,
            )
        ) {
            Text(
                text = stringResource(R.string.status),
                fontSize = TextSizeDefault,
                color = GreyText,
            )

            Text(
                text = character.status,
                fontSize = TextSizeDefault,
                color = BlackText,
            )
        }
    }
}
