package pk.kotlin.sample.viewholders

import android.view.View
import android.widget.CompoundButton
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import pk.kotlin.sample.R
import pk.kotlin.sample.listeners.ContributionListItemListener

/**
 * Created on 02/04/2019.
 */
class ContributionListViewHolder(itemView: View) : ViewHolder(itemView) {

    val txtContributorType = itemView.findViewById<AppCompatTextView>(R.id.txtContributorType)
    val txtCheck = itemView.findViewById<AppCompatCheckBox>(R.id.txtCheck)

    fun bind(contributor: String, contributionListItemListener: ContributionListItemListener) {

        txtContributorType.text = contributor
        txtCheck.setOnCheckedChangeListener { _: CompoundButton?, isChecked: Boolean ->
            contributionListItemListener.itemSelected(contributor)
        }
    }
}