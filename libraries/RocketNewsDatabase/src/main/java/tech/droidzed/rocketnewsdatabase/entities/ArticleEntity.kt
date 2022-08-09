package tech.droidzed.rocketnewsdatabase.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class ArticleEntity(

	@NonNull
	@ColumnInfo(name = "id")
	@PrimaryKey(autoGenerate = true)
	var id: Long,

	@NonNull
	var title: String,

	var link: String?,

	@ColumnInfo(name = "userBookmarkerId")
	var userBookmarkerId: Long

)
