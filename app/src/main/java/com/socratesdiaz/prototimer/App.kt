package com.socratesdiaz.prototimer

import android.app.Application
import android.content.Context
import com.socratesdiaz.prototimer.di.fragmentModule
import com.socratesdiaz.prototimer.di.networkModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

class App: Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        bind<Context>("ApplicationContext") with singleton { this@App.applicationContext }
        import(networkModule)
        import(fragmentModule)
    }
}