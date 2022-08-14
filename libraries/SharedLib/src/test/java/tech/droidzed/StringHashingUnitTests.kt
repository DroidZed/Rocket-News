package tech.droidzed

import org.junit.Assert.assertTrue
import org.junit.Test
import tech.droidzed.utils.HashUtils
import tech.droidzed.utils.HashUtils.hashCheck

/**
 * String hashing unit tests.
 */
class StringHashingUnitTests {

	private val hashingUitls = HashUtils

	private val hash1 = "86611476133e0546c5577c247b80becc20c3932d66932fdb61e5f934f41dd8bd23ce14e05027547b482e2944432c6fa487c1b1eb99c5d6dd7096fe7deb9d569c"

	private var message = "0132569874Go"

	@Test
	fun password_hashing_working_test() {
		assertTrue(hashCheck(message, hash1))
	}
}
