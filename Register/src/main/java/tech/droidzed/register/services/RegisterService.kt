package tech.droidzed.register.services

import tech.droidzed.sharedlib.ErrorType
import tech.droidzed.sharedlib.RegisterInfo

interface RegisterService {

	fun handleRegister(regInfo: RegisterInfo): Boolean

	fun validateInput(inputData: RegisterInfo): Pair<ErrorType, Boolean>
}
