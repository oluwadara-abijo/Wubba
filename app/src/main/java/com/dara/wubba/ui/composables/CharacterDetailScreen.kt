package com.dara.wubba.ui.composables

import android.graphics.Typeface
import android.widget.TextView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import com.dara.wubba.R
import com.dara.wubba.ui.SharedViewModel
import com.dara.wubba.ui.theme.Dimens
import com.dara.wubba.ui.theme.Dimens.PaddingDefault
import com.dara.wubba.ui.theme.Dimens.TextSizeLarge
import com.dara.wubba.ui.theme.GreyText

@Composable
fun CharacterDetailScreen(
    viewModel: SharedViewModel,
    navigateBack: () -> Unit,
) {
    CharacterDetailScreenContent(
        viewModel = viewModel,
        navigateBack = navigateBack
    )
}

@Composable
fun CharacterDetailScreenContent(
    viewModel: SharedViewModel,
    navigateBack: () -> Unit,
) {

    val selectedCharacter by viewModel.selectedCharacter

    if (selectedCharacter != null) {
        // Not-null assertion because selectedCharacter cannot be null here
        val character = selectedCharacter!!

        Column {

            Box(modifier = Modifier) {
                AsyncImage(
                    modifier = Modifier.fillMaxWidth(),
                    model = character.image,
                    contentDescription = character.name,
                    contentScale = ContentScale.FillWidth
                )
                // Back button
                IconButton(onClick = navigateBack) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "Back",
                    )
                }
            }

            Spacer(modifier = Modifier.padding(PaddingDefault))

            Column(modifier = Modifier.padding(PaddingDefault)) {


                // XML component
                AndroidView(
                    factory = { context ->
                        TextView(context).apply {
                            text = character.name
                            textSize = 40f
                            setTextColor(resources.getColor(R.color.white, resources.newTheme()))
                            typeface = Typeface.DEFAULT_BOLD
                        }
                    }
                )

                Spacer(modifier = Modifier.padding(PaddingDefault))

                InfoRow(title = stringResource(id = R.string.status), value = character.status)
                InfoRow(title = stringResource(R.string.species), value = character.species)
                InfoRow(title = stringResource(R.string.gender), value = character.gender)
                InfoRow(title = stringResource(R.string.origin), value = character.origin)
                InfoRow(title = stringResource(R.string.location), value = character.location)

            }
        }
    }
}

@Composable
fun InfoRow(title: String, value: String) {
    Row(modifier = Modifier.padding(bottom = Dimens.PaddingHalf)) {
        Text(text = "$title: ", color = GreyText, fontSize = TextSizeLarge)
        Text(text = value, color = White, fontSize = TextSizeLarge)
    }
}
