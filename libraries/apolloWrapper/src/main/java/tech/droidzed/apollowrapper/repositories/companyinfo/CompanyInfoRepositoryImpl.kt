package tech.droidzed.apollowrapper.repositories.companyinfo

import android.content.Context
import android.util.Log
import com.apollographql.apollo3.cache.normalized.FetchPolicy
import com.apollographql.apollo3.cache.normalized.fetchPolicy
import com.apollographql.apollo3.cache.normalized.watch
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.single
import tech.droidzed.apollowrapper.Client
import tech.droidzed.apollowrapper.CompanyInfoQuery
import tech.droidzed.apollowrapper.dtos.CompanyHeadQuarters
import tech.droidzed.apollowrapper.dtos.CompanyInfoDto
import tech.droidzed.apollowrapper.dtos.CompanyLinksDto
import javax.inject.Inject

class CompanyInfoRepositoryImpl @Inject constructor(@ApplicationContext private val ctx: Context) :
	CompanyInfoRepository {

	override suspend fun getCompanyInfo(): CompanyInfoDto {

		val d = Client(ctx)
			.getClient()
			.query(CompanyInfoQuery())
			.fetchPolicy(FetchPolicy.CacheFirst)
			.watch()
			.single().data?.company

		val x = CompanyInfoDto(
			coo = d?.coo,
			ceo = d?.ceo,
			cto = d?.cto,
			cto_propulsion = d?.cto_propulsion,
			name = d?.name,
			links = CompanyLinksDto(
				twitter = d?.links?.twitter!!,
				website = d.links.website!!,
				elon_twitter = d.links.elon_twitter!!,
				flickr = d.links.flickr!!
			),
			hq = CompanyHeadQuarters(
				city = d.headquarters?.city!!,
				address = d.headquarters.address!!,
				state = d.headquarters.state!!
			),
			employees = d.employees,
			founded_at_y = d.founded,
			founder_n = d.founder,
			company_summary = d.summary,
			company_valuation = d.valuation
		)

		Log.e("COMPANY INFO REPO", "Company name: ${x.name}")
		return x
	}
}
