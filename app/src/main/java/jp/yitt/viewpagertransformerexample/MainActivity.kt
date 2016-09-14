package jp.yitt.viewpagertransformerexample

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.ViewTreeObserver
import jp.yitt.viewpagertransformerexample.page_transformer.CarouselPageTransformer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pager = findViewById(R.id.pager) as ViewPager

        val pagerAdapter = SimpleViewPagerAdapter(supportFragmentManager, 10)
        val pageTransformer = CarouselPageTransformer(pager.paddingLeft.toFloat())

        pager.setPageTransformer(true, pageTransformer)

        pager.adapter = pagerAdapter

        pager.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                pager.viewTreeObserver.removeOnGlobalLayoutListener(this)

                val itemWidth = pager.measuredWidth - pager.paddingLeft - pager.paddingRight
                val spaceWidth = (itemWidth * (1f - pageTransformer.minScale) / 2 + 0.5f).toInt()

                pager.pageMargin = pager.paddingTop - spaceWidth
            }
        })
    }
}
