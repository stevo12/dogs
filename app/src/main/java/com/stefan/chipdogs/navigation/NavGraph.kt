package com.stefan.chipdogs.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.stefan.chipdogs.presentation.dogbreeds.view.AllDogBreedsScreen
import com.stefan.chipdogs.presentation.selectedbreed.view.SelectedDogScreen

@Composable
fun NavGraph(
    navHostController: NavHostController = rememberNavController(),
    startDestination: String = Routes.ALL_DOG_BREEDS_ROUTE,
    navigationActions: NavigationActions = remember(navHostController) {
        NavigationActions(
            navHostController
        )
    }
) {

    NavHost(
        navController = navHostController,
        startDestination = startDestination
    ) {
        composable(route = Routes.ALL_DOG_BREEDS_ROUTE) {
            AllDogBreedsScreen(onNavigateTo = {
                navigationActions.navigateToDestination(destinations = it)
            })
        }

        composable(route = Routes.SELECTED_DOG_BREED_ROUTE) {
           SelectedDogScreen()
        }
    }

}