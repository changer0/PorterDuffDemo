package com.lulu.porterduffdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author zhanglulu on 2019/9/2.
 * for PorterDuff View
 */
public class PorterDuffView extends View {

    private Paint mPaint;
    private Bitmap sourceBitmap;
    private Bitmap destinationBitmap;
    private PorterDuffXfermode pdMode;

    public PorterDuffView(Context context) {
        super(context);
        init(context);
    }

    public PorterDuffView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PorterDuffView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint();
        sourceBitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.composite_src);
        destinationBitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.composite_dst);
    }

    /**
     * 设置 PorterDuff
     * @param mode
     */
    public void setPdMode(PorterDuff.Mode mode) {
        pdMode = new PorterDuffXfermode(mode);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.RED);
        canvas.drawBitmap(destinationBitmap, 0, 0, mPaint);
        if (pdMode == null) {
            return;
        }
        mPaint.setXfermode(pdMode);
        canvas.drawBitmap(sourceBitmap, 0, 0, mPaint);
    }
}
