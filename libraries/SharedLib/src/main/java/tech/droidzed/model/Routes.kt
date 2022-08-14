package tech.droidzed.model

sealed class Routes(val route: String) {

	// static screens
	object Login : Routes("login")
	object Register : Routes("register")
	object Home : Routes("home")
	object Contact : Routes("contact")
	object SpaceXInfo : Routes("spaceX")
	object Profile : Routes("profile")
	object Bookmarks : Routes("bookmarks")

	// detailed screens
	object Dragons : Routes("dragons")
	object Launches : Routes("launches")
	object Missions : Routes("missions")
	object Rockets : Routes("rockets")
}
