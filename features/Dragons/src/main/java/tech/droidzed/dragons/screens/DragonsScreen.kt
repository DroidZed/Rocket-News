package tech.droidzed.dragons.screens

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import tech.droidzed.commons.layout.ComponentStyles
import tech.droidzed.commons.layout.CustomColumn
import tech.droidzed.commons.layout.CustomSurface

@Composable
fun DragonsScreen(
	goHome: () -> Unit,
	goDragonDetails: (id: String) -> Unit
) {

	CustomSurface(styles = ComponentStyles()) {

		CustomColumn(styles = ComponentStyles()) {

			Text("Dragons screen")

			Button(onClick = { goHome() }, content = { Text("Home") })
			Button(onClick = { goDragonDetails("13") }, content = { Text("Dragon 13") })
		}
	}

}
