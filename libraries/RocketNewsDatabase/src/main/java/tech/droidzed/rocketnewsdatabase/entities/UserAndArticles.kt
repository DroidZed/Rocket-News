package tech.droidzed.rocketnewsdatabase.entities

import androidx.room.Embedded
import androidx.room.Relation

data class UserAndArticles(
	@Embedded val user: UserEntity,

	@Relation(
		parentColumn = "userId",
		entityColumn = "userBookmarkerId"
	)
	val articles: List<ArticleEntity>
)
