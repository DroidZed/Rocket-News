package tech.droidzed.register.utils

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import tech.droidzed.commons.makeToast
import tech.droidzed.model.ResponseType
import tech.droidzed.model.Routes
import tech.droidzed.rocketnewsdatabase.entities.UserAndArticles
import tech.droidzed.rocketnewsdatabase.entities.UserEntity
import tech.droidzed.rocketnewsdatabase.repositories.UserRepository
import tech.droidzed.sessionmanagement.SessionInterface
import tech.droidzed.sessionmanagement.UserInfo
import tech.droidzed.utils.HashUtils.hashString
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
class RegisterViewModel @Inject constructor(
	private val userRepository: UserRepository,
	private val sessionInterface: SessionInterface,
) :
	ViewModel() {

	// State
	var username by mutableStateOf("")
	var password by mutableStateOf("")
	var confirmPassword by mutableStateOf("")

	var passwordVisible by mutableStateOf(false)

	var usernameError by mutableStateOf(false)
	var passwordError = password != confirmPassword

	private var userExists = false
	private var userObject: UserAndArticles? = null

	// Operations on state
	fun registerUser(navHostController: NavHostController, context: Context) {

		this.checkIfUserExistsInDatabase()

		when (this.validateInput()) {

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

				this.registerUser()
				this.clearForm()
				runBlocking {
					sessionInterface.createSession(UserInfo(
						userObject?.user?.id!!,
						userObject?.user?.username!!,
						userObject?.user?.password!!))
				}
				navHostController.navigate(Routes.Home.route) {
					launchSingleTop = true
				}
			}
		}

	}

	fun teleportToLogin(navHostController: NavHostController) {
		navHostController.navigate(Routes.Login.route) {
			launchSingleTop = true
		}
	}

	private fun clearForm() {
		usernameError = false
		passwordError = false
		username = ""
		password = ""
		confirmPassword = ""
	}

	private fun checkIfUserExistsInDatabase() {

		viewModelScope.launch(Dispatchers.IO) {
			userExists = userRepository.findUserByUsername(username) != null
		}
	}

	private fun registerUser() {

		userObject = runBlocking {
			userRepository.addUserToDatabase(UserEntity(username, hashString(password)))
		}
	}

	private fun validateInput(): ResponseType {

		val usernameInvalidator = "(\\s+)|([^a-zA-Z0-9]+)".toRegex()

		val passwordValidator =
			"(?=.*[A-Za-z])(?=.*[0-9])(?=.*[@$!%*#?&])[A-Za-z0-9@$!%*#?&]{8,}".toRegex()

		return when {

			username.isEmpty() && password.isEmpty() -> ResponseType.EMPTY

			// invalid username and password
			usernameInvalidator.containsMatchIn(username) and !passwordValidator.containsMatchIn(
				password
			) -> ResponseType.BOTH

			// invalid username
			usernameInvalidator.containsMatchIn(username) -> ResponseType.USERNAME

			// invalid password
			!passwordValidator.containsMatchIn(password) -> ResponseType.PASSWORD

			// account already exists
			userExists -> ResponseType.ALREADY_EXISTS

			else -> ResponseType.VALID
		}
	}


}
