package com.octo.pde.androidanimations.structure;

import android.os.Build;

import com.octo.pde.androidanimations.R;

/**
 * @author pde
 */
public enum ApiLevel {
    API_LEVEL_1(R.color.color_api_level_1, Build.VERSION_CODES.BASE),
    API_LEVEL_11(R.color.color_api_level_11, Build.VERSION_CODES.HONEYCOMB),
    API_LEVEL_12(R.color.color_api_level_12, Build.VERSION_CODES.HONEYCOMB_MR1),
    API_LEVEL_16(R.color.color_api_level_16, Build.VERSION_CODES.JELLY_BEAN),
    API_LEVEL_19(R.color.color_api_level_19, Build.VERSION_CODES.KITKAT),
    API_LEVEL_21(R.color.color_api_level_21, Build.VERSION_CODES.LOLLIPOP),
    ;
    private final int colorResource;
    private final int sdkInt;

    ApiLevel(int colorResource, int sdkInt) {
        this.colorResource = colorResource;
        this.sdkInt = sdkInt;
    }

    public int getColorResource() {
        return colorResource;
    }

    public int getSdkInt() {
        return sdkInt;
    }
}
