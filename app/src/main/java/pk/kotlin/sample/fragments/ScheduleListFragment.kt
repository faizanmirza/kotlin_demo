package pk.kotlin.sample.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pk.kotlin.sample.R
import pk.kotlin.sample.adapters.ScheduleListAdapter
import pk.kotlin.sample.entities.Session
import pk.kotlin.sample.presenter.ScheduleListPresenter
import pk.kotlin.sample.views.ScheduleListView


class ScheduleListFragment : Fragment(), ScheduleListView {

    private var scheduleListPresenter = ScheduleListPresenter(this)
    private lateinit var recyclerSchedule: RecyclerView
    private lateinit var txtNoSchedule: AppCompatTextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_schedule_list, container, false)
        initUI(view)
        return view
    }

    private fun initUI(view: View) {
        recyclerSchedule = view.findViewById(R.id.recyclerScheduleList)
        txtNoSchedule = view.findViewById(R.id.txtNoSchedule)
        scheduleListPresenter.fetchScheduleList()
    }

    override fun populateList(sessionList: ArrayList<Session>) {
        txtNoSchedule.visibility = View.GONE
        val linearLayoutManager = LinearLayoutManager(targetFragment?.context)
        recyclerSchedule.layoutManager = linearLayoutManager
        val adapter = ScheduleListAdapter(sessionList)
        recyclerSchedule.adapter = adapter
    }

    override fun showNoScheduleMessage() {
        txtNoSchedule.visibility = View.VISIBLE
        recyclerSchedule.visibility = View.GONE
    }
}
