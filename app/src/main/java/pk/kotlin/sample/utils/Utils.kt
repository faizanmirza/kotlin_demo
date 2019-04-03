package pk.kotlin.sample.utils

import android.graphics.drawable.Drawable
import pk.kotlin.sample.KotlinApplication

/**
 * Created on 02/04/2019.
 */
object Utils {

    fun getColor(id: Int): Int {
        return KotlinApplication.getInstance().resources.getColor(id)
    }

    fun getString(id: Int): String {
        return KotlinApplication.getInstance().resources.getString(id)
    }

    fun getDrawable(id: Int): Drawable {
        return KotlinApplication.getInstance().resources.getDrawable(id)
    }
}