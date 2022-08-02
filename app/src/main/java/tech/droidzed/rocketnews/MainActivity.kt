package tech.droidzed.rocketnews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import net.lachlanmckee.hilt.compose.navigation.factory.addNavigationFactoriesNavigation
import tech.droidzed.apptheme.theme.RocketNewsTheme
import tech.droidzed.sharedlib.Routes

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			// app nav
			RocketNewsTheme {
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colors.background
				) {
					JetpackNavigationHiltApp()
				}
			}
		}
	}

	@Composable
	fun JetpackNavigationHiltApp() {

		val navController = rememberNavController()

		Scaffold(
			content = {
				val context = LocalContext.current
				NavHost(
					navController,
					startDestination = tech.droidzed.sharedlib.Routes.Home.route
				) {
					addNavigationFactoriesNavigation(context, navController)
				}
			},
			bottomBar = {
				BottomAppBar {
					NavigationButton(
						navController = navController,
						route = tech.droidzed.sharedlib.Routes.Home.route,
						label = "Home"
					)
					Spacer(Modifier.weight(1f, true))
					NavigationButton(
						navController = navController,
						route = tech.droidzed.sharedlib.Routes.Contact.route,
						label = "Contact"
					)
				}
			}
		)
	}

	@Composable
	fun NavigationButton(navController: NavController, route: String, label: String) {
		Button(
			onClick = {
				navController.popBackStack(
					route = tech.droidzed.sharedlib.Routes.Home.route,
					inclusive = false
				)
				if (route != tech.droidzed.sharedlib.Routes.Home.route) {
					navController.navigate(route) {
						launchSingleTop = true
					}
				}
			},
			content = {
				Text(label, color = Color.White)
			}
		)
	}
}
