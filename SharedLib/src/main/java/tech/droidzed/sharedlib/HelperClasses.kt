package tech.droidzed.sharedlib

sealed class LoginResponse(val resp: String) {
	object Unavailable : LoginResponse("User not found !")
	object Credentials : LoginResponse("Wrong credentials !")
	object Success : LoginResponse("Success !")
	object VerifyInput : LoginResponse("Verify Your Input !")
}

data class RegisterInfo(
	var displayName: String = "",
	var username: String = "",
	var password: String = "",
	var confirmPassword: String = ""
)

enum class ErrorType {
	BOTH,
	USERNAME,
	PASSWORD,
	NONE
}

enum class LoginResponseCode {
	NOT_FOUND,
	WRONG_CREDENTIALS,
	SUCCESS
}
