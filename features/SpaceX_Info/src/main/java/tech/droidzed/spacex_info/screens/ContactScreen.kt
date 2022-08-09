package tech.droidzed.spacex_info.screens

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import tech.droidzed.commons.layout.ComponentStyles
import tech.droidzed.commons.layout.CustomColumn

@Composable
fun SpaceXInfoScreen(
	goHome: () -> Unit
) {
	CustomColumn(
		styles = ComponentStyles()
	) {
		Text(text = "SpaceX info page !")
		Button(onClick = { goHome() }, content = { Text("Click me to go home!") })
	}

}
