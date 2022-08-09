package tech.droidzed.register.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.text.input.ImeAction


@Composable
fun UsernameField(
	username: String,
	usernameError: Boolean,
	focusManager: FocusManager,
	onUsernameValueChange: (String) -> Unit
) {
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
		onValueChange = { onUsernameValueChange(username) },
		label = { Text("Username") }
	)
}
