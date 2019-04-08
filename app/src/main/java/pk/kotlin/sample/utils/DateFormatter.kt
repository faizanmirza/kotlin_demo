package pk.kotlin.sample.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created on 02/04/2019.
 */
object DateFormatter {
    internal object DateFormats {
        var shortUiDateTimeFormat: String = "MMM dd, yyyy, h:mm a"
        var shortUiDateFormat: String = "MMM dd, yyyy"
        var shortUiTimeFormat: String = "h:mm a"
    }

    fun formatDate(date: Date?, format: String): String {
        val formatter = SimpleDateFormat(format)
        return formatter.format(date)
    }
}