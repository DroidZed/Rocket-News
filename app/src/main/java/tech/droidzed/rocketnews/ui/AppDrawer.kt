package tech.droidzed.rocketnews.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tech.droidzed.rocketnews.utils.DrawerScreens

@Composable
fun AppDrawer(onDestinationClicked: (String) -> Unit) {

	val screens = listOf(
		DrawerScreens.Home,
		DrawerScreens.Launches,
		DrawerScreens.Dragons,
		DrawerScreens.Missions,
		DrawerScreens.Rockets,
		DrawerScreens.SpaceXInfo,
	)

	Column {
		Card(
			elevation = 2.dp,
			content = {
				Text(text = "Rocket News 🚀")
			},
			modifier = Modifier.fillMaxWidth()
		)
		LazyColumn(
			verticalArrangement = Arrangement.spacedBy(4.dp)
		) {
			items(screens) { screen ->
				Card(modifier = Modifier
					.fillMaxWidth()
					.clickable { onDestinationClicked(screen.route) }) {
					Text(
						text = screen.title,
						style = MaterialTheme.typography.h6,
					)
				}
			}
		}
	}
}
