package pk.kotlin.sample.viewholders

import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import pk.kotlin.sample.R
import pk.kotlin.sample.entities.Session

/**
 * Created on 02/04/2019.
 */
class ScheduleListViewHolder(itemView: View) : ViewHolder(itemView) {

    val txtHrs = itemView.findViewById<TextView>(R.id.txtHrs)
    val relEvent = itemView.findViewById<LinearLayout>(R.id.relEvent)
    val textTitle = itemView.findViewById<TextView>(R.id.textTitle)
    val textTimings = itemView.findViewById<TextView>(R.id.textTimings)

    fun bind(session: Session) {

        var hour = 1
        var minute = 0

        txtHrs.text = getHours(hour, minute)
        textTitle.text = session.title
        textTimings.text = "dateTime"
//        relEvent.background = session.color
    }

    private fun getHours(hour: Int, minute: Int): String {
        val builder = StringBuilder()
        builder.append(if (hour < 10) '0' + hour.toString() else hour.toString())
        builder.append(":")
        builder.append(if (minute < 10) '0' + minute.toString() else minute.toString())
        builder.append("\n")
        builder.append("HRS")
        return builder.toString()
    }

}