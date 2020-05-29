package com.ericchee.myanimationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ericchee.myanimationapp.activitytransition.FirstTransitionActivity
import com.ericchee.myanimationapp.animationplayground.AnimationPlaygroundActivity
import com.ericchee.myanimationapp.autoanimate.AutoAnimateLayoutChangesActivity
import com.ericchee.myanimationapp.viewpager2.SlidingPagesActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAnimationPlayground.setOnClickListener {
            launch(AnimationPlaygroundActivity::class.java)
        }
        btnAutoAnimationLayoutChanges.setOnClickListener {
            launch(AutoAnimateLayoutChangesActivity::class.java)
        }
        btnActivityTransition.setOnClickListener {
            launch(FirstTransitionActivity::class.java)
        }
        btnViewPager2.setOnClickListener {
            launch(SlidingPagesActivity::class.java)
        }

    }

    private fun <T> launch(klass: Class<T>) {
        startActivity(Intent(this, klass))
    }
}