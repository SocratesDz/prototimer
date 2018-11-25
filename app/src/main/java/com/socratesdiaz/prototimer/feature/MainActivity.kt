package com.socratesdiaz.prototimer.feature

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.view.ViewGroup
import com.socratesdiaz.prototimer.R
import com.socratesdiaz.prototimer.feature.search.ui.SearchFragment
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.android.synthetic.main.task_detail_content_bottom_sheet.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setupViews()
        showPeekTaskDetailBottomSheet()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SearchFragment.newInstance())
                .commitNow()
        }
    }

    private fun setupViews() {
        taskDetailBottomSheetTitle.setOnClickListener {
            expandTaskDetailBottomSheet()
        }
    }

    private fun showPeekTaskDetailBottomSheet() {
        val taskBottomSheetBehavior = BottomSheetBehavior.from(taskDetailBottomSheet)
        taskBottomSheetBehavior.peekHeight = (resources.displayMetrics.density * 64).roundToInt()
        taskBottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
    }

    private fun expandTaskDetailBottomSheet() {
        val taskBottomSheetBehavior = BottomSheetBehavior.from(taskDetailBottomSheet)
        taskBottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
    }
}
