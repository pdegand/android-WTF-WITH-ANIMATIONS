package com.octo.pde.androidanimations.structure;

import com.octo.pde.androidanimations.activity.ActivityTransitionActivity;
import com.octo.pde.androidanimations.activity.AnimationBasicsActivity;
import com.octo.pde.androidanimations.activity.AnimationLimitsActivity;
import com.octo.pde.androidanimations.activity.AnimatorBasicsActivity;
import com.octo.pde.androidanimations.activity.AnimatorChoregraphyActivity;
import com.octo.pde.androidanimations.activity.LayoutTransitionActivity;
import com.octo.pde.androidanimations.activity.LayoutTransitionChangingActivity;
import com.octo.pde.androidanimations.activity.NineOldAndroidsActivity;
import com.octo.pde.androidanimations.activity.TransitionBasicsActivity;
import com.octo.pde.androidanimations.activity.ViewPropertyAnimatorActivity;

/**
 * @author pde
 */
public enum Menu {

    ANIMATION_BASICS("Animation Basics", AnimationBasicsActivity.class, ApiLevel.API_LEVEL_1),
    ACTIVITY_TRANSITION("Activity Transition", ActivityTransitionActivity.class, ApiLevel.API_LEVEL_1),
    ANIMATION_LIMITS("Animation Limits", AnimationLimitsActivity.class, ApiLevel.API_LEVEL_1),
    ANIMATOR_BASICS("Animator Basics", AnimatorBasicsActivity.class, ApiLevel.API_LEVEL_11),
    ANIMATOR_CHOREGRAPHY("Animator Choregraphy", AnimatorChoregraphyActivity.class, ApiLevel.API_LEVEL_11),
    VIEW_PROPERTY_ANIMATOR("ViewPropertyAnimator", ViewPropertyAnimatorActivity.class, ApiLevel.API_LEVEL_12),
    NINE_OLD_ANDROIDS("NineOldAndroids", NineOldAndroidsActivity.class, ApiLevel.API_LEVEL_1),
    LAYOUT_TRANSITION("Layout Transition", LayoutTransitionActivity.class, ApiLevel.API_LEVEL_11),
    LAYOUT_TRANSITION_CHANGING("Layout Transition Changing", LayoutTransitionChangingActivity.class, ApiLevel.API_LEVEL_16),
    TRANSITION_BASICS("Transition Basics", TransitionBasicsActivity.class, ApiLevel.API_LEVEL_19);

    private final String title;
    private final Class clazz;
    private final ApiLevel apiLevel;

    Menu(String title, Class clazz, ApiLevel apiLevel) {
        this.title = title;
        this.clazz = clazz;
        this.apiLevel = apiLevel;
    }

    @Override
    public String toString() {
        return this.title;
    }

    public Class getClassToStart() {
        return clazz;
    }

    public ApiLevel getApiLevel() {
        return apiLevel;
    }
}
