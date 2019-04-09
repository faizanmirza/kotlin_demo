package pk.kotlin.sample.fragments

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pk.kotlin.sample.R
import pk.kotlin.sample.activities.ScheduleDetailActivity
import pk.kotlin.sample.activities.UserProfileActivity
import pk.kotlin.sample.adapters.ScheduleListAdapter
import pk.kotlin.sample.constants.GlobalConstants
import pk.kotlin.sample.entities.Session
import pk.kotlin.sample.listeners.ScheduleListItemListener
import pk.kotlin.sample.presenter.ScheduleListPresenter
import pk.kotlin.sample.utils.Utils
import pk.kotlin.sample.views.ScheduleListView


class ScheduleListFragment : Fragment(), ScheduleListView, ScheduleListItemListener {

    private var scheduleListPresenter = ScheduleListPresenter(this)
    private lateinit var recyclerSchedule: RecyclerView
    private lateinit var txtNoSchedule: AppCompatTextView
    private lateinit var imgUser: AppCompatImageView


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
        imgUser = view.findViewById(R.id.imgUser)
        scheduleListPresenter.fetchScheduleList()

        imgUser.setOnClickListener {
            openUserProfile()
        }
    }

    private fun openUserProfile() {
        var intent = Intent(activity, UserProfileActivity::class.java)
        startActivity(intent)
    }

    override fun populateList(sessionList: ArrayList<Session>) {
        txtNoSchedule.visibility = View.GONE
        val linearLayoutManager = LinearLayoutManager(targetFragment?.context)
        recyclerSchedule.layoutManager = linearLayoutManager
        val adapter = ScheduleListAdapter(sessionList, this)
        recyclerSchedule.adapter = adapter
    }

    override fun showNoScheduleMessage() {
        txtNoSchedule.text = Utils.getString(R.string.error_no_schedule)
        txtNoSchedule.visibility = View.VISIBLE
        recyclerSchedule.visibility = View.GONE
    }

    override fun onItemClick(session: Session) {

        if (TextUtils.isEmpty(session.description))
            return

        var intent = Intent(activity, ScheduleDetailActivity::class.java)
        intent.putExtra(GlobalConstants.SESSION, session)
        startActivity(intent)
        activity?.overridePendingTransition(R.anim.slide_bottom_up, R.anim.slide_nothing)
    }
}
