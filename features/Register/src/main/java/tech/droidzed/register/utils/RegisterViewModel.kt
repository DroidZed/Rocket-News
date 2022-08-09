package tech.droidzed.register.utils

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import tech.droidzed.commons.makeToast
import tech.droidzed.model.ResponseType
import tech.droidzed.rocketnewsdatabase.entities.UserEntity
import tech.droidzed.rocketnewsdatabase.repositories.UserRepository
import javax.inject.Inject

/**
 * ## Register flow
 *
 * How to do the validation of the input:
 * 1. check if the username and password are valid values
 * 2. check if the username already exists in the database
 * 3. register the user: save the entry to the database.
 * 4. save the user into the datastore and show the profile screen
 *
 * - two  passes are needed before the full signup...
 */

@HiltViewModel
class RegisterViewModel @Inject constructor(private val userRepository: UserRepository) :
	ViewModel() {

	// State
	var username by mutableStateOf("")
	var password by mutableStateOf("")
	var confirmPassword by mutableStateOf("")

	var passwordVisible by mutableStateOf(false)

	var usernameError by mutableStateOf(false)
	var passwordError = password != confirmPassword

	// Operations on state
	fun registerUser(goHome: () -> Unit, context: Context) {

		when (validateInput()) {

			ResponseType.EMPTY -> {
				makeToast(context, "Empty credentials!")
				this.usernameError = true
				this.passwordError = true
			}

			ResponseType.BOTH -> {

				makeToast(context, "Invalid credentials!")
				this.usernameError = true
				this.passwordError = true
			}

			ResponseType.USERNAME -> {

				makeToast(context, "Please check your username!")
				this.usernameError = true
			}

			ResponseType.PASSWORD -> {

				makeToast(context, "Please verify your password!")
				this.passwordError = true
			}

			ResponseType.ALREADY_EXISTS -> {

				makeToast(context, "User already exists!")
				this.usernameError = false
				this.passwordError = false
			}

			ResponseType.VALID -> {

				handleRegister()
				clearForm()
				goHome()
			}
		}

	}

	private fun clearForm() {
		usernameError = false
		passwordError = false
		username = ""
		password = ""
		confirmPassword = ""
	}

	private fun checkIfUserExistsInDatabase(username: String): Boolean {

		return runBlocking {
			userRepository.findUserByUsername(username)
		} != null
	}

	private fun handleRegister() {

		runBlocking {
			userRepository.addUserToDatabase(UserEntity(username, password))
		}
	}

	private fun validateInput(): ResponseType {

		val usernameInvalidator = "(\\s+)|([^a-zA-Z0-9]+)".toRegex()

		val passwordValidator =
			"(?=.*[A-Za-z])(?=.*[0-9])(?=.*[@$!%*#?&])[A-Za-z0-9@$!%*#?&]{8,}".toRegex()

		return when {

			username.isEmpty() && password.isEmpty() -> ResponseType.EMPTY

			// invalid username and password
			usernameInvalidator.containsMatchIn(username) and !passwordValidator.containsMatchIn(password) -> ResponseType.BOTH

			// invalid username
			usernameInvalidator.containsMatchIn(username) -> ResponseType.USERNAME

			// invalid password
			!passwordValidator.containsMatchIn(password) -> ResponseType.PASSWORD

			// account already exists
			checkIfUserExistsInDatabase(username) -> ResponseType.ALREADY_EXISTS

			else -> ResponseType.VALID
		}
	}

	// Events
	fun onVisibilityUpdate() {
		passwordVisible = !passwordVisible
	}

	fun onPasswordValueChange(newValue: String) {
		password = newValue
	}

	fun onConfirmPasswordValueChange(newValue: String) {
		confirmPassword = newValue
	}

	fun onUsernameValueChange(newValue: String) {
		username = newValue
		usernameError = false
	}

}
