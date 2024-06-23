package com.dara.wubba.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dara.wubba.ui.composables.CharacterListScreen
import kotlinx.serialization.Serializable


/**
 * Defines the main navigation graph for the application using Jetpack Compose Navigation.
 * It sets up the routes for different screens and handles navigation between them.
 */

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier,
) {

    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = CharacterList.toString()
    ) {
        composable(CharacterList.toString()) { CharacterListScreen() }
    }
}

// Navigation routes
@Serializable
object CharacterList
