package tech.droidzed.dragons.screens.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import tech.droidzed.model.Routes

@Composable
fun DragonsScreen(navHostController: NavHostController) {

	val id = "123"
	Column(modifier = Modifier.fillMaxSize()) {

		Text("Dragons screen")
		Button(onClick = { navHostController.navigate("${Routes.Dragons.route}/$id") },
			content = { Text("Dragon $id") })
	}
}
