package pk.kotlin.sample.entities

import com.google.firebase.firestore.DocumentReference

data class EventDetails(
    var date: String,
    var eventTitle: String,
    var venue: Venue,
    var documentReference: DocumentReference
)