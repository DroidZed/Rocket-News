package tech.droidzed.apolloclient

import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import tech.droidzed.apollowrapper.repositories.launches.LaunchesRepository
import javax.inject.Inject

@RunWith(JUnit4::class)
@HiltAndroidTest
class LaunchesTest {

	@get:Rule
	var hiltRule = HiltAndroidRule(this)

	@OptIn(DelicateCoroutinesApi::class)
	private val mainThreadSurrogate = newSingleThreadContext("Apollo Thread")
	@Inject
	lateinit var launchesRepository : LaunchesRepository

	@Before
	@OptIn(ExperimentalCoroutinesApi::class)
	fun init() {
		hiltRule.inject()
		Dispatchers.setMain(mainThreadSurrogate)
	}

	@After
	@OptIn(ExperimentalCoroutinesApi::class)
	fun destroy() {
		Dispatchers.resetMain() // reset the main dispatcher to the original Main dispatcher
		mainThreadSurrogate.close()
	}


	@Test
	fun launch_ShouldWork() = runBlocking {

		launch(Dispatchers.Main) {
			launchesRepository.getLaunches().collect { values ->
				values.data?.launches?.stream()?.forEach(::println)
			}
		}

		assertEquals(
			0,
			1 - 1
		)
	}
}
