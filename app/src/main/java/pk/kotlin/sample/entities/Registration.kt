package pk.kotlin.sample.entities

/**
 * Created on 01/04/2019.
 */
data class Registration(
    var phone: String,
    var occupation: String,
    var workOrInstitute: String,
    var designation: String
) {

    constructor() : this("", "", "", "")
}