package pk.kotlin.sample.entities

import com.google.firebase.firestore.DocumentReference

/**
 * Created on 01/04/2019.
 */
data class Location(val latitude: Double, val longitude: Double, val documentReference: DocumentReference)