package com.octo.pde.androidanimations.structure;

import com.octo.pde.androidanimations.R;

/**
 * @author pde
 */
public enum ApiLevel {
    API_LEVEL_1(R.color.color_api_level_1, 1),
    API_LEVEL_11(R.color.color_api_level_11, 11),
    API_LEVEL_12(R.color.color_api_level_12, 12),
    API_LEVEL_16(R.color.color_api_level_16, 16),
    API_LEVEL_19(R.color.color_api_level_19, 19);
    private final int colorResource;
    private final int apiLevel;

    ApiLevel(int colorRessource, int apiLevel) {
        this.colorResource = colorRessource;
        this.apiLevel = apiLevel;
    }

    public int getColorResource() {
        return colorResource;
    }

    public int getSdkInt() {
        return apiLevel;
    }
}
