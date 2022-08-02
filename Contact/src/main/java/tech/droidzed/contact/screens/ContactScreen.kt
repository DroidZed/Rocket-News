package tech.droidzed.contact.screens

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import tech.droidzed.commons.ComponentStyles
import tech.droidzed.commons.CustomColumn

@Composable
fun ContactScreen(navController: NavHostController) {
	CustomColumn(
		styles = ComponentStyles()
	) {
		Text(text = "Contact page !")
		Button(onClick = { navController.navigateUp() }) {
			Text("Click me to go back!")
		}
	}

}
