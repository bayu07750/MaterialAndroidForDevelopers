package com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.bayudevkt.materialandroidfordevelopers.ui.GenerateColorsRoute
import com.bayudevkt.materialandroidfordevelopers.ui.Material3Colors
import com.bayudevkt.materialandroidfordevelopers.ui.Material3ComponentDetailRoute
import com.bayudevkt.materialandroidfordevelopers.ui.Material3ComponentsRoute
import com.bayudevkt.materialandroidfordevelopers.ui.Material3Route
import com.bayudevkt.materialandroidfordevelopers.ui.TypographyRoute
import com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.Material3Route
import com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.colors.Material3ColorsRoute
import com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.component.Material3ComponentDetailRoute
import com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.component.Material3ComponentsRoute
import com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.generate.GenerateColorsRoute
import com.bayudevkt.materialandroidfordevelopers.ui.routes.material3.typography.TypographyRoute
import com.bayudevkt.materialandroidfordevelopers.ui.routes.settings.SettingsStateHolder
import com.bayudevkt.materialandroidfordevelopers.ui.utils.popBackStack2

fun NavGraphBuilder.material3Graph(
    navController: NavController,
    settingsStateHolder: SettingsStateHolder,
    onSettings: () -> Unit,
) {
    composable<Material3Route> {
        Material3Route(
            onComponentsClicked = {
                navController.navigate(route = Material3ComponentsRoute)
            },
            onColorsClicked = {
                navController.navigate(route = Material3Colors)
            },
            onTypographyClicked = {
                navController.navigate(route = TypographyRoute)
            },
            onGenerateColorsClicked = {
                navController.navigate(route = GenerateColorsRoute)
            },
            onSettingsClicked = onSettings,
        )
    }
    composable<TypographyRoute> {
        TypographyRoute(
            onBack = {
                navController.popBackStack2()
            },
            onSettingsClicked = onSettings
        )
    }
    composable<Material3Colors> {
        Material3ColorsRoute(
            onBack = {
                navController.popBackStack2()
            },
            onSettingsClicked = onSettings,
        )
    }
    composable<Material3ComponentsRoute> {
        Material3ComponentsRoute(
            onComponentItemClicked = { componentTitle ->
                navController.navigate(route = Material3ComponentDetailRoute(componentTitle = componentTitle))
            },
            onBack = {
                navController.popBackStack2()
            },
            onSettingsClicked = onSettings,
        )
    }
    composable<Material3ComponentDetailRoute> {
        val argComponentTitle = it.toRoute<Material3ComponentDetailRoute>().componentTitle
        Material3ComponentDetailRoute(
            argComponentTitle,
            onComponentItemClicked = { componentTitle ->
                navController.navigate(route = Material3ComponentDetailRoute(componentTitle = componentTitle))
            },
            onBack = {
                navController.popBackStack2()
            },
            onSettingsClicked = onSettings,
        )
    }
    composable<GenerateColorsRoute> {
        GenerateColorsRoute(
            onBack = {
                navController.popBackStack2()
            },
            onSettingsClicked = onSettings,
            settingsStateHolder = settingsStateHolder,
        )
    }
}
