package com.imalljoy.insightdemo.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;

import com.imalljoy.insightdemo.R;

import java.math.BigDecimal;
import java.text.NumberFormat;

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

    public static int getColorResourceFromStrg(String level) {
        int color = R.color.c_e;
        if (level == null || level.length() > 2 || level.length() == 0) {
            return color;
        } else if (level.length() == 1) {
            switch (level.substring(0, 1)) {
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
     *
     * @param scale 设置小数
     * @return
     */
    public static float MathRound(float orignal, int scale) {
        int roundingMode = 4;//表示四舍五入，可以选取其他模式
        BigDecimal bd = new BigDecimal(orignal);
        bd = bd.setScale(scale, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

    /***
     * //格式化数字，用逗号分割
     * @param number 12345678.12345
     * @return 123, 456, 78.12345
     */
    public static String formatNumberWithCommaSplit(double number) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setGroupingUsed(true);//使用000,000,00.0000方式显示
        return numberFormat.format(number);

    }

    /***
     * //格式化数字，用逗号分割
     * @param number 12345678.12345
     * @return 123, 456, 78.12345
     */
    public static String formatNumberWithCommaSplit(float number) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setGroupingUsed(true);//使用000,000,00.0000方式显示
        return numberFormat.format(number);

    }

    public static int getLogoIdFromString(String iconName) {
        if ("ABYSS.png".equals(iconName)) {
            return R.mipmap.abyss;
        } else if ("ACT.png".equals(iconName)) {
            return R.mipmap.act;
        } else if ("ADA.png".equals(iconName)) {
            return R.mipmap.ada;
        } else if ("BTC.png".equals(iconName)) {
            return R.mipmap.btc;
        } else if ("CMT.png".equals(iconName)) {
            return R.mipmap.cmt;
        } else if ("ECOM.png".equals(iconName)) {
            return R.mipmap.ecom;
        } else if ("ELI.png".equals(iconName)) {
            return R.mipmap.eli;
        } else if ("EOS.png".equals(iconName)) {
            return R.mipmap.eos;
        } else if ("ETH.png".equals(iconName)) {
            return R.mipmap.eth;
        } else if ("FC.png".equals(iconName)) {
            return R.mipmap.fc;
        } else if ("GES.png".equals(iconName)) {
            return R.mipmap.ges;
        } else if ("LTC.png".equals(iconName)) {
            return R.mipmap.ltc;
        } else if ("SWTC.png".equals(iconName)) {
            return R.mipmap.swtc;
        } else if ("TBD.png".equals(iconName)) {
            return R.mipmap.tbd;
        } else if ("UGC.png".equals(iconName)) {
            return R.mipmap.ugc;
        } else if ("XRP.png".equals(iconName)) {
            return R.mipmap.xrp;
        } else if("erc".equals(iconName)){
            return R.mipmap.erc;
        } else if("snrg".equals(iconName)){
            return R.mipmap.snrg;
        } else if("fdz".equals(iconName)){
            return R.mipmap.fdz;
        } else if("vib".equals(iconName)){
            return R.mipmap.vib;
        }
        return R.mipmap.dog_logo;
    }

    public static int getNewCoverFromString(String cover) {
        if ("new_cover1".equals(cover)) {
            return R.mipmap.new_cover1;
        } else if ("new_cover2".equals(cover)) {
            return R.mipmap.new_cover2;
        } else if ("new_cover3".equals(cover)) {
            return R.mipmap.new_cover3;
        } else if ("new_cover4".equals(cover)) {
            return R.mipmap.new_cover4;
        } else if ("new_cover5".equals(cover)) {
            return R.mipmap.new_cover5;
        } else if ("new_cover6".equals(cover)) {
            return R.mipmap.new_cover6;
        } else if ("new_cover7".equals(cover)) {
            return R.mipmap.new_cover7;
        }
        return R.mipmap.default_news_cover;
    }
    public static int getHeadCoverFromString(String cover) {
        if ("head1".equals(cover)) {
            return R.mipmap.head1;
        } else if ("head2".equals(cover)) {
            return R.mipmap.head2;
        } else if ("head3".equals(cover)) {
            return R.mipmap.head3;
        } else if ("head4".equals(cover)) {
            return R.mipmap.head4;
        } else if ("head5".equals(cover)) {
            return R.mipmap.head5;
        } else if ("head6".equals(cover)) {
            return R.mipmap.head6;
        } else if ("head7".equals(cover)) {
            return R.mipmap.head7;
        } else if ("head8".equals(cover)) {
            return R.mipmap.head8;
        } else if ("head9".equals(cover)) {
            return R.mipmap.head9;
        }else if ("head10".equals(cover)) {
            return R.mipmap.head10;
        }
        return R.mipmap.default_head;
    }
}
