package tech.droidzed.profile.screens.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tech.droidzed.sessionmanagement.SessionInterface
import tech.droidzed.sessionmanagement.UserInfo
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val sessionInterface: SessionInterface) :
	ViewModel() {

	var data by mutableStateOf(UserInfo())

	suspend fun loadProfileData() {
		sessionInterface.loadSession().collect {
			data = it
		}
	}

	fun logout() {
		viewModelScope.launch(Dispatchers.IO) {
			sessionInterface.clearSession()
		}
	}
}
