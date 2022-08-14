package tech.droidzed.profile.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import tech.droidzed.model.Routes

@Composable
fun ProfileScreen(navHostController: NavHostController) {

	val profileViewModel = hiltViewModel<ProfileViewModel>()

	val coroutineScope = rememberCoroutineScope()

	coroutineScope.launch {
		profileViewModel.loadProfileData()
	}

	Column {

		if (profileViewModel.data.id == 0) {

			Button(onClick = {
				navHostController.navigate(Routes.Login.route) {
					launchSingleTop = true
				}
			}, content = { Text("Login") })
		} else {
			Text(profileViewModel.data.username)
			Button(onClick = {
				navHostController.navigate(Routes.Bookmarks.route) {
					launchSingleTop = true
				}
			}, content = { Text("Bookmarked articles") })
			Button(onClick = {
				profileViewModel.logout()
				navHostController.navigate(Routes.Home.route) {
					launchSingleTop = true
				}
			},
				content = { Text("Logout") })
		}
	}
}
