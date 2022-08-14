package tech.droidzed.apollowrapper.repositories.companyinfo

import tech.droidzed.apollowrapper.dtos.CompanyInfoDto

interface CompanyInfoRepository {

	suspend fun getCompanyInfo(): CompanyInfoDto
}
