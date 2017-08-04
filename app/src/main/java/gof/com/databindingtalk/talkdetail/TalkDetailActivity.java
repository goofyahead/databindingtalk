package gof.com.databindingtalk.talkdetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Locale;

import gof.com.databindingtalk.R;
import gof.com.databindingtalk.base.AppNavigation;
import gof.com.databindingtalk.base.BaseView;
import gof.com.databindingtalk.base.GlobalNavigator;
import gof.com.databindingtalk.models.Talk;
import gof.com.databindingtalk.talkdetail.presenter.TalkDetailPresenter;
import gof.com.databindingtalk.talklist.presenter.TalkListPresenter;

public class TalkDetailActivity extends AppCompatActivity implements BaseView<Talk> {
    public static final String EXTRA_TALK_ID = "EXTRA_TALK_ID";
    private TalkDetailPresenter presenter;
    private ImageView talkImage;
    private TextView talkTitle;
    private TextView talkRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talk_detail);
        presenter = new TalkDetailPresenter();
        initViews();
    }

    private void initViews() {
        talkImage = (ImageView) findViewById(R.id.talk_detail_image);
        talkTitle = (TextView) findViewById(R.id.talk_detail_title);
        talkRating = (TextView) findViewById(R.id.talk_detail_rating);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String talkId = getIntent().getStringExtra(EXTRA_TALK_ID);
        presenter.setView(this);
        presenter.getTalk(talkId);
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.disposeView();
    }

    @Override
    public void onDataAvailable(Talk talk) {
        Picasso.with(this).load(talk.imageUrl).into(talkImage);
        talkTitle.setText(talk.title);
        talkRating.setText(String.format(Locale.getDefault(), "%d", talk.rating.get()));
    }

    @Override
    public void onDataError(Exception error) {
    }
}
