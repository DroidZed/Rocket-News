package tech.droidzed.home.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

import tech.droidzed.commons.layout.ComponentStyles
import tech.droidzed.commons.layout.CustomSurface

@Composable
fun HomeScreen(
	goLaunches: () -> Unit,
	goMissions: () -> Unit,
	goDragons: () -> Unit,
	goRockets: () -> Unit,
	goContact: () -> Unit,
	goProfile: (id: Int) -> Unit,
	goSpaceXInfo: () -> Unit,
) {
	CustomSurface(
		styles = ComponentStyles()
	) {
		Column {
			Text(text = "Hello there !")
			Button(
				onClick = { goLaunches() },
				content = { Text("Click me to visit Launches") })
			Button(
				onClick = { goMissions() },
				content = { Text("Click me to visit Missions") })
			Button(
				onClick = { goRockets() },
				content = { Text("Click me to visit Rockets") })
			Button(
				onClick = { goDragons() },
				content = { Text("Click me to visit Dragons") })
			Button(
				onClick = { goContact() },
				content = { Text("Click me to visit Contact") })
			Button(
				onClick = { goProfile(1) },
				content = { Text("Click me to go to your profile") })
			Button(
				onClick = { goSpaceXInfo() },
				content = { Text("Click me to go to SpaceX Info") })

			LazyColumn {
				// TODO: add the SpaceX Content here !!
			}
		}
	}
}
