package tech.droidzed.login.utils

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import tech.droidzed.commons.makeToast
import tech.droidzed.model.AuthenticationResponse
import tech.droidzed.model.AuthenticationResponseCode
import tech.droidzed.rocketnewsdatabase.repositories.UserRepository
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val userRepository: UserRepository) :
	ViewModel() {

	// State
	var username by mutableStateOf("")
	var password by mutableStateOf("")
	var verify by mutableStateOf("")

	var usernameError by mutableStateOf(false)
	var passwordError by mutableStateOf(false)
	var verifyError by mutableStateOf(false)

	var passwordVisible by mutableStateOf(false)

	// Verification question
	var randomVerificationTest = generateRandomEquation()

	private fun generateRandomEquation() = "${(2..74).random()} ${"+/*-".random()} ${(2..74).random()}"

	// Operations
	fun handleLogin(
		goHome: () -> Unit,
		context: Context
	) {

		if (username.isEmpty() && password.isEmpty())  makeToast(context, AuthenticationResponse.EmptyFields.resp)

		when (loginUser().code) {

			AuthenticationResponseCode.EMPTY -> {
				makeToast(context, AuthenticationResponse.EmptyFields.resp)
				verifyError = true
				passwordError = true
				usernameError = true
			}

			AuthenticationResponseCode.NOT_FOUND -> {
				makeToast(context, AuthenticationResponse.Unavailable.resp)
				passwordError = true
				usernameError = true
			}

			AuthenticationResponseCode.WRONG_CREDENTIALS -> {
				makeToast(context, AuthenticationResponse.Credentials.resp)
				passwordError = true
				usernameError = true
			}

			AuthenticationResponseCode.VERIFY_INFO -> {
				makeToast(context, AuthenticationResponse.VerifyInput.resp)
				verifyError = true
			}

			AuthenticationResponseCode.SUCCESS -> {
				if (verifyUserLogin()) {
					makeToast(context, AuthenticationResponse.Success.resp)
					goHome()
				} else {
					makeToast(context, AuthenticationResponse.VerifyInput.resp)
					verifyError = true
				}
			}
		}
	}

	private fun clearForm() {
		usernameError = false
		passwordError = false
		username = ""
		password = ""
		verify = ""
		verifyError = false
		randomVerificationTest = generateRandomEquation()

	}

	/**
	 * > It tries to find a user in the database with the username provided by the user, and if
	 * it finds one, it checks if the password is correct
	 *
	 * @return LoginResponseCode
	 */
	private fun loginUser(): AuthenticationResponse {

		if (username.isEmpty() && password.isEmpty())  return AuthenticationResponse.EmptyFields

		val userObj = runBlocking { userRepository.findUserByUsername(username) }

		if (userObj != null) {

			return if (userObj.user.password != password) {
				AuthenticationResponse.Credentials
			}

			else AuthenticationResponse.Success
		}

		return AuthenticationResponse.Unavailable
	}


	/**
	 * > If the user's input is empty, return false. Otherwise, split the random verification
	 * test into three parts, parse the first two parts into integers, and then perform the
	 * operation on the two integers. If the user's input matches the result of the operation,
	 * return true
	 *
	 * @return A boolean value.
	 */
	private fun verifyUserLogin(): Boolean {

		if (verify.isEmpty()) {
			return false
		}

		val (a, op, b) = randomVerificationTest.split(" ")

		val op1 = Integer.parseInt(a)
		val op2 = Integer.parseInt(b)

		val preCalculatedValue = when (op) {
			"+" -> op1 + op2
			"-" -> op1 - op2
			"/" -> op1 / op2
			"*" -> op1 * op2
			else -> 0
		}

		return Integer.parseInt(verify) == preCalculatedValue
	}
}
