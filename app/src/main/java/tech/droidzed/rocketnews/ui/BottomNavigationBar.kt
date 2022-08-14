package tech.droidzed.rocketnews.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import tech.droidzed.model.Routes

data class BarItem(
	val title: String,
	val image: ImageVector,
	val route: String,
)

@Composable
fun BottomNavigationBar(
	navHostController: NavHostController,
	bottomBarState: MutableState<Boolean>,
) {

	val navBarItems = listOf(
		BarItem(
			title = "Profile",
			image = Icons.Filled.Person,
			route = Routes.Profile.route
		),
		BarItem(
			title = "Home",
			image = Icons.Filled.Home,
			route = Routes.Home.route
		),
		BarItem(
			title = "Contact",
			image = Icons.Filled.Send,
			route = Routes.Contact.route
		),
	)

	AnimatedVisibility(
		visible = bottomBarState.value,
		enter = slideInVertically(initialOffsetY = { it }),
		exit = slideOutVertically(targetOffsetY = { it }),
		content = {
			BottomNavigation {

				val navBackStackEntry by navHostController.currentBackStackEntryAsState()
				val currentRoute = navBackStackEntry?.destination?.route

				navBarItems.forEach { navItem ->
					BottomNavigationItem(
						selected = currentRoute == navItem.route,
						onClick = {
							navHostController.navigate(navItem.route) {
								navHostController.graph.startDestinationRoute?.let { screen_route ->
									popUpTo(screen_route)
								}
								launchSingleTop = true
							}
						},
						icon = {
							Icon(
								imageVector = navItem.image,
								contentDescription = navItem.title
							)
						},
						label = { Text(text = navItem.title) },
					)
				}
			}
		})
}
