package tech.droidzed.home.screens

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import tech.droidzed.home.utils.ItemData
import tech.droidzed.model.Routes

@HiltViewModel
class HomeViewModel : ViewModel() {

	val listItems = listOf(
		ItemData(
			"Rockets",
			"The best rockets ever",
			Routes.Rockets.route
		),
		ItemData(
			"Launches",
			"The various launches of rockets and such!",
			Routes.Launches.route
		),
		ItemData(
			"Missions",
			"The best missions performed by SpaceX rockets!",
			Routes.Missions.route
		),
		ItemData(
			"Dragons",
			"Awesome dragons of spaceX!",
			Routes.Dragons.route
		)
	)
}
