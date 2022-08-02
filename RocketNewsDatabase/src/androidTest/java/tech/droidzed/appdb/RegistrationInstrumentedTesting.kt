package tech.droidzed.appdb

import UserDao
import UserEntity
import android.util.Patterns
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import tech.droidzed.sharedlib.RegisterInfo
import java.io.IOException
import java.util.regex.Pattern

@RunWith(AndroidJUnit4::class)
class RegistrationInstrumentedTesting {

	private lateinit var emailPattern: Pattern
	private lateinit var phoneNumberPattern: Pattern

	private lateinit var userDao: UserDao
	private lateinit var appDb: AppDatabase

	private lateinit var dummyData: RegisterInfo

	@Before
	fun init() {

		emailPattern = Patterns.EMAIL_ADDRESS
		phoneNumberPattern = Patterns.PHONE

		dummyData = RegisterInfo()

		val context = InstrumentationRegistry.getInstrumentation().targetContext

		appDb = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
			.allowMainThreadQueries()
			.build()

		userDao = appDb.userDao()

	}

	@After
	@Throws(IOException::class)
	fun destroy() {
		appDb.close()
	}

	// Phase1: Testing the form validation


	// Phase 3: Registering the user inside of the database
	@Test
	@Throws(Exception::class)
	fun insertAndGetUser() = runBlocking {

		userDao.create(
			UserEntity(
				username = "DroidZed",
				password = "AymenGam3r7"
			)
		)

		Assert.assertEquals(userDao.getUserById(2)?.id, 2)
	}

}
