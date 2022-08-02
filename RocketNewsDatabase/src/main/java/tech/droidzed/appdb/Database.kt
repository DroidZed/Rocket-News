package tech.droidzed.appdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import tech.droidzed.appdb.entity.UserDao
import tech.droidzed.appdb.entity.UserEntity

@Database(entities = [(UserEntity::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {
	abstract fun userDao(): UserDao

	companion object {

		private var INSTANCE: AppDatabase? = null

		fun getInstance(context: Context): AppDatabase {
			synchronized(this) {
				var instance = INSTANCE

				if (instance == null) {
					instance = Room.databaseBuilder(
						context.applicationContext,
						AppDatabase::class.java,
						"app_database"
					).fallbackToDestructiveMigration()
						.build()

					INSTANCE = instance
				}
				return instance
			}
		}
	}
}
