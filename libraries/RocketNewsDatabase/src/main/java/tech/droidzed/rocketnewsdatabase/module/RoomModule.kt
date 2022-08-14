package tech.droidzed.rocketnewsdatabase.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import tech.droidzed.rocketnewsdatabase.RocketNewsDatabase
import tech.droidzed.rocketnewsdatabase.entities.ArticleDao
import tech.droidzed.rocketnewsdatabase.entities.UserDao
import tech.droidzed.rocketnewsdatabase.repositories.ArticleRepository
import tech.droidzed.rocketnewsdatabase.repositories.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

	// Database
	@Provides
	@Singleton
	fun provideRocketNewsDatabase(@ApplicationContext context: Context): RocketNewsDatabase {
		return Room.databaseBuilder(
			context.applicationContext,
			RocketNewsDatabase::class.java,
			"rocket_news_database"
		).build()
	}

	// DAOs
	@Provides
	@Singleton
	fun provideUserDao(database: RocketNewsDatabase): UserDao = database.userDao()

	@Provides
	@Singleton
	fun provideArticleDao(database: RocketNewsDatabase): ArticleDao = database.articleDao()

	// Repositories
	@Provides
	@Singleton
	fun provideUserRepository(userDao: UserDao): UserRepository = UserRepository(userDao)

	@Provides
	@Singleton
	fun provideArticleRepository(articleDao: ArticleDao): ArticleRepository = ArticleRepository(articleDao)
}
