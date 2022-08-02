package tech.droidzed.register.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
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
import androidx.navigation.NavHostController
import tech.droidzed.apptheme.theme.Purple200
import tech.droidzed.commons.CenteredContainer
import tech.droidzed.commons.ComponentStyles
import tech.droidzed.commons.CustomSurface
import tech.droidzed.commons.makeToast
import tech.droidzed.register.services.RegisterServiceImpl
import tech.droidzed.sharedlib.ErrorType
import tech.droidzed.sharedlib.RegisterInfo
import tech.droidzed.sharedlib.Routes


@Composable
fun RegisterScreen(navController: NavHostController) {

	// app state

	val context = LocalContext.current
	val focusManager = LocalFocusManager.current

	var username by remember { mutableStateOf("") }
	var password by remember { mutableStateOf("") }
	var confirmPassword by remember { mutableStateOf("") }

	var usernameError by remember { mutableStateOf(false) }
	var passwordError = password != confirmPassword

	var passwordVisible by rememberSaveable { mutableStateOf(false) }

	// ui components
	CustomSurface(styles = ComponentStyles(padding = 10.dp)) {

		CenteredContainer(styles = ComponentStyles(0.dp, 0.dp, 0.dp)) {

			Text(text = "Sign Up", fontSize = 25.sp)

			Spacer(modifier = Modifier.height(20.dp))

			OutlinedTextField(
				modifier = Modifier.fillMaxWidth(),
				value = username,
				singleLine = true,
				isError = usernameError,
				keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
				keyboardActions = KeyboardActions(onNext = {
					focusManager.moveFocus(
						FocusDirection.Down
					)
				}),
				onValueChange = {
					username = it; usernameError = false
				},
				label = { Text("Username") }
			)

			Spacer(modifier = Modifier.height(20.dp))

			OutlinedTextField(
				modifier = Modifier.fillMaxWidth(),
				value = password,
				singleLine = true,
				isError = passwordError,
				visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
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
						if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff

					val description =
						if (passwordVisible) "Hide password" else "Show password"

					IconButton(
						onClick = { passwordVisible = !passwordVisible }
					) { Icon(imageVector = image, description) }
				},
				onValueChange = {
					password = it; passwordError = false
				},
				label = { Text("Password") }
			)

			Spacer(modifier = Modifier.height(20.dp))

			OutlinedTextField(
				modifier = Modifier.fillMaxWidth(),
				value = confirmPassword,
				singleLine = true,
				isError = passwordError,
				visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
				keyboardOptions = KeyboardOptions(
					keyboardType = KeyboardType.Password,
					imeAction = ImeAction.Done
				),
				keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
				trailingIcon = {
					val image = if (passwordVisible) Icons.Filled.Visibility
					else Icons.Filled.VisibilityOff

					val description = if (passwordVisible) "Hide password"
					else "Show password"

					IconButton(onClick = {
						passwordVisible = !passwordVisible
					}) {
						Icon(imageVector = image, description)
					}
				},
				onValueChange = {
					confirmPassword = it; passwordError =
					false
				},
				label = { Text("Confirm Password") }
			)

			Spacer(modifier = Modifier.height(20.dp))

			Button(
				modifier = Modifier.fillMaxWidth(),
				onClick = {

					val signUpData = RegisterInfo(username, password)

					when (RegisterServiceImpl.validateInput(signUpData).first) {

						ErrorType.BOTH -> makeToast(context, "Invalid Credentials")

						ErrorType.USERNAME -> makeToast(
							context,
							"Please check your username !"
						)

						ErrorType.PASSWORD -> makeToast(
							context,
							"Please verify your password !"
						)

						else -> {

							RegisterServiceImpl.handleRegister(signUpData)

							navController.navigate(route = Routes.Home.route)
						}
					}
				}) { Text(text = "Sign Up") }

			Row {
				Text(
					text = "Already have an account? ",
					style = TextStyle(fontSize = 15.sp, fontFamily = FontFamily.Default),
				)
				ClickableText(
					text = AnnotatedString("Login here!"),
					style = TextStyle(
						fontSize = 15.sp,
						fontFamily = FontFamily.Default,
						color = Purple200
					),
					onClick = { navController.navigate(Routes.Login.route) }
				)
			}
		}
	}
}
