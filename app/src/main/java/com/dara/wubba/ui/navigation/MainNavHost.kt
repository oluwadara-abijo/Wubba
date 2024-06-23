package com.dara.wubba.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dara.wubba.ui.composables.CharacterDetailScreen
import com.dara.wubba.ui.composables.CharacterListScreen
import com.dara.wubba.ui.navigation.Screen.CharacterDetail
import com.dara.wubba.ui.navigation.Screen.CharacterList


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
        startDestination = CharacterList.route
    ) {
        composable(CharacterList.route) {
            CharacterListScreen(
                openCharacterDetail = {
                    navController.navigate(route = CharacterDetail.route)
                })
        }
        composable(CharacterDetail.route) {
            CharacterDetailScreen()
        }
    }
}

//Navigation routes
sealed class Screen(val route: String) {
    data object CharacterList : Screen("character_list")
    data object CharacterDetail : Screen("character_detail")
}
