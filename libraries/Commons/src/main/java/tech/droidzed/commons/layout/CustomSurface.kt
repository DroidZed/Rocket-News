package tech.droidzed.commons.layout

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CustomSurface(
	styles: ComponentStyles,
	content: @Composable () -> Unit
) {
	Surface(
		modifier = Modifier
			.padding(styles.padding)
			.fillMaxSize()
	) { content() }
}
