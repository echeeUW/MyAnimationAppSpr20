package com.ericchee.myanimationapp.activitytransition

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ericchee.myanimationapp.R
import kotlinx.android.synthetic.main.activity_first_transition.*

// Rename the Pair class from the Android framework to avoid a name clash
import android.util.Pair as UtilPair

class FirstTransitionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_transition)

        ivIcon1.setOnClickListener {
            goToSecondActivity()
        }
        btnTransition.setOnClickListener {
            goToSecondActivity()
        }

        btnTransition.transitionName = getString(R.string.transitionButtonName)
    }

    private fun goToSecondActivity() {
        val intent = Intent(this, SecondTransitionActivity::class.java)

        val options = ActivityOptions.makeSceneTransitionAnimation(this,
            UtilPair.create(ivIcon1 as View, "largeImage"),
            UtilPair.create(btnTransition as View, getString(R.string.transitionButtonName))
        )

        startActivity(intent, options.toBundle())
    }
}