package tech.droidzed.dragons.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun DragonDetailsScreen(d_id: String) {
	Column(modifier = Modifier.fillMaxSize()) {

		Text("Dragon $d_id detail screen")
	}

}
