package jp.yitt.viewpagertransformerexample.component

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

class WrapContentViewPager(context: Context, attr: AttributeSet? = null) : ViewPager(context, attr) {

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        try {
            if (ev == null || adapter == null || adapter.count == 0) {
                return false
            }
            return super.onInterceptTouchEvent(ev)
        } catch(e: RuntimeException) {
            return false
        }
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        try {
            if (ev == null || adapter == null || adapter.count == 0) {
                return false
            }
            return super.onTouchEvent(ev)
        } catch(e: RuntimeException) {
            return false
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        try {
            var mutableHeightMeasureSpec = heightMeasureSpec
            val mode = MeasureSpec.getMode(heightMeasureSpec)

            if (mode == MeasureSpec.UNSPECIFIED || mode == MeasureSpec.AT_MOST) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec)
                var height = 0
                for (i in 0..childCount) {
                    val childView = getChildAt(i)
                    if (childView != null) {
                        childView.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED))
                        val h = childView.measuredHeight + paddingTop + paddingBottom
                        if (h > height) {
                            height = h
                        }
                    }
                }
                mutableHeightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY)
            }

            super.onMeasure(widthMeasureSpec, mutableHeightMeasureSpec)
        } catch(e: RuntimeException) {
            e.printStackTrace()
        }
    }
}