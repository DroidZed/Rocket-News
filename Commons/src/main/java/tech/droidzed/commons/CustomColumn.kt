package tech.droidzed.commons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun CustomColumn(
	styles: ComponentStyles,
	content: @Composable () -> Unit
) {
	Surface(
		modifier = Modifier
			.padding(styles.padding)
			.fillMaxSize()
	) {
		Column(
			modifier = Modifier.padding(styles.columnPadding),
			verticalArrangement = Arrangement.spacedBy(styles.spacing),
			horizontalAlignment = Alignment.CenterHorizontally,
		) {
			content()
		}
	}
}
