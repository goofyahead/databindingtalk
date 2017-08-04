package gof.com.databindingtalk.talklist.presenter;

import java.util.ArrayList;
import java.util.List;

import gof.com.databindingtalk.base.BasePresenter;
import gof.com.databindingtalk.models.Talk;

public class TalkListPresenter extends BasePresenter {
    public TalkListPresenter() {
    }

    public void getTalks() {
        List<Talk> talks = new ArrayList<>();
        talks.add(new Talk("Databinding with android", 3, "https://68.media.tumblr.com/avatar_24fc5e28d99b_128.png", "1"));
        talks.add(new Talk("Advanced dagger", 5, "http://4.bp.blogspot.com/-BJIghZsZGDs/UL2-h-6fYlI/AAAAAAAAAxk/GmNIrcDIT48/s1600/avatar_c4e47c20dae1_128.png", "2"));
        talks.add(new Talk("RxJava for android", 3, "https://68.media.tumblr.com/avatar_e6669aa32f20_128.png", "3"));
        talks.add(new Talk("Kotlin dev with android", 2, "https://avatanplus.com/files/resources/mid/5949431cab51615cc62e281e.png", "4"));
        view.onDataAvailable(talks);
    }
}
