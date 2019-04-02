package pk.kotlin.sample.utils

import pk.kotlin.sample.KotlinApplication

/**
 * Created on 02/04/2019.
 */
object Utils {

    fun getColor(id: Int): Int {
        return KotlinApplication.instance.resources.getColor(id)
    }

    fun getString(id: Int): String {
        return KotlinApplication.instance.resources.getString(id)
    }
}