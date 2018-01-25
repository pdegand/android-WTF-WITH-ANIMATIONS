package com.octo.pde.androidanimations.structure;

import android.support.annotation.NonNull;

import com.octo.pde.androidanimations.activity.ActivityPendingTransitionActivity;
import com.octo.pde.androidanimations.activity.ActivityTransitionSourceActivity;
import com.octo.pde.androidanimations.activity.AnimationBasicsActivity;
import com.octo.pde.androidanimations.activity.AnimationLimitsActivity;
import com.octo.pde.androidanimations.activity.AnimatorBasicsActivity;
import com.octo.pde.androidanimations.activity.AnimatorChoregraphyActivity;
import com.octo.pde.androidanimations.activity.CircularRevealActivity;
import com.octo.pde.androidanimations.activity.LayoutTransitionActivity;
import com.octo.pde.androidanimations.activity.LayoutTransitionChangingActivity;
import com.octo.pde.androidanimations.activity.PhysicsTransitionActivity;
import com.octo.pde.androidanimations.activity.StateListAnimatorActivity;
import com.octo.pde.androidanimations.activity.TransitionBasicsActivity;
import com.octo.pde.androidanimations.activity.TransitionManagerActivity;
import com.octo.pde.androidanimations.activity.ViewPropertyAnimatorActivity;

/**
 * @author pde
 */
public enum Menu {

    ANIMATION_BASICS("Animation Basics", AnimationBasicsActivity.class, ApiLevel.API_LEVEL_1),
    ACTIVITY_PENDING_TRANSITION("Activity Pending Transition", ActivityPendingTransitionActivity.class, ApiLevel.API_LEVEL_1),
    ANIMATION_LIMITS("Animation Limits", AnimationLimitsActivity.class, ApiLevel.API_LEVEL_1),
    ANIMATOR_BASICS("Animator Basics", AnimatorBasicsActivity.class, ApiLevel.API_LEVEL_11),
    ANIMATOR_CHOREGRAPHY("Animator Choregraphy", AnimatorChoregraphyActivity.class, ApiLevel.API_LEVEL_11),
    VIEW_PROPERTY_ANIMATOR("ViewPropertyAnimator", ViewPropertyAnimatorActivity.class, ApiLevel.API_LEVEL_12),
    LAYOUT_TRANSITION("Layout Transition", LayoutTransitionActivity.class, ApiLevel.API_LEVEL_11),
    LAYOUT_TRANSITION_CHANGING("Layout Transition Changing", LayoutTransitionChangingActivity.class, ApiLevel.API_LEVEL_16),
    TRANSITION_BASICS("Transition Basics", TransitionBasicsActivity.class, ApiLevel.API_LEVEL_19),
    TRANSITION_MANAGER("Transition Manager", TransitionManagerActivity.class, ApiLevel.API_LEVEL_19),
    PHYSICS_TRANSITION("Physics Transition", PhysicsTransitionActivity.class, ApiLevel.API_LEVEL_19),
    CIRCULAR_REVEAL("Circular Reveal", CircularRevealActivity.class, ApiLevel.API_LEVEL_21),
    ACTIVITY_TRANSITION("Activity Transition", ActivityTransitionSourceActivity.class, ApiLevel.API_LEVEL_21),
    STATE_LIST_ANIMATOR("State List Animator", StateListAnimatorActivity.class, ApiLevel.API_LEVEL_21),
    ;

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

    @NonNull
    public Class getClassToStart() {
        return clazz;
    }

    @NonNull
    public ApiLevel getApiLevel() {
        return apiLevel;
    }
}
