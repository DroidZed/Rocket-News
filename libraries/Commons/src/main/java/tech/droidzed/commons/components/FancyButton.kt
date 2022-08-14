package tech.droidzed.commons.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Login
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tech.droidzed.theme.RocketNewsTheme

@Composable
fun FancyButton(
	text: String,
	icon: ImageVector,
	onClick: () -> Unit,
) {
	Button(
		onClick = onClick,
		content = {
			Icon(imageVector = icon, contentDescription = "button icon")
			Spacer(modifier = Modifier.width(5.dp))
			Text(text)
		})
}

@Composable
@Preview("Fancy button preview")
fun FancyButtonPreview() {
	RocketNewsTheme {
		FancyButton(
			text = "Login",
			icon = Icons.Filled.Login,
			onClick = { println("hello") })
	}
}
