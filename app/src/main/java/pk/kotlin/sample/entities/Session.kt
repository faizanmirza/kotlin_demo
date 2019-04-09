package pk.kotlin.sample.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import pk.kotlin.sample.utils.Utils
import java.util.*

/**
 * Created on 01/04/2019.
 */
@Parcelize
class Session(
    val id: String,
    val title: String,
    val startDateTime: Date?,
    val endDateTime: Date?,
    val color: String,
    val textColor: String,
    val description: String,
    val speakerId: String,
    val speakers: List<String>?

) : Parcelable {
    constructor() : this("", "", null, null, "", "", "", "", null)

    fun getSessionBackGroundColor(): Int? {
        return Utils.getListingColor(color)
    }
}