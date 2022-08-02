package tech.droidzed.appdb.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class UserEntity {

	@PrimaryKey(autoGenerate = true)
	@NonNull
	@ColumnInfo(name = "userId")
	var id: Int = 0

	@NonNull
	@ColumnInfo(name = "userName")
	var username: String = ""

	@NonNull
	@ColumnInfo(name = "password")
	var password: String = ""

	constructor()

	constructor(
		id: Int,
		username: String,
		password: String
	) {
		this.id = id
		this.username = username
		this.password = password
	}

	constructor(username: String, password: String) {
		this.username = username
		this.password = password
	}
}
