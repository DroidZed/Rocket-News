package tech.droidzed.appdb.entity

import androidx.room.*
import tech.droidzed.appdb.EntityDao

@Dao
interface UserDao : EntityDao<UserEntity> {

	@Query("SELECT * FROM users WHERE userId = :id")
	suspend fun getUserById(id: Int): UserEntity?

	@Insert
	override suspend fun create(e: UserEntity): Boolean

	@Update
	override suspend fun update(e: UserEntity): Boolean

	@Delete
	override suspend fun delete(e: UserEntity): Boolean
}
