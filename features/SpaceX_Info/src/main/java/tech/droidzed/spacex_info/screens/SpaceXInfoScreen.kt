package tech.droidzed.spacex_info.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch

@Composable
fun SpaceXInfoScreen() {

	val infoScreenViewModel = hiltViewModel<SpaceXInfoViewModel>()

	val coroutineScope = rememberCoroutineScope()

	coroutineScope.launch {
		infoScreenViewModel.loadSpaceXData()
	}

	Column {
		Text(text ="company info:  ${infoScreenViewModel.data.name?: "placeholder"}")
	}
}
