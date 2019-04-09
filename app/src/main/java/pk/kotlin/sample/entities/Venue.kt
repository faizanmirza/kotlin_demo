package pk.kotlin.sample.entities

data class Venue(
    val title: String,
    val address: String,
    val city: String,
    val imageUrl: String,
    val location: Location?

) {
    constructor() : this("", "", "", "", null)
}
