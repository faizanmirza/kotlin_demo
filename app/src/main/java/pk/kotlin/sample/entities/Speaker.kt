package pk.kotlin.sample.entities

/**
 * Created on 01/04/2019.
 */
data class Speaker(
    val id: String,
    val name: String,
    val photoUrl: String,
    val description: String
) {
    constructor() : this("", "", "", "")
}