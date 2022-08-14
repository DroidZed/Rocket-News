package tech.droidzed.apollowrapper.repositories.rockets

import com.apollographql.apollo3.api.ApolloResponse
import kotlinx.coroutines.flow.Flow
import tech.droidzed.apollowrapper.RocketInfoQuery
import tech.droidzed.apollowrapper.RocketListQuery

interface RocketsRepository {

	fun getRocketsList(
		limit: Int? = 0,
		offset: Int? = 0,
	): Flow<ApolloResponse<RocketListQuery.Data>>

	fun getRocket(r_id: String): Flow<ApolloResponse<RocketInfoQuery.Data>>
}
