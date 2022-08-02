package tech.droidzed.register.services

import tech.droidzed.sharedlib.ErrorType
import tech.droidzed.sharedlib.LoginResponseCode
import tech.droidzed.sharedlib.RegisterInfo

object RegisterServiceImpl : RegisterService {


	override fun handleRegister(regInfo: RegisterInfo): Boolean {

		TODO("Implement the correct way to register the user you dumb ass !!")
	}


	/**
	 * This function validates the input data fed into it and returns a response based on the result calculated.
	 * @param inputData InputData
	 * @return A pair of an ErrorType and a boolean
	 */
	override fun validateInput(
		inputData: RegisterInfo
	): Pair<ErrorType, Boolean> {

		val usernameInvalidator = "(\\s+)|([^a-zA-Z0-9]+)".toRegex()

		val passwordValidator =
			"(?=.*[A-Za-z])(?=.*[0-9])(?=.*[@$!%*#?&])[A-Za-z0-9@$!%*#?&]{8,}".toRegex()

		return when {

			usernameInvalidator.containsMatchIn(inputData.username)
					and
					!passwordValidator.containsMatchIn(inputData.password) -> Pair(
				ErrorType.BOTH,
				false
			)

			inputData.username.isEmpty() or usernameInvalidator.containsMatchIn(inputData.username) -> Pair(
				ErrorType.USERNAME,
				false
			)

			inputData.password.isEmpty() or !passwordValidator.containsMatchIn(inputData.password) -> Pair(
				ErrorType.PASSWORD,
				false
			)

			else -> Pair(ErrorType.NONE, true)
		}
	}
}
