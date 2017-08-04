package gof.com.databindingtalk.talkdetail.presenter;

import gof.com.databindingtalk.base.BasePresenter;
import gof.com.databindingtalk.models.Talk;

public class TalkDetailPresenter extends BasePresenter {
    public TalkDetailPresenter() {
    }

    public void getTalk(String id) {
        view.onDataAvailable(new Talk("Databinding with android", 3, "https://68.media.tumblr.com/avatar_24fc5e28d99b_128.png", "1"));
    }
}
