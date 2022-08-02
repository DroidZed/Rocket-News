package tech.droidzed.login.screens

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
import tech.droidzed.login.services.LoginServiceImpl
import tech.droidzed.sharedlib.LoginResponse
import tech.droidzed.sharedlib.LoginResponseCode
import tech.droidzed.sharedlib.Routes

@Composable
fun LoginScreen(navController: NavHostController) {

	// app state

	val context = LocalContext.current
	val focusManager = LocalFocusManager.current

	var username by remember { mutableStateOf("") }
	var password by remember { mutableStateOf("") }
	var verif by remember { mutableStateOf("") }

	var passwordVisible by rememberSaveable { mutableStateOf(false) }
	var usernameError by remember { mutableStateOf(false) }
	var passwordError by remember { mutableStateOf(false) }
	var verifyError by remember { mutableStateOf(false) }

	val verificationOperation = LoginServiceImpl.generateRandomVerificationTests()

	// ui components
	CustomSurface(styles = ComponentStyles(padding = 10.dp)) {

		CenteredContainer(styles = ComponentStyles(0.dp, 5.dp, 20.dp)) {

			Text(
				text = "Login",
				style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive)
			)

			Spacer(modifier = Modifier.height(10.dp))

			OutlinedTextField(modifier = Modifier.fillMaxWidth(),
				keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
				keyboardActions = KeyboardActions(onNext = {
					focusManager.moveFocus(
						FocusDirection.Down
					)
				}),
				value = username,
				isError = usernameError,
				singleLine = true,
				onValueChange = { username = it;usernameError = false },
				label = { Text("Username") }
			)

			Spacer(modifier = Modifier.height(10.dp))

			OutlinedTextField(
				value = password,
				singleLine = true,
				modifier = Modifier.fillMaxWidth(),
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

					IconButton(onClick = { passwordVisible = !passwordVisible }) {
						Icon(
							imageVector = image,
							description
						)
					}
				},

				onValueChange = { password = it; passwordError = false },

				label = { Text("Password") }
			)

			Spacer(modifier = Modifier.height(10.dp))

			OutlinedTextField(modifier = Modifier.fillMaxWidth(),
				value = verif,
				isError = verifyError,
				singleLine = true,
				keyboardOptions = KeyboardOptions(
					keyboardType = KeyboardType.Number,
					imeAction = ImeAction.Done
				),
				keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
				onValueChange = { verif = it; verifyError = false },
				placeholder = { Text(text = "What's the answer to $verificationOperation?") },
				label = { Text("Verify Your Login") }
			)

			Spacer(modifier = Modifier.height(10.dp))

			Button(modifier = Modifier.fillMaxWidth(),

				onClick = {

					when (LoginServiceImpl.handleLogin(
						username,
						password
					)) {
						LoginResponseCode.NOT_FOUND -> {
							makeToast(context, LoginResponse.Unavailable.resp)
							passwordError = true
							usernameError = true
						}
						LoginResponseCode.WRONG_CREDENTIALS -> {
							makeToast(context, LoginResponse.Credentials.resp)
							passwordError = true
							usernameError = true
						}
						LoginResponseCode.SUCCESS -> {

							if (LoginServiceImpl.handleLoginVerification(
									verificationOperation,
									verif
								)
							) {

								makeToast(context, LoginResponse.Success.resp)
								navController.navigate(route = Routes.Home.route) {
									popUpTo(
										Routes.Login.route
									)
								}
							}

							makeToast(context, LoginResponse.VerifyInput.resp)
							verifyError = true
						}
					}

				}) { Text(text = "Login") }

			Spacer(modifier = Modifier.height(5.dp))

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
					onClick = { navController.navigate(Routes.Register.route) }
				)
			}
		}
	}
}
