package tech.droidzed.apollowrapper.repositories.missions

import com.apollographql.apollo3.api.ApolloResponse
import kotlinx.coroutines.flow.Flow
import tech.droidzed.apollowrapper.MissionInfoQuery
import tech.droidzed.apollowrapper.MissionListQuery


interface MissionsRepository {

	fun getMissionsList(
		limit: Int? = 0,
		offset: Int? = 0,
	): Flow<ApolloResponse<MissionListQuery.Data>>

	fun getMissionInfo(m_id: String): Flow<ApolloResponse<MissionInfoQuery.Data>>

}
