package tech.droidzed.apollowrapper

import com.apollographql.apollo3.api.ApolloResponse
import com.apollographql.apollo3.cache.normalized.FetchPolicy
import com.apollographql.apollo3.cache.normalized.fetchPolicy
import com.apollographql.apollo3.cache.normalized.watch
import kotlinx.coroutines.flow.Flow


object SpaceXRepository {

	private val CLIENT = MainClient.client()

	/**
	 * `getLaunches` is a function that returns a `Flow` of `ApolloResponse`s of type
	 * `LaunchListQuery.Data`
	 *
	 * Let's break that down
	 *
	 * @param limit Int? = 0,
	 * @param offset The offset of the first item in the list.
	 * @return A Flow of ApolloResponse<LaunchListQuery.Data>
	 */
	fun getLaunches(
		limit: Int? = 0,
		offset: Int? = 0
	): Flow<ApolloResponse<LaunchListQuery.Data>> {

		return CLIENT
			.query(LaunchListQuery(limit, offset))
			.fetchPolicy(FetchPolicy.CacheFirst)
			.watch()
	}
}
