package tech.droidzed.apollowrapper.repositories.missions

import android.content.Context
import com.apollographql.apollo3.api.ApolloResponse
import com.apollographql.apollo3.cache.normalized.FetchPolicy
import com.apollographql.apollo3.cache.normalized.fetchPolicy
import com.apollographql.apollo3.cache.normalized.watch
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import tech.droidzed.apollowrapper.Client
import tech.droidzed.apollowrapper.MissionInfoQuery
import tech.droidzed.apollowrapper.MissionListQuery
import javax.inject.Inject

class MissionsRepositoryImpl @Inject constructor(@ApplicationContext private val ctx: Context) :
	MissionsRepository {

	override fun getMissionsList(
		limit: Int?,
		offset: Int?,
	): Flow<ApolloResponse<MissionListQuery.Data>> {
		return Client(ctx)
			.getClient()
			.query(MissionListQuery(limit, offset))
			.fetchPolicy(FetchPolicy.CacheFirst)
			.watch()
	}

	override fun getMissionInfo(m_id: String): Flow<ApolloResponse<MissionInfoQuery.Data>> {
		return Client(ctx)
			.getClient()
			.query(MissionInfoQuery(m_id))
			.fetchPolicy(FetchPolicy.CacheFirst)
			.watch()
	}
}
