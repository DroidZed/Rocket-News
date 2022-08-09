package tech.droidzed.launches.screens

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import tech.droidzed.commons.layout.ComponentStyles
import tech.droidzed.commons.layout.CustomColumn
import tech.droidzed.commons.layout.CustomSurface

@Composable
fun LaunchesScreen(
	goHome: () -> Unit,
	goLaunchDetails: (id: String) -> Unit
) {

	CustomSurface(styles = ComponentStyles()) {

		CustomColumn(styles = ComponentStyles()) {

			Text("Launches screen")

			Button(onClick = { goHome() }, content = { Text("Home") })
			Button(onClick = { goLaunchDetails("13") }, content = { Text("Launch 13") })
		}
	}

}
