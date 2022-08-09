package tech.droidzed.rocketnewsdatabase.entities

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import tech.droidzed.rocketnewsdatabase.EntityDao

@Dao
interface ArticleDao : EntityDao<ArticleEntity> {

	@Insert
	override suspend fun create(e: ArticleEntity)

	@Delete
	override suspend fun delete(e: ArticleEntity)
}
