package com.stefan.chipdogs.navigation

import androidx.navigation.NavController
import com.stefan.chipdogs.navigation.Routes.ALL_DOG_BREEDS_ROUTE
import com.stefan.chipdogs.navigation.Routes.SELECTED_DOG_BREED_ROUTE
import com.stefan.chipdogs.navigation.Screen.ALL_DOG_BREEDS_SCREEN
import com.stefan.chipdogs.navigation.Screen.SELECTED_DOG_BREED_SCREEN

object Screen {
    const val ALL_DOG_BREEDS_SCREEN = "all_dogs"
    const val SELECTED_DOG_BREED_SCREEN = "selected_dog"
}

object Routes {
    const val ALL_DOG_BREEDS_ROUTE = ALL_DOG_BREEDS_SCREEN
    const val SELECTED_DOG_BREED_ROUTE = SELECTED_DOG_BREED_SCREEN
}


sealed class Destinations(val route: String) {

    class AllDogBreedsDestination : Destinations(route = ALL_DOG_BREEDS_ROUTE)

    class SelectedDogBreedDestination : Destinations(route = SELECTED_DOG_BREED_ROUTE)
}


class NavigationActions(private val navController: NavController) {

    fun navigateToDestination(destinations: Destinations) {
        when (destinations) {
            is Destinations.AllDogBreedsDestination -> {
                navController.navigate(ALL_DOG_BREEDS_ROUTE) {

                }
            }

            is Destinations.SelectedDogBreedDestination -> {
                navController.navigate(SELECTED_DOG_BREED_ROUTE)
            }
        }
    }
}