package tech.droidzed.rocketnewsdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import tech.droidzed.rocketnewsdatabase.entities.ArticleDao
import tech.droidzed.rocketnewsdatabase.entities.ArticleEntity
import tech.droidzed.rocketnewsdatabase.entities.UserDao
import tech.droidzed.rocketnewsdatabase.entities.UserEntity

@Database(entities = [(UserEntity::class), (ArticleEntity::class)], version = 2)
abstract class RocketNewsDatabase : RoomDatabase() {

	abstract fun userDao(): UserDao

	abstract fun articleDao(): ArticleDao

}
