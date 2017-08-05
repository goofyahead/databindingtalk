package gof.com.databindingtalk.base;

import android.animation.AnimatorSet;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import gof.com.databindingtalk.R;

public class TalkBindingAdapters {
    @BindingAdapter("loadImageFromUrl")
    public static void loadImageFromUrl(ImageView imageView, String url) {
        Picasso.with(imageView.getContext()).load(url).into(imageView);
    }

    @BindingAdapter({"placeHolder", "loadImageFromUrl"})
    public static void loadImageFromUrlWithPlaceHolder(ImageView imageView, Drawable placeHolder, String url) {
        Picasso.with(imageView.getContext()).load(url).placeholder(placeHolder).into(imageView);
    }

    @BindingAdapter("app:blinkOnChange")
    public static void blinkOnChange(TextView textView, int oldContent, int newContent) {
        if (oldContent != 0 && oldContent != newContent) {
            int colorFrom = ContextCompat.getColor(textView.getContext(), R.color.transparent);
            int colorTo = ContextCompat.getColor(textView.getContext(), R.color.colorAccent);
            int textColorFrom = ContextCompat.getColor(textView.getContext(), R.color.black);
            int textColorTo = ContextCompat.getColor(textView.getContext(), R.color.white);
            AnimatorSet animations = new AnimatorSet();
            AnimatorSet inBlink = new AnimatorSet();
            inBlink.playTogether(UIUtils.getValueBackgroundAnimator(textView, colorFrom, colorTo),
                    UIUtils.getValueTextColorAnimator(textView, textColorFrom, textColorTo));
            AnimatorSet outBlink = new AnimatorSet();
            outBlink.playTogether(UIUtils.getValueBackgroundAnimator(textView, colorTo, colorFrom),
                    UIUtils.getValueTextColorAnimator(textView, textColorTo, textColorFrom));
            animations.playSequentially(inBlink, outBlink);
            animations.start();
        }
    }
}
