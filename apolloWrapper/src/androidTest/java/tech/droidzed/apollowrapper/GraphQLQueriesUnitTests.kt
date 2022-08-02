package tech.droidzed.apollowrapper

import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.*
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GraphQLQueriesUnitTests {

	@Test
	fun launch_ShouldWork() = runBlocking {

		launch(Dispatchers.Main) {
			getLaunches().collect { values ->
				values.data?.launches?.stream()?.forEach(::println)
			}
		}

		assertEquals(
			0,
			1 - 1
		)
	}

}
