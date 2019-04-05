package pk.kotlin.sample.constants

import androidx.annotation.StringDef

/**
 * Created on 02/04/2019.
 */
class FireStoreCollection() {

    companion object {

        @StringDef(USER, DATE, SESSION, SPEAKER, ATTENDANCE, DATE_REFERENCE)
        @Retention(AnnotationRetention.SOURCE)
        annotation class FireStoreKey

        const val USER = "users"
        const val DATE = "dates"
        const val SESSION = "sessions"
        const val SPEAKER = "speakers"
        const val ATTENDANCE = "attendance"
        const val DATE_REFERENCE = "16032019"

    }

    @FireStoreKey
    lateinit var fireStoreKey: String

    public fun setFireStoreKeys(@FireStoreKey fireStoreKey: String) {
        this.fireStoreKey = fireStoreKey

    }
}