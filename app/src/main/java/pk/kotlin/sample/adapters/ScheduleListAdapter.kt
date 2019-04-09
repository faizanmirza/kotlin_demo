package pk.kotlin.sample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pk.kotlin.sample.R
import pk.kotlin.sample.entities.Session
import pk.kotlin.sample.listeners.ScheduleListItemListener
import pk.kotlin.sample.viewholders.ScheduleListViewHolder


/**
 * Created on 02/04/2019.
 */

class ScheduleListAdapter(
    private val sessionList: ArrayList<Session>,
    scheduleListItemListener: ScheduleListItemListener
) : RecyclerView.Adapter<ScheduleListViewHolder>() {

    private var scheduleListItemListener = scheduleListItemListener

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ScheduleListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_schedule_list, viewGroup, false)
        return ScheduleListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return sessionList.size
    }

    override fun onBindViewHolder(scheduleListViewHolder: ScheduleListViewHolder, position: Int) {
        scheduleListViewHolder.bind(sessionList.get(position), scheduleListItemListener)
    }
}