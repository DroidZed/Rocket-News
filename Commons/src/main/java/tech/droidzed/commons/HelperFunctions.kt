package tech.droidzed.commons

import android.content.Context
import android.widget.Toast


/**
 * This function takes a Context and a String, and shows a Toast with the String as the
 * message.
 *
 * @param context The context of the activity.
 * @param msg The message to display.
 */
fun makeToast(context: Context, msg: String) {
	Toast.makeText(
		context,
		msg,
		Toast.LENGTH_LONG
	).show()
}
