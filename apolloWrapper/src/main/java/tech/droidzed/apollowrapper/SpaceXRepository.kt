package tech.droidzed.apollowrapper

import com.apollographql.apollo3.api.ApolloResponse
import kotlinx.coroutines.flow.Flow


private val CLIENT = MainClient.client()


fun getLaunches(limit: Int? = 0, offset: Int? = 0): Flow<ApolloResponse<LaunchListQuery.Data>> {

	return CLIENT
		.query(LaunchListQuery(limit, offset))
		.toFlow()
}
