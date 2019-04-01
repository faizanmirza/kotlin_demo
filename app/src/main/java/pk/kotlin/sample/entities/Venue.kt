package pk.kotlin.sample.entities

import com.google.firebase.firestore.DocumentReference

data class Venue(
    val title: String,
    val address: String,
    val city: String,
    val imageUrl: Venue,
    val location: Location,
    val documentReference: DocumentReference
)
