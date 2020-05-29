package com.ericchee.myanimationapp.autoanimate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ericchee.myanimationapp.R
import kotlinx.android.synthetic.main.activity_auto_animate_layout_changes.*

class AutoAnimateLayoutChangesActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_animate_layout_changes)

        btnMoveBox.setOnClickListener {
            val isVisible = redBox.visibility == View.VISIBLE
            redBox.visibility = if (isVisible) View.INVISIBLE else View.VISIBLE
        }
    }
}