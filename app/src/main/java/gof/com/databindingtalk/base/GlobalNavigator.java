package gof.com.databindingtalk.base;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;

import gof.com.databindingtalk.talkdetail.TalkDetailActivity;

public class GlobalNavigator implements AppNavigation{

    @Override
    public void navigateToTalkDetail(Activity activity, String talkId) {
        Intent talkDetailIntent = new Intent(activity, TalkDetailActivity.class);
        talkDetailIntent.putExtra(TalkDetailActivity.EXTRA_TALK_ID, talkId);
        activity.startActivity(talkDetailIntent);
    }
}
