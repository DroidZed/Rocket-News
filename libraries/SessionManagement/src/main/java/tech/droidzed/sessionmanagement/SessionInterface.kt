package tech.droidzed.sessionmanagement

import kotlinx.coroutines.flow.Flow

interface SessionInterface {

	suspend fun createSession( userInfo: UserInfo)

	fun loadSession(): Flow<UserInfo>

	suspend fun clearSession()
}
