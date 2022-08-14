package tech.droidzed.apollowrapper.repositories.dragons

import android.content.Context
import com.apollographql.apollo3.api.ApolloResponse
import com.apollographql.apollo3.cache.normalized.FetchPolicy
import com.apollographql.apollo3.cache.normalized.fetchPolicy
import com.apollographql.apollo3.cache.normalized.watch
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import tech.droidzed.apollowrapper.Client
import tech.droidzed.apollowrapper.DragonInfoQuery
import tech.droidzed.apollowrapper.DragonListQuery
import javax.inject.Inject

class DragonsRepositoryImpl @Inject constructor(@ApplicationContext private val ctx: Context) :
	DragonsRepository {

	override fun getDragonsList(
		limit: Int?,
		offset: Int?,
	): Flow<ApolloResponse<DragonListQuery.Data>> {
		return Client(ctx)
			.getClient()
			.query(DragonListQuery(limit, offset))
			.fetchPolicy(FetchPolicy.CacheFirst)
			.watch()
	}

	override fun getDragonInfo(d_id: String): Flow<ApolloResponse<DragonInfoQuery.Data>> {
		return Client(ctx)
			.getClient()
			.query(DragonInfoQuery(d_id))
			.fetchPolicy(FetchPolicy.CacheFirst)
			.watch()
	}


}
