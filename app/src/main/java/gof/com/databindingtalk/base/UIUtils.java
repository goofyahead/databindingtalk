package gof.com.databindingtalk.base;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

public class UIUtils {
    @NonNull
    public static ValueAnimator getValueBackgroundAnimator(final View view, int colorFrom, int colorTo) {
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimation.setDuration(250); // milliseconds
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                GradientDrawable background = (GradientDrawable) view.getBackground();
                background.setColor((int) animator.getAnimatedValue());
            }
        });
        return colorAnimation;
    }

    @NonNull
    public static ValueAnimator getValueTextColorAnimator(final View view, int colorFrom, int colorTo) {
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimation.setDuration(250); // milliseconds
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                ((TextView) view).setTextColor((int) animator.getAnimatedValue());
            }
        });
        return colorAnimation;
    }
}
