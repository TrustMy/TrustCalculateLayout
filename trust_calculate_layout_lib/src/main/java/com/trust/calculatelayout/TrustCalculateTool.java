package com.trust.calculatelayout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;


/**
 * Created by Trust on 2018/1/24.
 */

public class TrustCalculateTool {
    private static WindowManager wm1;
    private static int width1;
    private static int height1;

   public static void init(Context context){
       if (wm1 == null) {
           wm1 = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
           width1 = wm1.getDefaultDisplay().getWidth();
           height1 = wm1.getDefaultDisplay().getHeight();
       }
   }



    public static  void setLayoutSize(ViewGroup viewGroup){
        if (viewGroup != null) {
            //测量子控件
            int chiladCount = viewGroup.getChildCount();
            for (int i = 0; i < chiladCount; i++) {
                View child = viewGroup.getChildAt(i);
                ViewGroup.LayoutParams layoutParams  = child.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) child.getLayoutParams();
                //把已经得到的布局参数进行更改
                float widthX ;
                float heightY ;
                float marginTop,marginRight,marginLeft,marginBottom;
                if(layoutParams instanceof  TrustTelescopicRelativeLayout.LayoutParams ||
                        layoutParams instanceof TrustTelescopicLinerLayout.LayoutParams){
                    //获取布文件上的内容
                    widthX = getWidth( layoutParams);
                    heightY = getHeight(layoutParams);
                    marginTop = getMarginTop(layoutParams);
                    marginLeft = getMarginLeft(layoutParams);
                    marginRight = getMarginRight(layoutParams);
                    marginBottom = getMarginBottom(layoutParams);

                    if (widthX >0) {
                        layoutParams.width = (int) TrustUITool.getInstance().getWith(widthX);
                    }else if(widthX == -1){
                        layoutParams.width = width1;
                    }else{
                        layoutParams.width = 0;
                    }

                    if (heightY >0) {
                        if(heightY != widthX){
                            layoutParams.height = (int) TrustUITool.getInstance().getHeight(heightY);
                        }else{
                            layoutParams.height = (int) TrustUITool.getInstance().getWith(widthX);
                        }
                    }else if(heightY == -1){
                        layoutParams.height = height1;
                    }else{
                        layoutParams.height = 0;
                    }


                    marginTop = TrustUITool.getInstance().getHeight(marginTop);
                    marginLeft = TrustUITool.getInstance().getWith(marginLeft);
                    marginRight = TrustUITool.getInstance().getWith(marginRight);
                    marginBottom = TrustUITool.getInstance().getHeight(marginBottom);
                    marginLayoutParams.setMargins((int) marginLeft, (int) marginTop, (int) marginRight, (int) marginBottom);

                }
            }
        }
    }

    private static float getWidth(ViewGroup.LayoutParams layoutParams) {
        float width  = 0;
        if (layoutParams instanceof  TrustTelescopicRelativeLayout.LayoutParams) {
            width = ((TrustTelescopicRelativeLayout.LayoutParams)layoutParams).getWidth();
        }else if(layoutParams instanceof  TrustTelescopicLinerLayout.LayoutParams){
            width = ((TrustTelescopicLinerLayout.LayoutParams)layoutParams).getWidth();
        }
        return width;
    }

    private static float getHeight(ViewGroup.LayoutParams layoutParams) {
        float height  = 0;
        if (layoutParams instanceof  TrustTelescopicRelativeLayout.LayoutParams) {
            height = ((TrustTelescopicRelativeLayout.LayoutParams)layoutParams).getHeight();
        }else if(layoutParams instanceof  TrustTelescopicLinerLayout.LayoutParams){
            height = ((TrustTelescopicLinerLayout.LayoutParams)layoutParams).getHeight();
        }
        return height;
    }

    private static float getMarginTop(ViewGroup.LayoutParams layoutParams) {
        float marginTop  = 0;
        if (layoutParams instanceof  TrustTelescopicRelativeLayout.LayoutParams) {
            marginTop = ((TrustTelescopicRelativeLayout.LayoutParams)layoutParams).getMarginTop();
        }else if(layoutParams instanceof  TrustTelescopicLinerLayout.LayoutParams){
            marginTop = ((TrustTelescopicLinerLayout.LayoutParams)layoutParams).getMarginTop();
        }
        return marginTop;
    }


    private static float getMarginLeft(ViewGroup.LayoutParams layoutParams) {
        float marginLeft  = 0;
        if (layoutParams instanceof  TrustTelescopicRelativeLayout.LayoutParams) {
            marginLeft = ((TrustTelescopicRelativeLayout.LayoutParams)layoutParams).getMarginLeft();
        }else if(layoutParams instanceof  TrustTelescopicLinerLayout.LayoutParams){
            marginLeft = ((TrustTelescopicLinerLayout.LayoutParams)layoutParams).getMarginLeft();
        }
        return marginLeft;
    }

    private static float getMarginRight(ViewGroup.LayoutParams layoutParams) {
        float marginRight  = 0;
        if (layoutParams instanceof  TrustTelescopicRelativeLayout.LayoutParams) {
            marginRight = ((TrustTelescopicRelativeLayout.LayoutParams)layoutParams).getMarginRight();
        }else if(layoutParams instanceof  TrustTelescopicLinerLayout.LayoutParams){
            marginRight = ((TrustTelescopicLinerLayout.LayoutParams)layoutParams).getMarginRight();
        }
        return marginRight;
    }

    private static float getMarginBottom(ViewGroup.LayoutParams layoutParams) {
        float marginBottom  = 0;
        if (layoutParams instanceof  TrustTelescopicRelativeLayout.LayoutParams) {
            marginBottom = ((TrustTelescopicRelativeLayout.LayoutParams)layoutParams).getMarginBottom();
        }else if(layoutParams instanceof  TrustTelescopicLinerLayout.LayoutParams){
            marginBottom = ((TrustTelescopicLinerLayout.LayoutParams)layoutParams).getMarginBottom();
        }
        return marginBottom;
    }


}
