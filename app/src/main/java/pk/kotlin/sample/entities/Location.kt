package pk.kotlin.sample.entities

/**
 * Created on 01/04/2019.
 */
data class Location(val latitude: Double, val longitude: Double) {
    constructor() : this(0.0, 0.0)
}