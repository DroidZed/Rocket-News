package tech.droidzed.commons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun CenteredContainer(
	styles: ComponentStyles,
	content: @Composable () -> Unit
) {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(styles.columnPadding),
		verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.CenterHorizontally,
	) {
		content()
	}
}
