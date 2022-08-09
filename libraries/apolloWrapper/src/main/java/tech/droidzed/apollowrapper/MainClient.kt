package tech.droidzed.apollowrapper

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.cache.normalized.normalizedCache
import com.apollographql.apollo3.cache.normalized.sql.SqlNormalizedCacheFactory

object MainClient {

	private val apolloClient = ApolloClient.Builder()
		.serverUrl("https://api.spacex.land/graphql/")
		.normalizedCache(SqlNormalizedCacheFactory("apollo.db"))
		.build()

	fun client(): ApolloClient {
		return apolloClient
	}
}
