package tech.droidzed.login.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import tech.droidzed.login.utils.LoginViewModel
import tech.droidzed.theme.Purple200

@Composable
fun LoginScreen(navHostController: NavHostController) {

	// component state
	val context = LocalContext.current
	val focusManager = LocalFocusManager.current

	val loginViewModel = hiltViewModel<LoginViewModel>()

	// ui components
	LazyColumn(
		userScrollEnabled = true,
		verticalArrangement = Arrangement.spacedBy(10.dp),
		horizontalAlignment = Alignment.CenterHorizontally,
		contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
	) {

		item {
			Text(
				text = "Login",
				style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive)
			)
		}

		item {
			OutlinedTextField(
				modifier = Modifier.fillMaxWidth(),
				keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
				keyboardActions = KeyboardActions(onNext = {
					focusManager.moveFocus(
						FocusDirection.Down
					)
				}),
				value = loginViewModel.username,
				isError = loginViewModel.usernameError,
				singleLine = true,
				onValueChange = {
					loginViewModel.username = it; loginViewModel.usernameError = false
				},
				label = { Text("Username") }
			)
		}

		item {
			OutlinedTextField(
				value = loginViewModel.password,
				singleLine = true,
				modifier = Modifier.fillMaxWidth(),
				isError = loginViewModel.passwordError,
				visualTransformation = if (loginViewModel.passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
				keyboardOptions = KeyboardOptions(
					keyboardType = KeyboardType.Password,
					imeAction = ImeAction.Next
				),
				keyboardActions = KeyboardActions(onNext = {
					focusManager.moveFocus(
						FocusDirection.Down
					)
				}),
				trailingIcon = {

					val image =
						if (loginViewModel.passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff

					val description =
						if (loginViewModel.passwordVisible) "Hide password" else "Show password"

					IconButton(
						onClick = {
							loginViewModel.passwordVisible =
								!loginViewModel.passwordVisible
						},
						content = { Icon(imageVector = image, description) })
				},

				onValueChange = {
					loginViewModel.password = it; loginViewModel.passwordError = false
				},

				label = { Text("Password") }
			)
		}

		item {
			OutlinedTextField(
				modifier = Modifier.fillMaxWidth(),
				keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
				keyboardActions = KeyboardActions(onNext = {
					focusManager.moveFocus(
						FocusDirection.Down
					)
				}),
				value = loginViewModel.verify,
				isError = loginViewModel.verifyError,
				singleLine = true,
				onValueChange = {
					loginViewModel.verify = it; loginViewModel.verifyError = false
				},
				label = { Text("Verification") },
				placeholder = { Text("What is the answer to ${loginViewModel.randomVerificationTest}?") }
			)
		}

		item {
			Button(
				content = { Text(text = "Login") },
				modifier = Modifier.fillMaxWidth(),
				onClick = { loginViewModel.handleLogin(navHostController, context) }
			)
		}

		item {
			Row {
				Text(
					text = "Don't have an account? ",
					style = TextStyle(fontSize = 15.sp, fontFamily = FontFamily.Default),
				)
				ClickableText(
					text = AnnotatedString("Join us Now!"),
					style = TextStyle(
						fontSize = 15.sp,
						fontFamily = FontFamily.Default,
						color = Purple200
					),
					onClick = { loginViewModel.teleportToRegister(navHostController) }
				)
			}
		}
	}
}
