package tech.droidzed.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tech.droidzed.home.utils.ItemData


@Composable
fun HomeCard(
	data: ItemData,
	onClick: () -> Unit
) {

	Card(
		elevation = 2.dp,
		modifier = Modifier
			.clickable(enabled = true, onClick = onClick)
			.fillMaxWidth()
	) {

		Column {
			Text(data.title)
			Spacer(modifier = Modifier.height(10.dp))
			Text(data.description)
		}
	}
}
