package pk.kotlin.sample.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pk.kotlin.sample.R
import pk.kotlin.sample.adapters.ContributionListAdapter
import pk.kotlin.sample.listeners.ContributionListItemListener
import pk.kotlin.sample.presenter.ContributionPresenter
import pk.kotlin.sample.views.ContributionView

class ContributionActivity : AppCompatActivity(), ContributionView, ContributionListItemListener {

    private var btnContinue: AppCompatButton? = null
    private var recyclerContribution: RecyclerView? = null
    private var btnSkip: AppCompatButton? = null
    private var errorContributionRequire: AppCompatTextView? = null
    private var contributionPresenter = ContributionPresenter(this)
    private var selectedContributorsList: ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contribution)
        initUI()
    }

    private fun initUI() {
        selectedContributorsList = ArrayList()
        btnContinue = findViewById(R.id.btnContinue)
        recyclerContribution = findViewById(R.id.recyclerContribution)
        btnSkip = findViewById(R.id.btnSkip)
        errorContributionRequire = findViewById(R.id.errorContributionRequire)
        contributionPresenter.getContributionTypeList(this)
        setActionListeners()
    }

    private fun setActionListeners() {

        btnSkip?.setOnClickListener {
            switchToDashboard()
        }

        btnContinue?.setOnClickListener {
            contributionPresenter.isContributionTypeSelected(selectedContributorsList!!.size)
        }
    }

    override fun populateContributorList(contributerList: ArrayList<String>) {
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerContribution?.layoutManager = linearLayoutManager
        var contributionListAdapter = ContributionListAdapter(contributerList, this)
        recyclerContribution?.adapter = contributionListAdapter
    }

    override fun itemSelected(contributorType: String) {

        if (!selectedContributorsList!!.contains(contributorType))
            selectedContributorsList?.add(contributorType)
        else if (selectedContributorsList != null && selectedContributorsList!!.size > 0)
            selectedContributorsList?.remove(contributorType)
    }

    override fun switchToDashboard() {
        errorContributionRequire?.visibility = View.GONE
        var intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun errorContribution() {
        errorContributionRequire?.visibility = View.VISIBLE
    }


}
