package tech.droidzed.home.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import tech.droidzed.commons.ComponentStyles
import tech.droidzed.commons.CustomSurface

@Composable
fun HomeScreen(navController: NavHostController) {
	CustomSurface(
		styles = ComponentStyles()
	) {
		Column {
			Text(text = "Hello there !")
			Button(onClick = { navController.navigateUp() }) {
				Text("Click me to go back!")
			}
			LazyColumn {
				// TODO: add the SpaceX Content here !!
			}
		}
	}
}
