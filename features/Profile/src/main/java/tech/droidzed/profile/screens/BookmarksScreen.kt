package tech.droidzed.profile.screens

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import tech.droidzed.commons.layout.ComponentStyles
import tech.droidzed.commons.layout.CustomColumn

@Composable
fun BookmarksScreen(
	goProfile: () -> Unit
) {
	CustomColumn(
		styles = ComponentStyles()
	) {
		Text(text = "Bookmarks page !")
		Button(onClick = { goProfile() }, content = { Text("Click me to go back!") })
	}

}
