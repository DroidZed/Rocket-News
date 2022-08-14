package tech.droidzed.apollowrapper.repositories.rockets

import android.content.Context
import com.apollographql.apollo3.api.ApolloResponse
import com.apollographql.apollo3.cache.normalized.FetchPolicy
import com.apollographql.apollo3.cache.normalized.fetchPolicy
import com.apollographql.apollo3.cache.normalized.watch
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import tech.droidzed.apollowrapper.Client
import tech.droidzed.apollowrapper.RocketInfoQuery
import tech.droidzed.apollowrapper.RocketListQuery
import javax.inject.Inject

class RocketsRepositoryImpl @Inject constructor(@ApplicationContext private val ctx: Context) :
	RocketsRepository {

	override fun getRocketsList(
		limit: Int?,
		offset: Int?,
	): Flow<ApolloResponse<RocketListQuery.Data>> {
		return Client(ctx)
			.getClient()
			.query(RocketListQuery(limit, offset))
			.fetchPolicy(FetchPolicy.CacheFirst)
			.watch()
	}

	override fun getRocket(r_id: String): Flow<ApolloResponse<RocketInfoQuery.Data>> {
		return Client(ctx)
			.getClient()
			.query(RocketInfoQuery(r_id))
			.fetchPolicy(FetchPolicy.CacheFirst)
			.watch()
	}
}
