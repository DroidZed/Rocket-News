package tech.droidzed.launches.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import tech.droidzed.apollowrapper.LaunchListQuery


@Composable
fun LaunchItem(launch: LaunchListQuery.Launch) {
	Surface {
		Column {
			Text(text = launch.launch_site?.site_name_long.toString())
			Text(text = launch.mission_name.toString())
		}
	}
}

@Composable
fun LaunchList(launches: List<LaunchListQuery.Launch>) {

	LazyColumn {

		items(items = launches) { launch ->
			LaunchItem(launch)
		}
	}
}
