package com.socratesdiaz.prototimer.feature.search.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.socratesdiaz.prototimer.R
import com.socratesdiaz.prototimer.data.models.jira.IssueBean
import com.socratesdiaz.prototimer.feature.search.viewmodel.SearchViewModel
import com.socratesdiaz.prototimer.feature.search.viewmodel.SearchViewModelFactory
import com.socratesdiaz.prototimer.feature.search.viewmodel.SearchViewState
import kotlinx.android.synthetic.main.search_fragment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class SearchFragment : Fragment(), KodeinAware {

    companion object {
        fun newInstance() = SearchFragment()
    }

    override val kodein by closestKodein(context!!)

    private lateinit var viewModel: SearchViewModel
    private val viewModelFactory: SearchViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.search_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SearchViewModel::class.java)
        viewModel.searchResults().observe(this, Observer(::processState))
        viewModel.searchTask("CC")
    }

    private fun processState(state: SearchViewState?) {
        when(state) {
            is SearchViewState.Loading -> renderLoadingState()
            is SearchViewState.Error -> renderErrorState(state.errorMessage)
            is SearchViewState.Results -> renderSearchResults(state.results)
            is SearchViewState.NoResults -> renderNoResultsState()
        }
    }

    private fun renderLoadingState() {
        progressBar.visibility = View.VISIBLE
    }

    private fun renderErrorState(message: String) {
        progressBar.visibility = View.GONE
    }

    private fun renderSearchResults(results: List<IssueBean?>?) {
        progressBar.visibility = View.GONE
        val searchResultAdapter = SearchResultsAdapter(results)
        searchResults.adapter = searchResultAdapter
        searchResults.layoutManager = LinearLayoutManager(context)
    }

    private fun renderNoResultsState() {
        progressBar.visibility = View.GONE
    }
}
