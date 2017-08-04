package gof.com.databindingtalk.talklist;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.squareup.picasso.Picasso;

import java.util.List;

import gof.com.databindingtalk.R;
import gof.com.databindingtalk.base.AppNavigation;
import gof.com.databindingtalk.base.BaseView;
import gof.com.databindingtalk.base.GlobalNavigator;
import gof.com.databindingtalk.databinding.ActivityTalkListBinding;
import gof.com.databindingtalk.models.Talk;
import gof.com.databindingtalk.talklist.adapter.TalkAdapter;
import gof.com.databindingtalk.talklist.presenter.TalkListPresenter;

public class TalkListActivity extends AppCompatActivity implements BaseView<List<Talk>>, TalkAdapter.OnItemClickListener {
    private static final String TAG = TalkListActivity.class.getSimpleName();
    private TalkListPresenter presenter;
    private AppNavigation navigator;
    private ActivityTalkListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_talk_list);
        presenter = new TalkListPresenter();
        navigator = new GlobalNavigator();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.getTalks();
        Picasso.with(this).load("https://pbs.twimg.com/profile_images/2948345673/ce64b79c6d157dea1c3f0949f7f98c72.jpeg").into(binding.headerImage);
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.disposeView();
    }

    @Override
    public void onDataAvailable(List<Talk> data) {
        binding.listOfTalks.setLayoutManager(new LinearLayoutManager(this));
        binding.listOfTalks.setAdapter(new TalkAdapter(data, this, this));
    }

    @Override
    public void onDataError(Exception error) {
        Log.e(TAG, "error found " + error.getLocalizedMessage());
    }

    @Override
    public void onItemClick(View itemView, Talk talk) {
        navigator.navigateToTalkDetail(this, talk.id);
    }
}
