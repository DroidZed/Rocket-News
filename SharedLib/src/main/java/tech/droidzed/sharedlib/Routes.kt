package tech.droidzed.sharedlib

sealed class Routes(val route: String) {
	object Login : Routes("login")
	object Register : Routes("register")
	object Home : Routes("home")
	object Contact : Routes("contact")
	object Dragons : Routes("dragons")
	object Launches : Routes("launches")
	object Missions : Routes("missions")
	object Rockets : Routes("rockets")
	object RocketInfo : Routes("rockets/{rocketId}")
	object DragonInfo : Routes("dragons/{dragonId}")
	object LaunchInfo : Routes("launches/{launchId}")
	object MissionInfo : Routes("missions/{missionId}")
	object SpaceXInfo : Routes("spaceX")
}
