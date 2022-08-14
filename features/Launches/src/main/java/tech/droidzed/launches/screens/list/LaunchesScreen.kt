package tech.droidzed.launches.screens.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import tech.droidzed.commons.layout.ComponentStyles
import tech.droidzed.commons.layout.CustomColumn
import tech.droidzed.model.Routes

@Composable
fun LaunchesScreen(navHostController: NavHostController) {

	Column(modifier = Modifier.fillMaxSize()) {

		CustomColumn(styles = ComponentStyles()) {

			Text("Launches screen")
			val id = "123"
			Button(onClick = {
				navHostController.navigate("${Routes.Launches.route}/$id") {
					launchSingleTop = true
				}
			}, content = { Text("Launch $id") })
		}
	}

}
