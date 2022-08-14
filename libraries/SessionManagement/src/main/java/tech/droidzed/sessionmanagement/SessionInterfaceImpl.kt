package tech.droidzed.sessionmanagement

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private const val USER_DATASTORE = "user_info"
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_DATASTORE)

class SessionInterfaceImpl @Inject constructor(@ApplicationContext private val context: Context) :
	SessionInterface {

	private val id = intPreferencesKey("ID")
	private val username = stringPreferencesKey("USERNAME")
	private val password = stringPreferencesKey("PASSWORD")

	override suspend fun createSession(userInfo: UserInfo) {
		context.dataStore.edit {
			it[id] = userInfo.id
			it[username] = userInfo.username
			it[password] = userInfo.password
		}
	}

	override fun loadSession(): Flow<UserInfo> =
		context.dataStore.data.map {
			UserInfo(
				id = it[id] ?: 0,
				username = it[username] ?: "",
				password = it[password] ?: "")
		}

	override suspend fun clearSession() {
		context.dataStore.edit {
			it.clear()
		}
	}
}
