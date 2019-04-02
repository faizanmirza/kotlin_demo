package pk.kotlin.sample.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pk.kotlin.sample.R
import pk.kotlin.sample.adapters.ScheduleListAdapter
import pk.kotlin.sample.entities.Session


class ScheduleListFragment : Fragment() {
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

        val linearLayoutManager = LinearLayoutManager(targetFragment?.context)
        recyclerSchedule.layoutManager = linearLayoutManager

        val sessionList = ArrayList<Session>()
        val session = Session("", "asdas", "", "", "", "", "asdasd", "", listOf(String()))
        sessionList.add(session)
        sessionList.add(session)
        sessionList.add(session)
        sessionList.add(session)
        val adapter = ScheduleListAdapter(sessionList)
        recyclerSchedule.adapter = adapter
    }
}
