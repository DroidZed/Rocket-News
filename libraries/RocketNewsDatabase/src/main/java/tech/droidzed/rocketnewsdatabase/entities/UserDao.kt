package tech.droidzed.rocketnewsdatabase.entities

import androidx.room.*
import tech.droidzed.rocketnewsdatabase.EntityDao

@Dao
interface UserDao : EntityDao<UserEntity> {

	@Transaction
	@Query("SELECT * FROM user WHERE userId = :id")
	suspend fun getUserById(id: Long): UserAndArticles?

	@Transaction
	@Query("SELECT * FROM user WHERE username = :username")
	suspend fun getUserByUsername(username: String?): UserAndArticles?

	@Insert
	override suspend fun create(e: UserEntity)

	@Update
	override suspend fun update(e: UserEntity)

	@Delete
	override suspend fun delete(e: UserEntity)
}
