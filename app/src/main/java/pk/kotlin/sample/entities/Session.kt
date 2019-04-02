package pk.kotlin.sample.entities

/**
 * Created on 01/04/2019.
 */
data class Session(
    val id: String,
    val title: String,
    val startDateTime: String,
    val endDateTime: String,
    val color: Int,
    val textColor: Int,
    val description: String,
    val speakerId: String,
    val speakers: List<String>

)