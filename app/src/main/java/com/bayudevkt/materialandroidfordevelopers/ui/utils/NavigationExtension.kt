package com.bayudevkt.materialandroidfordevelopers.ui.utils

import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController

val NavController.canGoBack get() = this.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED

fun NavController.popBackStack2() = if (this.canGoBack) popBackStack() else false