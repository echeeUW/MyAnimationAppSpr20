package com.ericchee.myanimationapp.animationplayground

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import com.ericchee.myanimationapp.R
import kotlinx.android.synthetic.main.activity_animation_playground.*

class AnimationPlaygroundActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_playground)

        btnMoveBox.setOnClickListener {
            moveRedBoxesV2()
//            moveBlueBox()
        }
    }

    private var isRedBoxMoved = false
    private fun moveRedBox(){
        if (isRedBoxMoved) {
            redBox.animate()
                .translationX(0f)
//                .alpha(1f)
                .rotation(0f)
                .withStartAction {
                    redBox.visibility = View.VISIBLE
                }
                .setDuration(2000)
                .start()
        } else {
            redBox.animate()
                .translationX(this.convertDpToPixel(200))
//                .alpha(.3f)
                .rotation(180f)
                .setDuration(2000)
                .withEndAction{
//                    redBox.visibility = View.GONE
                }
                .start()

        }
        isRedBoxMoved = !isRedBoxMoved
    }

    private fun moveBlueBox(){
        if (!isRedBoxMoved) {
            blueBox.animate()
                .translationX(0f)
                .setDuration(2000)
                .start()
        } else {
            blueBox.animate()
                .translationX(this.convertDpToPixel(-50))
                .setDuration(2000)
                .start()
        }
    }

    /**
     * View.
     *    TRANSLATION_X/Y
     *    ROTATION, ROTATION_X/Y
     *    SCALE_X/Y
     *    X/Y
     *    ALPHA
     *    Note: You can setting the view.pivotX/Y for animation(s) (default is center of view)
     */
    private fun moveRedBoxesV2() {
        val translateAnimatorRed = ObjectAnimator.ofFloat(redBox, View.TRANSLATION_X, convertDpToPixel(200))
        val translateAnimatorBlue = ObjectAnimator.ofFloat(blueBox, View.TRANSLATION_X, convertDpToPixel(-100))

        AnimatorSet().apply {
            playTogether(translateAnimatorRed, translateAnimatorBlue)
            addListener(object: Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {
                }

                override fun onAnimationEnd(animation: Animator?) {
                    redBox.visibility = View.GONE
                }

                override fun onAnimationCancel(animation: Animator?) {

                }

                override fun onAnimationStart(animation: Animator?) {

                }

            })
            start()
        }
    }


}

fun Context.convertDpToPixel(dp: Number) = dp.toFloat() * (resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)
fun Context.convertPixelToDp(px: Number) = px.toFloat() / (resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)