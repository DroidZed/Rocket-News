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
import androidx.compose.runtime.Composable
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
import tech.droidzed.commons.layout.CenteredContainer
import tech.droidzed.commons.layout.ComponentStyles
import tech.droidzed.commons.layout.CustomSurface
import tech.droidzed.login.utils.LoginViewModel
import tech.droidzed.theme.Purple200

@Composable
fun LoginScreen(
	goHome: () -> Unit,
	goRegister: () -> Unit,
	loginViewModel: LoginViewModel
) {

	// component state
	val context = LocalContext.current
	val focusManager = LocalFocusManager.current

	// ui components
	CustomSurface(styles = ComponentStyles(padding = 10.dp)) {

		CenteredContainer(styles = ComponentStyles(0.dp, 5.dp, 20.dp)) {

			Text(
				text = "Login",
				style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive)
			)

			Spacer(modifier = Modifier.height(10.dp))

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
				onValueChange = { loginViewModel.username = it; loginViewModel.usernameError = false  },
				label = { Text("Username")  }
			)

			Spacer(modifier = Modifier.height(10.dp))

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
						onClick = { loginViewModel.passwordVisible = !loginViewModel.passwordVisible },
						content = { Icon(imageVector = image, description) })
				},

				onValueChange = { loginViewModel.password = it; loginViewModel.passwordError = false   },

				label = { Text("Password") }
			)

			Spacer(modifier = Modifier.height(10.dp))

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
				onValueChange = { loginViewModel.verify = it; loginViewModel.verifyError = false   },
				label = { Text("Verification")  },
				placeholder = { Text("What is the answer to ${loginViewModel.randomVerificationTest}?")  }
			)

			Spacer(modifier = Modifier.height(10.dp))

			Button(
				content = { Text(text = "Login") },
				modifier = Modifier.fillMaxWidth(),
				onClick = { loginViewModel.handleLogin(goHome, context) }
			)

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
					onClick = { goRegister() }
				)
			}
		}
	}
}
