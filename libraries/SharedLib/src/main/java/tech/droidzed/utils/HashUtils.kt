package tech.droidzed.utils

import java.security.MessageDigest

object HashUtils {

	/**
	 * It takes a string and returns a SHA-512 hash of that string.
	 *
	 * @param input The string to hash
	 * @return A string of the SHA-512 hash of the input string.
	 */
	fun hashString(input: String): String {
		val hexChars = "0123456789ABCDEF"
		val bytes = MessageDigest
			.getInstance("SHA-512")
			.digest(input.toByteArray())
		val result = StringBuilder(bytes.size * 2)

		bytes.forEach {
			val i = it.toInt()
			result.append(hexChars[i shr 4 and 0x0f])
			result.append(hexChars[i and 0x0f])
		}

		return result.toString().lowercase()
	}

	/**
	 * It returns true if the hash of the message is equal
	 * to the hash passed as argument
	 *
	 * @param message The message to be hashed.
	 * @param hash The hash to check against.
	 */
	fun hashCheck(message: String, hash: String) = hashString(message) == hash
}
