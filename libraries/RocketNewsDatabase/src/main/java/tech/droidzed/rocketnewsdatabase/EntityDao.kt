package tech.droidzed.rocketnewsdatabase

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

interface EntityDao<T> {

	@Insert
	suspend fun create(e: T)

	@Update
	suspend fun update(e: T)

	@Delete
	suspend fun delete(e: T)
}
