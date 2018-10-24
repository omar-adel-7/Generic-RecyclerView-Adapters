package com.rafakob.drawme;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import com.rafakob.drawme.delegate.DrawMe;
import com.rafakob.drawme.delegate.DrawMeShapeText;

import omar.apps923.recycleradapters.R;

public class DrawMeButton extends AppCompatButton {

    private final DrawMe drawMe;

    public DrawMeButton(Context context) {
        this(context, null);
    }

    public DrawMeButton(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.buttonStyle);
    }

    public DrawMeButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        Typeface face= Typeface.createFromAsset(context.getAssets(), "Cocon_NextArabicRegular.ttf");
        this.setTypeface(face);

        drawMe = new DrawMeShapeText(context, this, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int[] size = drawMe.onMeasure(widthMeasureSpec, heightMeasureSpec);
        super.onMeasure(size[0], size[1]);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        drawMe.onLayout(changed, left, top, right, bottom);
    }
}