package tech.droidzed.rocketnews.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color

@Composable
fun TopBar(
	navIconOnClick: () -> Unit,
	topBarState: MutableState<Boolean>,
) {

	AnimatedVisibility(
		visible = topBarState.value,
		enter = slideInVertically(initialOffsetY = { -it }),
		exit = slideOutVertically(targetOffsetY = { -it }),
		content = {
			TopAppBar(
				title = {
					Text(
						text = "Rocket News",
						color = Color.White
					)
				},
				navigationIcon = {
					IconButton(
						content = { Icon(Icons.Filled.Menu, contentDescription = "") },
						onClick = navIconOnClick
					)
				},
				backgroundColor = MaterialTheme.colors.primaryVariant
			)
		}
	)
}
