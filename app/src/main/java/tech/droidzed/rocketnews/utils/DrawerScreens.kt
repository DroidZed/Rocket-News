package tech.droidzed.rocketnews.utils

import tech.droidzed.model.Routes

sealed class DrawerScreens(val title: String, val route: String) {
	object Home : DrawerScreens("Home", Routes.Home.route)
	object Launches : DrawerScreens("Launches", Routes.Launches.route)
	object Dragons : DrawerScreens("Dragons", Routes.Dragons.route)
	object Missions : DrawerScreens("Missions", Routes.Missions.route)
	object Rockets : DrawerScreens("Rockets", Routes.Rockets.route)
	object SpaceXInfo : DrawerScreens("SpaceXInfo", Routes.SpaceXInfo.route)
}
