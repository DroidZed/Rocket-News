package tech.droidzed.rocketnews.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import tech.droidzed.contact.screens.ContactScreen
import tech.droidzed.dragons.screens.details.DragonDetailsScreen
import tech.droidzed.dragons.screens.list.DragonsScreen
import tech.droidzed.home.screens.HomeScreen
import tech.droidzed.launches.screens.details.LaunchDetailsScreen
import tech.droidzed.launches.screens.list.LaunchesScreen
import tech.droidzed.login.screens.LoginScreen
import tech.droidzed.missions.screens.details.MissionDetailsScreen
import tech.droidzed.missions.screens.list.MissionsScreen
import tech.droidzed.model.Routes
import tech.droidzed.profile.screens.bookmarks.BookmarksScreen
import tech.droidzed.profile.screens.profile.ProfileScreen
import tech.droidzed.register.screens.RegisterScreen
import tech.droidzed.rockets.screens.details.RocketDetailsScreen
import tech.droidzed.rockets.screens.list.RocketsScreen
import tech.droidzed.spacex_info.screens.SpaceXInfoScreen

@Composable
fun NavGraph(navHostController: NavHostController) {

	NavHost(
		navController = navHostController,
		startDestination = Routes.Home.route
	) {

		composable(route = Routes.Bookmarks.route) { BookmarksScreen() }
		composable(route = Routes.Contact.route) { ContactScreen() }
		composable(route = Routes.SpaceXInfo.route) { SpaceXInfoScreen() }

		composable(route = Routes.Home.route) { HomeScreen(navHostController) }
		composable(route = Routes.Login.route) { LoginScreen(navHostController) }
		composable(route = Routes.Register.route) { RegisterScreen(navHostController) }
		composable(route = Routes.Profile.route) { ProfileScreen(navHostController) }
		composable(route = Routes.Launches.route) { LaunchesScreen(navHostController) }
		composable(route = Routes.Dragons.route) { DragonsScreen(navHostController) }
		composable(route = Routes.Rockets.route) { RocketsScreen(navHostController) }
		composable(route = Routes.Missions.route) { MissionsScreen(navHostController) }

		composable(route = "${Routes.Missions.route}/{id}") {
			MissionDetailsScreen(m_id = it.arguments?.getString("id")!!)
		}
		composable(route = "${Routes.Launches.route}/{id}") {

			LaunchDetailsScreen(
				l_id = it.arguments?.getString("id")!!,
				navHostController
			)
		}
		composable(route = "${Routes.Dragons.route}/{id}") {
			DragonDetailsScreen(d_id = it.arguments?.getString("id")!!)
		}
		composable(route = "${Routes.Rockets.route}/{id}") {
			RocketDetailsScreen(r_id = it.arguments?.getString("id")!!)
		}
	}
}
