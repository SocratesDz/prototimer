package com.socratesdiaz.prototimer.feature

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.socratesdiaz.prototimer.R
import com.socratesdiaz.prototimer.feature.search.ui.SearchFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SearchFragment.newInstance())
                .commitNow()
        }
    }

}
