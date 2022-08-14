package tech.droidzed.home.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import tech.droidzed.home.components.HomeCard

@Composable
fun HomeScreen(navHostController: NavHostController) {

	val homeViewModel = hiltViewModel<HomeViewModel>()

	Column(modifier = Modifier.fillMaxSize()) {

		LazyColumn(
			modifier = Modifier.padding(5.dp),
			userScrollEnabled = true,
			verticalArrangement = Arrangement.spacedBy(4.dp),
			contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
			content = {
				items(homeViewModel.listItems) { item ->
					HomeCard(item,
						onClick = { navHostController.navigate(item.route) { launchSingleTop = true  } })
				}
			}
		)

	}
}
