package tech.droidzed.appdb

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

interface EntityDao<T> {

	@Insert
	suspend fun create(e: T): Boolean

	@Update
	suspend fun update(e: T): Boolean

	@Delete
	suspend fun delete(e: T): Boolean
}
