package tech.droidzed.rockets.screens.list

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import tech.droidzed.model.Routes

@Composable
fun RocketsScreen(navHostController: NavHostController) {

	Column {
		val id = "123"
		Button(
			content = { Text("go rocket details $id") },
			onClick = { navHostController.navigate("${Routes.Rockets.route}/$id") }
		)
	}
}
