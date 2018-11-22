package com.socratesdiaz.prototimer.feature.search

import com.socratesdiaz.prototimer.feature.search.usecase.SearchUseCase
import com.socratesdiaz.prototimer.feature.search.usecase.SearchUseCaseImpl
import com.socratesdiaz.prototimer.feature.search.viewmodel.SearchViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

private const val MODULE_NAME = "Search Module"

val searchModule = Kodein.Module(MODULE_NAME, false) {
    bind<SearchUseCase>() with provider { SearchUseCaseImpl(instance()) }
    bind<SearchViewModelFactory>() with provider { SearchViewModelFactory(instance()) }
}