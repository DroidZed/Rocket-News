package tech.droidzed.missions.screens.list

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import tech.droidzed.model.Routes

@Composable
fun MissionsScreen(navHostController: NavHostController) {

	Column {
		val id = "123"
		Button(
			onClick = { navHostController.navigate("${Routes.Missions.route}/$id") },
			content = { Text("Go to mission $id") }
		)
	}
}
