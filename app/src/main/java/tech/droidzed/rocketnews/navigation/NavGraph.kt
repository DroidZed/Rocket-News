package tech.droidzed.rocketnews.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import tech.droidzed.contact.screens.ContactScreen
import tech.droidzed.dragons.screens.DragonDetailsScreen
import tech.droidzed.dragons.screens.DragonsScreen
import tech.droidzed.home.screens.HomeScreen
import tech.droidzed.launches.screens.LaunchDetailsScreen
import tech.droidzed.launches.screens.LaunchesScreen
import tech.droidzed.login.screens.LoginScreen
import tech.droidzed.login.utils.LoginViewModel
import tech.droidzed.missions.screens.MissionDetailsScreen
import tech.droidzed.missions.screens.MissionsScreen
import tech.droidzed.model.Routes
import tech.droidzed.profile.screens.BookmarksScreen
import tech.droidzed.profile.screens.ProfileScreen
import tech.droidzed.register.screens.RegisterScreen
import tech.droidzed.register.utils.RegisterViewModel
import tech.droidzed.rockets.screens.RocketDetailsScreen
import tech.droidzed.rockets.screens.RocketsScreen
import tech.droidzed.spacex_info.screens.SpaceXInfoScreen

@Composable
fun NavGraph(
	navController: NavHostController,
	registerViewModel: RegisterViewModel,
	loginViewModel: LoginViewModel
) {
	NavHost(
		navController = navController,
		startDestination = Routes.Home.route
	) {

		composable(route = Routes.Home.route) {
			HomeScreen(
				goLaunches = { navController.navigate(Routes.Launches.route) },
				goMissions = { navController.navigate(Routes.Missions.route) },
				goDragons = { navController.navigate(Routes.Dragons.route) },
				goRockets = { navController.navigate(Routes.Rockets.route) },
				goContact = { navController.navigate(Routes.Contact.route) },
				goProfile = { navController.navigate(Routes.Profile.withArgs("${Routes.Profile.id}")) },
				goSpaceXInfo = { navController.navigate(Routes.SpaceXInfo.route) }
			)
		}

		composable(route = Routes.Login.route) {

			LoginScreen(
				goHome = { navController.navigate(Routes.Home.route) },
				goRegister = { navController.navigate(Routes.Register.route) },
				loginViewModel = loginViewModel
			)
		}

		composable(route = Routes.Register.route) {

			RegisterScreen(
				goHome = { navController.navigate(Routes.Home.route) },
				goLogin = { navController.navigate(Routes.Login.route) },
				registerViewModel = registerViewModel
			)
		}

		composable(route = Routes.Profile.withArgs("${Routes.Profile.id}")) {

			ProfileScreen(
				goHome = { navController.navigate(Routes.Home.route) },
				goBookmarks = { navController.navigate(Routes.Bookmarks.withArgs("${Routes.Bookmarks.id}")) },
				goLogin = { navController.navigate(Routes.Login.route)  }
			)
		}

		composable(route = Routes.Bookmarks.withArgs("${Routes.Bookmarks.id}")) {

			BookmarksScreen(
				goProfile = { navController.popBackStack() }
			)
		}

		composable(route = Routes.Contact.route) {

			ContactScreen(goHome = { navController.navigate(Routes.Home.route) })
		}

		composable(route = Routes.SpaceXInfo.route) {

			SpaceXInfoScreen(goHome = { navController.navigate(Routes.Home.route) })
		}

		composable(route = Routes.Launches.route) {

			LaunchesScreen(
				goHome = { navController.navigate(Routes.Home.route) },
				goLaunchDetails = { navController.navigate(Routes.Launches.withArgs(Routes.Launches.id)) }
			)
		}
		composable(route = Routes.Launches.withArgs(Routes.Launches.id)) {

			LaunchDetailsScreen(
				goHome = { navController.navigate(Routes.Home.route) },
				goMission = { navController.navigate(Routes.Missions.withArgs(Routes.Missions.id)) }
			)
		}

		composable(route = Routes.Dragons.route) {

			DragonsScreen(
				goHome = { navController.navigate(Routes.Home.route) },
				goDragonDetails = { navController.navigate(Routes.Dragons.withArgs(Routes.Dragons.id)) }
			)
		}

		composable(route = Routes.Dragons.withArgs(Routes.Dragons.id)) {

			DragonDetailsScreen { navController.navigate(Routes.Home.route) }
		}

		composable(route = Routes.Rockets.route) {

			RocketsScreen(
				goHome = { navController.navigate(Routes.Home.route) },
				goRocketDetails = { navController.navigate(Routes.Rockets.withArgs(Routes.Rockets.id)) }
			)
		}

		composable(route = Routes.Rockets.withArgs(Routes.Rockets.id)) {

			RocketDetailsScreen { navController.navigate(Routes.Home.route) }
		}

		composable(route = Routes.Missions.route) {

			MissionsScreen(
				goHome = { navController.navigate(Routes.Home.route) },
				goMission = { navController.navigate(Routes.Missions.withArgs(Routes.Missions.id)) }
			)
		}

		composable(route = Routes.Missions.withArgs(Routes.Missions.id)) {

			MissionDetailsScreen { navController.navigate(Routes.Home.route) }

		}

	}
}
