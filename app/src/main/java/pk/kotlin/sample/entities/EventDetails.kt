package pk.kotlin.sample.entities

import com.google.firebase.firestore.DocumentReference

data class EventDetails(
    val date: String,
    val eventTitle: String,
    val venue: Venue,
    val documentReference: DocumentReference
)