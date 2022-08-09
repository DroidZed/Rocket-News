package tech.droidzed.model

sealed class Routes(val route: String) {

	// static screens
	object Login : Routes("login")
	object Register : Routes("register")
	object Home : Routes("home")
	object Contact : Routes("contact")
	object SpaceXInfo : Routes("spaceX")

	// detailed screens
	object Bookmarks : Routes("bookmarks") { var id = 0 }
	object Profile : Routes("profile") { var id = 0 }
	object Dragons : Routes("dragons") { var id = "id" }
	object Launches : Routes("launches") { var id = "id" }
	object Missions : Routes("missions") { var id = "id" }
	object Rockets : Routes("rockets") { var id = "id" }

	// build navigation path (for screen navigation)
	fun withArgs(vararg args: String): String {
		return buildString {
			append(route)
			args.forEach{ arg -> append("/$arg") }
		}
	}
}
