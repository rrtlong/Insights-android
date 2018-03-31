package com.imalljoy.insights.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;

import com.imalljoy.insights.R;

import java.math.BigDecimal;

/**
 * Created by lijilong on 03/09.
 */

public class CommonUtils {
    /**
     * 利用反射获取状态栏高度
     *
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        //获取状态栏高度的资源id
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * 设置状态栏颜色,状态栏占用空间
     *
     * @param activity
     * @param colorId  颜色资源id
     */
    public static void tryShowStatusBar(Activity activity, int colorId) {
        int color = ContextCompat.getColor(activity, colorId);
        //设置 paddingTop
        ViewGroup rootView = (ViewGroup) activity.getWindow().getDecorView().findViewById(android.R.id.content);
        rootView.setPadding(0, getStatusBarHeight(activity), 0, 0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //5.0 以上直接设置状态栏颜色
            activity.getWindow().setStatusBarColor(color);
        } else {
            //根布局添加占位状态栏
            ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
            View statusBarView = new View(activity);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    getStatusBarHeight(activity));
            statusBarView.setBackgroundColor(color);
            decorView.addView(statusBarView, lp);
        }
    }
    public static int getColorResourceFromStrg(String level){
        int color = R.color.c_e;
        if(level == null || level.length()>2 ||level.length()==0){
            return color;
        }else if(level.length() == 1){
            switch (level.substring(0,1)){
                case "A":
                    color = R.color.c_a;
                    break;
                case "B":
                    color = R.color.c_b;
                    break;
                case "C":
                    color = R.color.c_c;
                    break;
                case "D":
                    color = R.color.c_d;
                    break;
                case "E":
                    color = R.color.c_e;
                    break;
            }
        }
        return color;
    }

    /**
     * 四舍五入
     * @param scale 设置小说
     * @return
     */
    public static float MathRound(float orignal,int scale){
        int roundingMode = 4;//表示四舍五入，可以选取其他模式
        BigDecimal bd = new BigDecimal(orignal);
        bd = bd.setScale(scale,BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
}
