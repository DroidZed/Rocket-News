package tech.droidzed.login.screens

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
import tech.droidzed.login.components.LoginVerificationField
import tech.droidzed.login.components.PasswordField
import tech.droidzed.login.components.UsernameField
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

			UsernameField(
				username = loginViewModel.username,
				modifier = Modifier.fillMaxWidth(),
				usernameError = loginViewModel.usernameError,
				focusManager = focusManager,
				onUsernameValueChange = {
					loginViewModel.onUsernameValueChange(
						loginViewModel.username
					)
				}
			)

			Spacer(modifier = Modifier.height(10.dp))

			PasswordField(
				loginViewModel.password,
				loginViewModel.passwordError,
				loginViewModel.passwordVisible,
				focusManager,
				modifier = Modifier.fillMaxWidth(),
				onVisibilityUpdate = { loginViewModel.onVisibilityUpdate() },
				onPasswordValueChange = {
					loginViewModel.onPasswordValueChange(
						loginViewModel.password
					)
				}
			)

			Spacer(modifier = Modifier.height(10.dp))

			LoginVerificationField(
				verify = loginViewModel.verify,
				modifier = Modifier.fillMaxWidth(),
				verifyError = loginViewModel.verifyError,
				focusManager,
				verificationQuestion = loginViewModel.randomVerificationTest,
				onVerifyValueChange = { loginViewModel.onVerifyValueChange(loginViewModel.verify) }
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
