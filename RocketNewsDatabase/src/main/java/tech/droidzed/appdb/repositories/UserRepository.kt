package tech.droidzed.appdb.repositories

import tech.droidzed.appdb.entity.UserDao
import tech.droidzed.appdb.entity.UserEntity

/**
 * It's a repository that uses a DAO to perform CRUD operations on a tech.droidzed.appdb.entity.UserEntity
 */
class UserRepository(private val userDao: UserDao) {

	/**
	 * > The function creates a user in the database
	 *
	 * @param user tech.droidzed.appdb.entity.UserEntity - This is the parameter that will be passed to the suspend
	 * function.
	 */
	suspend fun create(user: UserEntity) {
		userDao.create(user)
	}


	/**
	 * > This function is a suspend function that returns a tech.droidzed.appdb.entity.UserEntity object
	 *
	 * @param id The id of the user to be found
	 * @return A tech.droidzed.appdb.entity.UserEntity object
	 */
	suspend fun findUserById(id: Int): UserEntity? {
		return userDao.getUserById(id)

	}

	/**
	 * > Delete a user from the database
	 *
	 * @param user tech.droidzed.appdb.entity.UserEntity - The user object that we want to delete.
	 */
	suspend fun delete(user: UserEntity) {
		userDao.delete(user)
	}

	/**
	 * > The function `update` is a `suspend` function that takes a `tech.droidzed.appdb.entity.UserEntity` as a parameter
	 * and calls the `updateUser` function on the `userDao` object
	 *
	 * @param user tech.droidzed.appdb.entity.UserEntity - The user object that we want to update.
	 */
	suspend fun update(user: UserEntity) {
		userDao.update(user)
	}
}
