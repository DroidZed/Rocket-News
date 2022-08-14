package tech.droidzed.spacex_info.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import tech.droidzed.apollowrapper.dtos.CompanyInfoDto
import tech.droidzed.apollowrapper.repositories.companyinfo.CompanyInfoRepository
import javax.inject.Inject


@HiltViewModel
class SpaceXInfoViewModel @Inject constructor(private val companyInfoRepository: CompanyInfoRepository) :
	ViewModel() {

	var data: CompanyInfoDto by mutableStateOf(CompanyInfoDto())

	suspend fun loadSpaceXData() {

		data = companyInfoRepository.getCompanyInfo()

	}
}
