package tech.droidzed.register.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech.droidzed.commons.layout.CenteredContainer
import tech.droidzed.commons.layout.ComponentStyles
import tech.droidzed.commons.layout.CustomSurface
import tech.droidzed.register.components.ConfirmPasswordField
import tech.droidzed.register.components.PasswordField
import tech.droidzed.register.components.UsernameField
import tech.droidzed.register.utils.RegisterViewModel
import tech.droidzed.theme.Purple200


@Composable
fun RegisterScreen(
	goHome: () -> Unit,
	goLogin: () -> Unit,
	registerViewModel: RegisterViewModel
) {

	val context = LocalContext.current
	val focusManager = LocalFocusManager.current


	// ui components
	CustomSurface(styles = ComponentStyles(padding = 10.dp)) {

		CenteredContainer(styles = ComponentStyles(0.dp, 0.dp, 0.dp)) {

			Text(text = "Sign Up", fontSize = 25.sp)

			Spacer(modifier = Modifier.height(20.dp))

			UsernameField(
				registerViewModel.username,
				registerViewModel.usernameError,
				focusManager,
				onUsernameValueChange = { registerViewModel.onUsernameValueChange(registerViewModel.username) }
			)

			Spacer(modifier = Modifier.height(20.dp))

			PasswordField(
				registerViewModel.password,
				registerViewModel.passwordError,
				registerViewModel.passwordVisible,
				focusManager,
				onVisibilityUpdate = { registerViewModel.onVisibilityUpdate() },
				onPasswordValueUpdate = { registerViewModel.onPasswordValueChange(registerViewModel.password) }
			)

			Spacer(modifier = Modifier.height(20.dp))

			ConfirmPasswordField(
				registerViewModel.confirmPassword,
				registerViewModel.passwordError,
				registerViewModel.passwordVisible,
				focusManager,
				onVisibilityUpdate = { registerViewModel.onVisibilityUpdate() },
				onConfirmPasswordValueUpdate = {
					registerViewModel.onConfirmPasswordValueChange(registerViewModel.confirmPassword)
				}
			)

			Spacer(modifier = Modifier.height(20.dp))

			Button(
				modifier = Modifier.fillMaxWidth(),
				content = { Text(text = "Register") },
				onClick = { registerViewModel.registerUser(goHome, context) }
			)

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
					onClick = { goLogin() }
				)
			}
		}
	}
}
