package com.is.ui.filter.util;

import android.content.Context;
import android.util.TypedValue;


public class UIUtil {

    public static int dp(Context context, int dp) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, context.getResources().getDisplayMetrics()) + 0.5F);
    }

}
