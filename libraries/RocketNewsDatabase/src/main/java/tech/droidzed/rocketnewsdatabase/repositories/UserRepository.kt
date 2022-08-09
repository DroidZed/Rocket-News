package tech.droidzed.rocketnewsdatabase.repositories

import kotlinx.coroutines.flow.Flow
import tech.droidzed.rocketnewsdatabase.entities.UserAndArticles
import tech.droidzed.rocketnewsdatabase.entities.UserDao
import tech.droidzed.rocketnewsdatabase.entities.UserEntity
import javax.inject.Inject


class UserRepository @Inject constructor(private val userDao: UserDao) {


	/**
	 * > This function takes a user object, and adds it to the database
	 *
	 * @param user UserEntity - This is the user object that we want to add to the database.
	 */
	suspend fun addUserToDatabase(user: UserEntity) {
		userDao.create(user)
	}


	/**
	 * > This function returns a Flow of UserAndArticles objects, which is a data class that
	 * contains a User object and a list of Article objects
	 *
	 * @param username The username of the user you want to find.
	 * @return A Flow of UserAndArticles
	 */
	suspend fun findUserByUsername(username: String?): UserAndArticles? {
		return userDao.getUserByUsername(username)
	}


	/**
	 * > This function removes a user from the database
	 *
	 * @param user UserEntity - The user object that we want to delete from the database.
	 */
	suspend fun removeUserProfile(user: UserEntity) {
		userDao.delete(user)
	}


	/**
	 * > This function updates a user's profile in the database
	 *
	 * @param user UserEntity - The user object that we want to update.
	 */
	suspend fun updateUserProfile(user: UserEntity) {
		userDao.update(user)
	}
}
