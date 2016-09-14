package jp.yitt.viewpagertransformerexample.page_transformer

import android.support.v4.view.ViewPager
import android.view.View

class ScaleAlphaPageTransformer(val paddingLeft: Float) : ViewPager.PageTransformer {

    var offset: Float = -1f

    override fun transformPage(page: View, position: Float) {
        if (offset == -1f) {
            offset = paddingLeft / page.measuredWidth;
        }

        if (position > -1 && position <= 1) {
            val scaleFactor = Math.max(0.9f, 1 - Math.abs(position - offset))
            page.scaleX = scaleFactor
            page.scaleY = scaleFactor
            page.alpha = Math.max(0.8f, 1 - Math.abs(position - offset))
        } else {
            page.alpha = 0f
        }
    }
}