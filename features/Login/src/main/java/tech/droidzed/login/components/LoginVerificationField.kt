package tech.droidzed.login.components

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
fun LoginVerificationField (
	verify: String,
	modifier: Modifier,
	verifyError: Boolean,
	focusManager: FocusManager,
	verificationQuestion: String,
	onVerifyValueChange: (String) -> Unit
){

	OutlinedTextField(
		modifier = modifier,
		keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
		keyboardActions = KeyboardActions(onNext = {
			focusManager.moveFocus(
				FocusDirection.Down
			)
		}),
		value = verify,
		isError = verifyError,
		singleLine = true,
		onValueChange = { onVerifyValueChange(verify) },
		label = { Text("Verification")  },
		placeholder = { Text("What is the answer to $verificationQuestion?")  }
	)
}
