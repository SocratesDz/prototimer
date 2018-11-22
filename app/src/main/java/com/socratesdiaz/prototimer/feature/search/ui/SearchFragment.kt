package com.socratesdiaz.prototimer.feature.search.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.*
import com.socratesdiaz.prototimer.R
import com.socratesdiaz.prototimer.data.models.jira.IssueBean
import com.socratesdiaz.prototimer.feature.search.searchModule
import com.socratesdiaz.prototimer.feature.search.viewmodel.SearchViewModel
import com.socratesdiaz.prototimer.feature.search.viewmodel.SearchViewModelFactory
import com.socratesdiaz.prototimer.feature.search.viewmodel.SearchViewState
import kotlinx.android.synthetic.main.search_fragment.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.LateInitKodein
import org.kodein.di.generic.instance

class SearchFragment : Fragment(), KodeinAware {

    companion object {
        fun newInstance() = SearchFragment()
    }

    private val applicationKodein = LateInitKodein()

    override val kodein = Kodein.lazy {
        extend(applicationKodein)
        import(searchModule)
    }

    private lateinit var viewModel: SearchViewModel
    private val viewModelFactory: SearchViewModelFactory by instance()

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        applicationKodein.baseKodein = (context?.applicationContext as KodeinAware).kodein
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

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
        processState(SearchViewState.NoResults)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.search_menu, menu)
        val searchAction = menu?.findItem(R.id.action_search)
        val searchView = searchAction?.actionView as? SearchView
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.searchTask(query ?: "")
                return false
            }

            override fun onQueryTextChange(query: String?) = false
        })
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
        Log.d(SearchFragment::class.java.simpleName, message)
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
