package tech.droidzed.apollowrapper

import android.content.Context
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.cache.normalized.api.MemoryCacheFactory
import com.apollographql.apollo3.cache.normalized.normalizedCache
import com.apollographql.apollo3.cache.normalized.sql.SqlNormalizedCacheFactory
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Singleton
class Client (@ApplicationContext ctx: Context) {

	private var c: ApolloClient = ApolloClient
		.Builder()
		.serverUrl("https://api.spacex.land/graphql/")
		.normalizedCache(MemoryCacheFactory(maxSizeBytes = 10 * 1024 * 1024).chain(
			SqlNormalizedCacheFactory(context = ctx, "rocketnews.db")),
			writeToCacheAsynchronously = true)
		.build()

	fun getClient() = c
}
