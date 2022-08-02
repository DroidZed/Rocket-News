package tech.droidzed.apollowrapper

import com.apollographql.apollo3.ApolloClient

object MainClient {

	private val apolloClient = ApolloClient.Builder()
		.serverUrl("https://api.spacex.land/graphql/")
		.build()

	fun client(): ApolloClient {
		return apolloClient
	}
}
