package com.trust.calculatelayout;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

import java.lang.reflect.Field;

/**
 * Created by Trust on 2018/1/23.
 */

public class TrustUITool {
    private static TrustUITool uiTool;
    public static TrustUITool getInstance(){
        return uiTool;
    }

    public static void initTrustUITool(Context context){
        if (uiTool == null) {
            uiTool = new TrustUITool(context);
        }
    }


    private static   float STANDARD_WIDTH = 1080.0F;
    private static   float STANDARD_HEIGHT = 1872.0F;

    public static void setBenchmark(float width,float height){
        STANDARD_WIDTH = width;
        STANDARD_HEIGHT = height - 48;
    }

    //基准高度要减去48
    public float disPlayMetricsWidth;
    public float disPlayMetricsHeight ;
    private TrustUITool(Context context){
        //获取屏幕的宽高
        WindowManager windowManager  = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics  =  new DisplayMetrics();
        if (disPlayMetricsWidth == 0.0F || disPlayMetricsHeight == 0.0F) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
//            获取到状态栏的高度
            int systemBarHight = getSystemBarHeight(context);
            //处理真实宽高的问题
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {//横屏
                Log.d("lhh", "TrustUITool: 横屏");
                this.disPlayMetricsWidth =(float) displayMetrics.widthPixels;
                this.disPlayMetricsHeight =(float) displayMetrics.heightPixels - systemBarHight;
            }else{//竖屏
                Log.d("lhh", "TrustUITool: 竖屏");
                this.disPlayMetricsWidth = (float) displayMetrics.widthPixels;
                this.disPlayMetricsHeight = (float ) displayMetrics.heightPixels ;
            }
        }
    }

    private int getSystemBarHeight(Context context) {

        return getValue(context,"com.android.internal.R$dimen","system_bar_height",48);
    }

    private int getValue(Context context, String attrGroupClass, String attrName, int defValue) {
        try {
            Class e  = Class.forName(attrGroupClass);
            Object o = e.newInstance();
            Field field = e.getField(attrName);
            int x = Integer.parseInt(field.get(o).toString());
            return  context.getResources().getDimensionPixelOffset(x);
        } catch (Exception e1) {
            return defValue;
        }

    }


    //开始 获取缩放以后的结果
    public float getWith(float width){
        Log.d("lhh", "getWith: disPlayMetricsWidth:"+disPlayMetricsWidth);
        return width*this.disPlayMetricsWidth/STANDARD_WIDTH;
    }

    public float getHeight(float height){
        Log.d("lhh", "getWith: disPlayMetricsHeight:"+disPlayMetricsHeight);
        return height * this.disPlayMetricsHeight/STANDARD_HEIGHT;
    }


    public int getWith(int width){
        Log.d("lhh", "getWith: disPlayMetricsWidth:"+disPlayMetricsWidth);
        return (int) (width*this.disPlayMetricsWidth/STANDARD_WIDTH);
    }

    public int getHeight(int height){
        Log.d("lhh", "getWith: disPlayMetricsHeight:"+disPlayMetricsHeight);
        return (int) (height * this.disPlayMetricsHeight/STANDARD_HEIGHT);
    }

}
