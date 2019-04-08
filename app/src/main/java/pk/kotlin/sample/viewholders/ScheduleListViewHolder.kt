package pk.kotlin.sample.viewholders

import android.graphics.drawable.GradientDrawable
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import pk.kotlin.sample.R
import pk.kotlin.sample.entities.Session
import pk.kotlin.sample.utils.DateFormatter
import pk.kotlin.sample.utils.DateFormatter.formatDate
import pk.kotlin.sample.utils.Utils


/**
 * Created on 02/04/2019.
 */
class ScheduleListViewHolder(itemView: View) : ViewHolder(itemView) {

    private val txtHrs = itemView.findViewById<AppCompatTextView>(R.id.txtHrs)
    private val relEvent = itemView.findViewById<LinearLayout>(R.id.relEvent)
    private val textTitle = itemView.findViewById<AppCompatTextView>(R.id.textTitle)
    private val textTimings = itemView.findViewById<AppCompatTextView>(R.id.textTimings)

    fun bind(session: Session) {

        var hour = session.startDateTime?.hours
        var minute = session.startDateTime?.minutes

        txtHrs.text = getHours(hour, minute)
        textTitle.text = session.title



        textTimings.text = getTimingString(session)
        setBackgroundColor(session)
    }

    private fun getTimingString(session: Session): String {

        var txtTimings = java.lang.StringBuilder()

        txtTimings.append(
            session.startDateTime,
            DateFormatter.DateFormats.shortUiDateTimeFormat
        )
        txtTimings.append(Utils.getString(R.string.dash))
        txtTimings.append(
            formatDate(
                session.endDateTime, DateFormatter.DateFormats.shortUiTimeFormat
            )
        )

        return txtTimings.toString()
    }

    private fun setBackgroundColor(session: Session) {
        var color = session.getSessionBackGroundColor()

        if (color == null)
            color = R.color.listColor2

        val background = relEvent.background

        if (background is GradientDrawable) {
            background.setColor(Utils.getColor(color))
        } else {
            relEvent.setBackgroundColor(Utils.getColor(color))
        }
    }

    private fun getHours(hour: Int?, minute: Int?): String {

        val builder = StringBuilder()
        builder.append(if (hour!! < 10) "0$hour" else hour.toString())
        builder.append(":")
        builder.append(if (minute!! < 10) "0$minute" else minute.toString())
        builder.append("\n")
        builder.append(Utils.getString(R.string.hrs))
        return builder.toString()
    }

}