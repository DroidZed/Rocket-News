package tech.droidzed.rocketnews.ui

import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import tech.droidzed.model.Routes
import tech.droidzed.rocketnews.navigation.NavGraph
import tech.droidzed.theme.RocketNewsTheme

@Composable
fun MainScreen() {

	val navController = rememberNavController()
	val drawerState = rememberDrawerState(DrawerValue.Closed)
	val scope = rememberCoroutineScope()
	val openDrawer = {
		scope.launch {
			drawerState.open()
		}
	}

	// State of bottomBar, set state to false, if current page route is either "login" or "register"
	val bottomBarState = rememberSaveable { (mutableStateOf(true)) }

	// State of topBar, set state to false, if current page route is either "login" or "register"
	val topBarState = rememberSaveable { (mutableStateOf(true)) }

	val navBackStackEntry by navController.currentBackStackEntryAsState()

	// Control TopBar and BottomBar
	when (navBackStackEntry?.destination?.route) {
		Routes.Login.route -> {
			// Hide BottomBar and TopBar
			bottomBarState.value = false
			topBarState.value = false
		}
		Routes.Register.route -> {
			// Hide BottomBar and TopBar
			bottomBarState.value = false
			topBarState.value = false
		}
		else -> {
			// Show BottomBar and TopBar
			bottomBarState.value = true
			topBarState.value = true
		}
	}

	RocketNewsTheme {
		Scaffold(
			bottomBar = { BottomNavigationBar(navController, bottomBarState) },
			topBar = { TopBar({ openDrawer() }, topBarState) },
			drawerContent = {
				AppDrawer(
					onDestinationClicked = { route ->
						scope.launch { drawerState.close() }
						navController.navigate(route) { launchSingleTop = true }
					}
				)
			},
			drawerElevation = 2.dp,
			drawerGesturesEnabled = true,
			scaffoldState = rememberScaffoldState(drawerState)
		) { NavGraph(navController) }
	}
}
