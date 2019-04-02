package pk.kotlin.sample.entities

import com.google.firebase.firestore.DocumentReference
import java.time.LocalDateTime

/**
 * Created on 01/04/2019.
 */
data class Session(
    val id: String,
    val title: String,
    val startDateTime: String,
    val endDateTime: String,
    val color: String,
    val textColor: String,
    val description: String,
    val speakerId: String,
    val speakers: List<String>

)