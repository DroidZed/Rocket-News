package tech.droidzed.login.services

import tech.droidzed.sharedlib.LoginResponseCode

interface LoginService {

	fun handleLogin(username: String, password: String): LoginResponseCode

	fun handleLoginVerification(
		verificationOperation: String,
		userAnswer: String
	): Boolean

	fun generateRandomVerificationTests(): String
}
