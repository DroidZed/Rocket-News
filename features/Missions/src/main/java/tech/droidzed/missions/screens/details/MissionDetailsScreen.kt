package tech.droidzed.missions.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable


@Composable
fun MissionDetailsScreen(
	m_id: String
) {
	Column {
		Text("Mission $m_id is here !")
	}
}
