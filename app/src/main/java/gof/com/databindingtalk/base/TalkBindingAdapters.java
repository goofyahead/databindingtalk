package gof.com.databindingtalk.base;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class TalkBindingAdapters {

    @BindingAdapter("loadImageFromUrl")
    public static void loadImageFromUrl(ImageView imageView, String url) {
        if (imageView != null) {
            Picasso.with(imageView.getContext()).load(url).into(imageView);
        }
    }

    @BindingAdapter({"placeHolder", "loadImageFromUrl"})
    public static void loadImageFromUrlWithPlaceHolder(ImageView imageView, Drawable placeHolder, String url) {
        if (imageView != null) {
            Picasso.with(imageView.getContext()).load(url).placeholder(placeHolder).into(imageView);
        }
    }
}
