package tech.droidzed.apollowrapper.repositories.launches

import android.content.Context
import com.apollographql.apollo3.api.ApolloResponse
import com.apollographql.apollo3.cache.normalized.FetchPolicy
import com.apollographql.apollo3.cache.normalized.fetchPolicy
import com.apollographql.apollo3.cache.normalized.watch
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import tech.droidzed.apollowrapper.Client
import tech.droidzed.apollowrapper.LaunchInfoQuery
import tech.droidzed.apollowrapper.LaunchListQuery
import javax.inject.Inject

class LaunchesRepositoryImpl @Inject constructor(@ApplicationContext private val ctx: Context) :
	LaunchesRepository {

	override fun getLaunch(l_id: String): Flow<ApolloResponse<LaunchInfoQuery.Data>> {

		return Client(ctx)
			.getClient()
			.query(LaunchInfoQuery(l_id))
			.fetchPolicy(FetchPolicy.CacheFirst)
			.watch()
	}

	override fun getLaunches(
		limit: Int?,
		offset: Int?,
	): Flow<ApolloResponse<LaunchListQuery.Data>> {

		return Client(ctx)
			.getClient()
			.query(LaunchListQuery(limit, offset))
			.fetchPolicy(FetchPolicy.CacheFirst)
			.watch()
	}
}
