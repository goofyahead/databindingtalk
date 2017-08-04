package gof.com.databindingtalk.base;

import android.content.Context;
import android.content.Intent;

import gof.com.databindingtalk.talkdetail.TalkDetailActivity;

public class GlobalNavigator implements AppNavigation {
    @Override
    public void navigateToTalkDetail(Context context, String talkId) {
        Intent talkDetailIntent = new Intent(context, TalkDetailActivity.class);
        talkDetailIntent.putExtra(TalkDetailActivity.EXTRA_TALK_ID, talkId);
        context.startActivity(talkDetailIntent);
    }
}
