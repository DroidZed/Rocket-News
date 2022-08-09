package tech.droidzed.login.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun PasswordField(
	password: String,
	passwordError: Boolean,
	passwordVisible: Boolean,
	focusManager: FocusManager,
	modifier: Modifier,
	onVisibilityUpdate: () -> Unit,
	onPasswordValueChange: (String) -> Unit
) {
	OutlinedTextField(
		value = password,
		singleLine = true,
		modifier = modifier,
		isError = passwordError,
		visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
		keyboardOptions = KeyboardOptions(
			keyboardType = KeyboardType.Password,
			imeAction = ImeAction.Next
		),
		keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) }),
		trailingIcon = {

			val image =
				if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff

			val description = if (passwordVisible) "Hide password" else "Show password"

			IconButton(
				onClick = onVisibilityUpdate,
				content = { Icon(imageVector = image, description) })
		},

		onValueChange = { onPasswordValueChange(password) },

		label = { Text("Password") }
	)
}
