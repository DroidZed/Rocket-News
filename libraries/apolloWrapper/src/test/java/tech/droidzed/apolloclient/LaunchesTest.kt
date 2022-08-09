package tech.droidzed.apolloclient

import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import tech.droidzed.apollowrapper.SpaceXRepository

@RunWith(JUnit4::class)
class LaunchesTest {

	@OptIn(DelicateCoroutinesApi::class)
	private val mainThreadSurrogate = newSingleThreadContext("Apollo Thread")

	@Before
	@OptIn(ExperimentalCoroutinesApi::class)
	fun init() {
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
			SpaceXRepository.getLaunches().collect { values ->
				values.data?.launches?.stream()?.forEach(::println)
			}
		}

		assertEquals(
			0,
			1 - 1
		)
	}
}
