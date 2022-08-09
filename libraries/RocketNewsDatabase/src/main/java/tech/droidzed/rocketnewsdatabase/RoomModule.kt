package tech.droidzed.rocketnewsdatabase

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import tech.droidzed.rocketnewsdatabase.entities.ArticleDao
import tech.droidzed.rocketnewsdatabase.entities.UserDao
import tech.droidzed.rocketnewsdatabase.repositories.ArticleRepository
import tech.droidzed.rocketnewsdatabase.repositories.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

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
	fun provideUserDao(database: RocketNewsDatabase): UserDao {
		return database.userDao()
	}

	@Provides
	@Singleton
	fun provideArticleDao(database: RocketNewsDatabase): ArticleDao {
		return database.articleDao()
	}

	// Repositories
	@Provides
	@Singleton
	fun provideUserRepository(userDao: UserDao): UserRepository {
		return UserRepository(userDao)
	}

	@Provides
	@Singleton
	fun provideArticleRepository(articleDao: ArticleDao): ArticleRepository {
		return ArticleRepository(articleDao)
	}
}
