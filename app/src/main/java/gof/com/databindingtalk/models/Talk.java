package gof.com.databindingtalk.models;

import android.app.Activity;

public class Talk {
    public String title;
    public int rating;
    public String imageUrl;
    public String id;

    public Talk(String title, int rating, String imageUrl, String id) {
        this.title = title;
        this.rating = rating;
        this.imageUrl = imageUrl;
        this.id = id;
    }
}
