package tech.droidzed.model

import tech.droidzed.model.AuthenticationResponseCode.*

sealed class AuthenticationResponse(val resp: String, val code: AuthenticationResponseCode) {
	object Unavailable : AuthenticationResponse("User not found !", NOT_FOUND)
	object Credentials : AuthenticationResponse("Wrong credentials !", WRONG_CREDENTIALS)
	object Success : AuthenticationResponse("Success !", SUCCESS)
	object EmptyFields : AuthenticationResponse("Empty form !", EMPTY)
	object VerifyInput : AuthenticationResponse("Verify Your Input !", VERIFY_INFO)
}
