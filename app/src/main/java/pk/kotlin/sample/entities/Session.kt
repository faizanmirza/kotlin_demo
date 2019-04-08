package pk.kotlin.sample.entities

import pk.kotlin.sample.utils.Utils
import java.util.*

/**
 * Created on 01/04/2019.
 */
data class Session(
    val id: String,
    val title: String,
    val startDateTime: Date?,
    val endDateTime: Date?,
    val color: String,
    val textColor: String,
    val description: String,
    val speakerId: String,
    val speakers: List<String>?

) {
    constructor() : this("", "", null, null, "", "", "", "", null)

    fun getSessionBackGroundColor(): Int? {
        return Utils.getListingColor(color)
    }
}