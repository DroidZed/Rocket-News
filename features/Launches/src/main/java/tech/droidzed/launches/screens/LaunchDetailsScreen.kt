package tech.droidzed.launches.screens

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import tech.droidzed.commons.layout.ComponentStyles
import tech.droidzed.commons.layout.CustomColumn
import tech.droidzed.commons.layout.CustomSurface


@Composable
fun LaunchDetailsScreen(
	goHome: () -> Unit,
	goMission: (id: String) -> Unit
) {
	CustomSurface(styles = ComponentStyles()) {

		CustomColumn(styles = ComponentStyles()) {

			Text("Launches screen")

			Button(onClick = { goHome() }, content = { Text("Home") })
			Button(onClick = { goMission("13") }, content = { Text("Mission 13") })
		}
	}

}
