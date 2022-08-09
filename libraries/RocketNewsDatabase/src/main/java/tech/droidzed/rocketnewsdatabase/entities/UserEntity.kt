package tech.droidzed.rocketnewsdatabase.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.ColumnInfo.INTEGER
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "user")
class UserEntity {

	@NonNull
	@ColumnInfo(name = "userId", typeAffinity = INTEGER)
	@PrimaryKey(autoGenerate = true)
	var id: Int = 0

	@NonNull
	var username: String = ""

	@NonNull
	var password: String = ""

	constructor(id: Int, username: String, password: String) {
		this.id = id
		this.username = username
		this.password = password
	}

	@Ignore
	constructor(username: String, password: String) {
		this.username = username
		this.password = password
	}
}
