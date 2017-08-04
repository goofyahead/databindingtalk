package gof.com.databindingtalk.models;

import android.databinding.ObservableInt;

public class Talk {
    public String title;
    public ObservableInt rating = new ObservableInt();
    public String imageUrl;
    public String id;

    public Talk(String title, int rating, String imageUrl, String id) {
        this.title = title;
        this.rating.set(rating);
        this.imageUrl = imageUrl;
        this.id = id;
    }
}
