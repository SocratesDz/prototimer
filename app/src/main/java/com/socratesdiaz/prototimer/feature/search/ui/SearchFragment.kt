package com.socratesdiaz.prototimer.feature.search.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.socratesdiaz.prototimer.R
import com.socratesdiaz.prototimer.feature.search.viewmodel.SearchViewModel
import com.socratesdiaz.prototimer.feature.search.viewmodel.SearchViewState

class SearchFragment : Fragment() {

    companion object {
        fun newInstance() = SearchFragment()
    }

    private lateinit var viewModel: SearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.search_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)
        viewModel.searchResults().observe(this, Observer(::proccessState))
    }

    private fun proccessState(searchViewState: SearchViewState?) {

    }
}
