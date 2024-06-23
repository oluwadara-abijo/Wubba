package com.dara.wubba.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.dara.wubba.ui.navigation.MainNavHost
import com.dara.wubba.ui.theme.WubbaTheme

/**
 *
 * This is the root composable function for the application, responsible for setting up the main
 * UI structure and integrating the navigation graph.
 */

@Composable
internal fun MainApp() {
    val navController = rememberNavController()

    WubbaTheme {
        Scaffold(
            modifier = Modifier.background(MaterialTheme.colorScheme.primary)
        ) { paddingValues ->
            MainNavHost(
                navController = navController,
                modifier = Modifier.padding(paddingValues)
            )

        }
    }

}

@Preview
@Composable
fun MainAppPreview() {
    MainApp()
}

