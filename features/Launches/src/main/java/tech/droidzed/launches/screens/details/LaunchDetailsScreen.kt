package tech.droidzed.launches.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import tech.droidzed.model.Routes


@Composable
fun LaunchDetailsScreen(
	l_id: String,
	navHostController: NavHostController,
) {
	Column(modifier = Modifier.fillMaxSize()) {

		Text("Launch $l_id details screen")
		val mId = "123"
		Button(onClick = { navHostController.navigate("${Routes.Missions.route}/$mId") },
			content = { Text("Mission $mId") })
	}
}
