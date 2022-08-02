package tech.droidzed.login.services

import tech.droidzed.sharedlib.LoginResponseCode

object LoginServiceImpl : LoginService {


	override fun handleLogin(
		username: String,
		password: String
	): LoginResponseCode {

		TODO("Implement the correct way to login the user you dumb ass !!")
	}

	/**
	 * It takes a string representing a mathematical operation, and a string representing the
	 * user's answer to that operation, and returns a boolean indicating whether the user's
	 * answer is correct
	 *
	 * @param verificationOperation The operation to be performed.
	 * @param userAnswer The user's answer to the verification question.
	 * @return A boolean value
	 */
	override fun handleLoginVerification(
		verificationOperation: String,
		userAnswer: String
	): Boolean {
		val (a, op, b) = verificationOperation.split(" ")

		val op1 = Integer.parseInt(a)
		val op2 = Integer.parseInt(b)

		val preCalculatedValue = when (op) {
			"+" -> op1 + op2
			"-" -> op1 - op2
			"/" -> op1 / op2
			"*" -> op1 * op2
			"%" -> op1 % op2
			else -> 0
		}

		return Integer.parseInt(userAnswer) == preCalculatedValue
	}

	/**
	 * A function to generate random a
	 * verification operation for the login process.
	 *
	 * @return a random verification test
	 */
	override fun generateRandomVerificationTests(): String {

		return mutableListOf(
			"45 * 5",
			"7 + 789",
			"4 % 8"
		).random()
	}
}
