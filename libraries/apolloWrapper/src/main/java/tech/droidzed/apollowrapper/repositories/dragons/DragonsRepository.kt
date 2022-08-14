package tech.droidzed.apollowrapper.repositories.dragons

import com.apollographql.apollo3.api.ApolloResponse
import kotlinx.coroutines.flow.Flow
import tech.droidzed.apollowrapper.DragonInfoQuery
import tech.droidzed.apollowrapper.DragonListQuery

interface DragonsRepository {

	fun getDragonsList(
		limit: Int? = 0,
		offset: Int? = 0,
	): Flow<ApolloResponse<DragonListQuery.Data>>

	fun getDragonInfo(d_id: String): Flow<ApolloResponse<DragonInfoQuery.Data>>
}
