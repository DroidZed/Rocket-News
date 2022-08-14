package tech.droidzed.register.screens

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
import tech.droidzed.register.utils.RegisterViewModel
import tech.droidzed.theme.Purple200


@Composable
fun RegisterScreen(navHostController: NavHostController) {

	val registerViewModel = hiltViewModel<RegisterViewModel>()

	val context = LocalContext.current
	val focusManager = LocalFocusManager.current

	// ui components
	LazyColumn(
		userScrollEnabled = true,
		verticalArrangement = Arrangement.spacedBy(10.dp),
		horizontalAlignment = Alignment.CenterHorizontally,
		contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
	) {

		item { Text(text = "Sign Up", fontSize = 25.sp) }

		item {
			OutlinedTextField(
				modifier = Modifier.fillMaxWidth(),
				value = registerViewModel.username,
				singleLine = true,
				isError = registerViewModel.usernameError,
				keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
				keyboardActions = KeyboardActions(onNext = {
					focusManager.moveFocus(
						FocusDirection.Down
					)
				}),
				onValueChange = {
					registerViewModel.username = it; registerViewModel.usernameError =
					false
				},
				label = { Text("Username") }
			)
		}

		item {
			OutlinedTextField(
				modifier = Modifier.fillMaxWidth(),
				value = registerViewModel.password,
				singleLine = true,
				isError = registerViewModel.passwordError,
				visualTransformation = if (registerViewModel.passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
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
						if (registerViewModel.passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff

					val description =
						if (registerViewModel.passwordVisible) "Hide password" else "Show password"

					IconButton(
						onClick = {
							registerViewModel.passwordVisible =
								!registerViewModel.passwordVisible
						},
						content = { Icon(imageVector = image, description) }
					)
				},
				onValueChange = {
					registerViewModel.password = it; registerViewModel.passwordError =
					false
				},

				label = { Text("Password") }
			)
		}

		item {
			OutlinedTextField(
				modifier = Modifier.fillMaxWidth(),
				value = registerViewModel.confirmPassword,
				singleLine = true,
				isError = registerViewModel.passwordError,
				visualTransformation = if (registerViewModel.passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
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
						if (registerViewModel.passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff

					val description =
						if (registerViewModel.passwordVisible) "Hide password" else "Show password"

					IconButton(
						onClick = {
							registerViewModel.passwordVisible =
								!registerViewModel.passwordVisible
						},
						content = { Icon(imageVector = image, description) }
					)
				},
				onValueChange = { registerViewModel.confirmPassword = it },

				label = { Text("Confirm Password") }
			)
		}

		item {
			Button(
				modifier = Modifier.fillMaxWidth(),
				content = { Text(text = "Register") },
				onClick = { registerViewModel.registerUser(navHostController, context) }
			)
		}

		item {
			Row {
				Text(
					text = "Already have an account? ",
					style = TextStyle(fontSize = 15.sp, fontFamily = FontFamily.Default)
				)

				ClickableText(
					text = AnnotatedString("Login here!"),
					style = TextStyle(
						fontSize = 15.sp,
						fontFamily = FontFamily.Default,
						color = Purple200
					),
					onClick = { registerViewModel.teleportToLogin(navHostController) }
				)
			}
		}
	}
}
