package com.ericchee.myanimationapp.viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.ericchee.myanimationapp.R
import kotlinx.android.synthetic.main.activity_sliding_pages.*

class SlidingPagesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sliding_pages)


        val adapter = MyPageAdapter(this)
        pager.adapter = adapter

        pager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Toast.makeText(this@SlidingPagesActivity, "Changed paged to $position", Toast.LENGTH_SHORT).show()
            }
        })

        btnPage1.setOnClickListener {
            pager.currentItem = 0
        }

        btnPage2.setOnClickListener {
            pager.currentItem = 1
        }
    }
}