package jp.yitt.viewpagertransformerexample.component;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AspectRatio4to3ImageView extends ImageView {

    public AspectRatio4to3ImageView(Context context) {
        super(context);
    }

    public AspectRatio4to3ImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AspectRatio4to3ImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    public AspectRatio4to3ImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = width * 3 / 4;
        setMeasuredDimension(width, height);
    }
}
