package com.socratesdiaz.prototimer.feature.search.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.socratesdiaz.prototimer.data.models.jira.IssueBean

class SearchResultsAdapter(val items: List<IssueBean?>?): RecyclerView.Adapter<SearchResultsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_2, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    override fun onBindViewHolder(holder: SearchResultsAdapter.ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.bind(item)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView? = itemView.findViewById(android.R.id.text1)
        val subtitle: TextView? = itemView.findViewById(android.R.id.text2)

        fun bind(issue: IssueBean?) {
            title?.text = issue?.names
            subtitle?.text = issue?.id
        }
    }
}