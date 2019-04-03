package pk.kotlin.sample.utils

/**
 * Created on 02/04/2019.
 */
object ValidationHelper {

    val phoneNumberRegex = "^\\+[0-9]{12}\$"

    fun isPhoneNumberValid(number: String): Boolean {

        return number.matches(Regex(phoneNumberRegex))
    }
}