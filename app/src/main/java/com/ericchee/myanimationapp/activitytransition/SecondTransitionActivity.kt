package com.ericchee.myanimationapp.activitytransition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ericchee.myanimationapp.R
import kotlinx.android.synthetic.main.activity_second_transition.*

class SecondTransitionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_transition)

        btnNavigation.setOnClickListener {
            finishAfterTransition()
        }
    }
}