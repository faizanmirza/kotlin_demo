package pk.kotlin.sample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pk.kotlin.sample.R
import pk.kotlin.sample.adapters.ScheduleListAdapter
import pk.kotlin.sample.entities.Session
import pk.kotlin.sample.presenter.ScheduleListPresenter
import pk.kotlin.sample.views.ScheduleListView


class ScheduleListFragment : Fragment(), ScheduleListView {

    var scheduleListPresenter = ScheduleListPresenter(this)
    lateinit var recyclerSchedule: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_schedule_list, container, false)
        recyclerSchedule = view.findViewById(R.id.recyclerScheduleList)
        initUI()
        return view
    }

    private fun initUI() {
        scheduleListPresenter.fetchScheduleList()
    }

    override fun populateList(sessionList: ArrayList<Session>) {
        val linearLayoutManager = LinearLayoutManager(targetFragment?.context)
        recyclerSchedule.layoutManager = linearLayoutManager
        val adapter = ScheduleListAdapter(sessionList)
        recyclerSchedule.adapter = adapter
    }
}
