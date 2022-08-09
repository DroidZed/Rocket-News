package tech.droidzed.profile.screens

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import tech.droidzed.commons.layout.ComponentStyles
import tech.droidzed.commons.layout.CustomColumn

@Composable
fun ProfileScreen(
	goHome: () -> Unit,
	goBookmarks: () -> Unit,
	goLogin: () -> Unit
) {
	CustomColumn(
		styles = ComponentStyles()
	) {
		Text(text = "Profile page !")
		Button(onClick = { goHome() }, content = { Text("Home") })
		Button(onClick = { goBookmarks() }, content = { Text("Bookmarked articles") })
		Button(onClick = { goLogin() }, content = { Text("Login / Register") })
	}

}
