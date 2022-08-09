package tech.droidzed.rocketnews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import tech.droidzed.login.utils.LoginViewModel
import tech.droidzed.register.utils.RegisterViewModel
import tech.droidzed.rocketnews.navigation.NavGraph
import tech.droidzed.theme.RocketNewsTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


	private val registerViewModel: RegisterViewModel by viewModels()
	private val loginViewModel: LoginViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {


		super.onCreate(savedInstanceState)
		setContent {

			val navController = rememberNavController()

			// app nav
			RocketNewsTheme {
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colors.background
				) {
					NavGraph(navController, registerViewModel, loginViewModel)
				}
			}
		}
	}
}
