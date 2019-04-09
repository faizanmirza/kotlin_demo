package pk.kotlin.sample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pk.kotlin.sample.R
import pk.kotlin.sample.listeners.ContributionListItemListener
import pk.kotlin.sample.viewholders.ContributionListViewHolder


/**
 * Created on 02/04/2019.
 */

class ContributionListAdapter(
    private val contributionList: ArrayList<String>, contributionListItemListener: ContributionListItemListener
) : RecyclerView.Adapter<ContributionListViewHolder>() {
    var contributionListItemListener: ContributionListItemListener = contributionListItemListener

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ContributionListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_contribution_list, viewGroup, false)
        return ContributionListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contributionList.size
    }

    override fun onBindViewHolder(contributionListViewHolder: ContributionListViewHolder, position: Int) {
        contributionListViewHolder.bind(contributionList[position], contributionListItemListener)
    }
}