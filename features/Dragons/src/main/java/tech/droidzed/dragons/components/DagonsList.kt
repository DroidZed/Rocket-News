package tech.droidzed.dragons.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import tech.droidzed.apollowrapper.DragonListQuery
import tech.droidzed.apollowrapper.LaunchListQuery


@Composable
fun DragonItem(dragon: DragonListQuery.Dragon) {
	Surface {
		Column {
			Text(text = dragon.name.toString())
			Text(text = dragon.description.toString())
		}
	}
}

@Composable
fun LaunchList(dragons: List<DragonListQuery.Dragon>) {

	LazyColumn {

		items(items = dragons) { dragon ->
			DragonItem(dragon)
		}
	}
}
