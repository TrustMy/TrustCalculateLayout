package com.trust.calculatelayout.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.trust.calculatelayout.R;

/**
 * Created by Trust on 2018/1/23.
 */

public class TrustTelescopicRelativeLayout extends RelativeLayout {

    public TrustTelescopicRelativeLayout(Context context) {
        this(context,null);
    }

    public TrustTelescopicRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TrustTelescopicRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TrustCalculateTool.init(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        TrustCalculateTool.setLayoutSize(this);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }



    @Override
    public RelativeLayout.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(),attrs);
    }

    public static class LayoutParams extends RelativeLayout.LayoutParams{

        private float width;
        private float height;
        private float marginTop ,marginLeft,marginBottom,marginRight;

        public float getMarginTop() {
            return marginTop;
        }

        public float getMarginLeft() {
            return marginLeft;
        }

        public float getMarginBottom() {
            return marginBottom;
        }

        public float getMarginRight() {
            return marginRight;
        }

        public float getWidth() {
            return width;
        }


        public float getHeight() {
            return height;
        }


        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray array = c.obtainStyledAttributes(attrs,R.styleable.TrustTelescopicStyle);
            width = array.getFloat(R.styleable.TrustTelescopicStyle_trust_layout_width,getWidth());
            height = array.getFloat(R.styleable.TrustTelescopicStyle_trust_layout_height,getHeight());
            marginTop = array.getFloat(R.styleable.TrustTelescopicStyle_trust_layout_marginTop,getMarginTop());
            marginRight = array.getFloat(R.styleable.TrustTelescopicStyle_trust_layout_marginRight,getMarginRight());
            marginLeft = array.getFloat(R.styleable.TrustTelescopicStyle_trust_layout_marginLeft,getMarginLeft());
            marginBottom = array.getFloat(R.styleable.TrustTelescopicStyle_trust_layout_marginBottom,getMarginBottom());
        }


    }
}
