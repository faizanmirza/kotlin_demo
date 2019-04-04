package pk.kotlin.sample.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import pk.kotlin.sample.R
import pk.kotlin.sample.entities.Session
import pk.kotlin.sample.viewholders.ScheduleListViewHolder


/**
 * Created on 02/04/2019.
 */

class ScheduleListAdapter(private val sessionList: ArrayList<Session>) : RecyclerView.Adapter<ScheduleListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ScheduleListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_event_list, viewGroup, false)
        return ScheduleListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return sessionList.size
    }

    override fun onBindViewHolder(scheduleListViewHolder: ScheduleListViewHolder, position: Int) {
        scheduleListViewHolder.bind(sessionList.get(position))
    }
}