package gof.com.databindingtalk.talklist.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import gof.com.databindingtalk.R;
import gof.com.databindingtalk.base.AppNavigation;
import gof.com.databindingtalk.databinding.TalkItemBinding;
import gof.com.databindingtalk.models.Talk;

public class TalkAdapter extends RecyclerView.Adapter<TalkAdapter.TalkViewHolder> {
    private final AppNavigation appNavigation;
    private List<Talk> talks;

    public TalkAdapter(List<Talk> talks, AppNavigation appNavigation) {
        this.talks = talks;
        this.appNavigation = appNavigation;
    }

    @Override
    public TalkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TalkViewHolder((TalkItemBinding) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.talk_item, parent, false));
    }

    @Override
    public void onBindViewHolder(TalkViewHolder holder, int position) {
        Talk currentTalk = talks.get(position);
        holder.getBinding().setModel(currentTalk);
        holder.getBinding().setNavigation(appNavigation);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return talks.size();
    }

    class TalkViewHolder extends RecyclerView.ViewHolder {
        private TalkItemBinding binding;

        public TalkViewHolder(final TalkItemBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

        TalkItemBinding getBinding() {
            return binding;
        }
    }
}
