package tech.droidzed.launches.screens

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import tech.droidzed.commons.ComponentStyles
import tech.droidzed.commons.CustomColumn
import tech.droidzed.commons.CustomSurface
import tech.droidzed.sharedlib.Routes

@Composable
fun LaunchesScreen(navController: NavHostController) {

	CustomSurface(styles = ComponentStyles()) {

		CustomColumn(styles = ComponentStyles()) {

			Text("Launches screen")

			Button(onClick =  {
				navController.navigate(Routes.Home.route)
			}) {
				Text("Home")
			}
		}
	}

}
