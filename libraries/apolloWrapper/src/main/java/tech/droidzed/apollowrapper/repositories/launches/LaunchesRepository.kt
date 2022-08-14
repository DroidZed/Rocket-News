package tech.droidzed.apollowrapper.repositories.launches

import com.apollographql.apollo3.api.ApolloResponse
import kotlinx.coroutines.flow.Flow
import tech.droidzed.apollowrapper.LaunchInfoQuery
import tech.droidzed.apollowrapper.LaunchListQuery

interface LaunchesRepository {

	fun getLaunches(limit: Int? = 0, offset: Int? = 0): Flow<ApolloResponse<LaunchListQuery.Data>>

	fun getLaunch(l_id: String): Flow<ApolloResponse<LaunchInfoQuery.Data>>
}
