package jp.yitt.viewpagertransformerexample.page_transformer

import android.support.v4.view.ViewPager
import android.view.View

class CarouselPageTransformer(
        val paddingLeft: Float,
        val minScale: Float = 0.8f,
        val minAlpha: Float = 0.9f) : ViewPager.PageTransformer {

    var offset: Float = -1f

    override fun transformPage(page: View, position: Float) {
        if (offset == -1f) {
            offset = paddingLeft / page.measuredWidth;
        }
        val normalizedPosition = Math.abs(Math.abs(position - offset) - 1)

        val scaleFactor = minScale + (1f - minScale) * normalizedPosition
        page.scaleX = scaleFactor
        page.scaleY = scaleFactor

        page.alpha = minAlpha + (1f - minAlpha) * normalizedPosition
    }
}