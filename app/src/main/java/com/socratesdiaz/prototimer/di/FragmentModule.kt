package com.socratesdiaz.prototimer.di

import com.socratesdiaz.prototimer.feature.search.viewmodel.SearchViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

private const val MODULE_NAME = "Fragment Module"

val fragmentModule = Kodein.Module(MODULE_NAME, false) {
    bind<SearchViewModelFactory>() with provider { SearchViewModelFactory(instance()) }
}