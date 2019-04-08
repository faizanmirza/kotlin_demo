package pk.kotlin.sample.utils

import android.graphics.drawable.Drawable
import pk.kotlin.sample.KotlinApplication
import pk.kotlin.sample.R

/**
 * Created on 02/04/2019.
 */
object Utils {

    lateinit var colorHashMap: HashMap<String, Int>

    init {
        initColor()
    }

    private fun initColor() {

        colorHashMap = HashMap  ()
        colorHashMap["teal"] = R.color.listColor1
        colorHashMap["blueGrey"] = R.color.listColor2
        colorHashMap["brown"] = R.color.listColor3
        colorHashMap["amber"] = R.color.listColor4
        colorHashMap["lightBlue"] = R.color.listColor5
        colorHashMap["indigoAccent"] = R.color.listColor6
        colorHashMap["green"] = R.color.listColor1
    }

    fun getColor(id: Int): Int {
        return KotlinApplication.getInstance().resources.getColor(id)
    }

    fun getString(id: Int): String {
        return KotlinApplication.getInstance().resources.getString(id)
    }

    fun getDrawable(id: Int): Drawable {
        return KotlinApplication.getInstance().resources.getDrawable(id)
    }

    fun getListingColor(color: String): Int? {

        return if (colorHashMap[color] != null) {
            colorHashMap[color]
        } else {
            R.color.listColor1
        }
    }
}