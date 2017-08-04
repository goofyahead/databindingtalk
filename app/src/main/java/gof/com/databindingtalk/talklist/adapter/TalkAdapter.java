package gof.com.databindingtalk.talklist.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import gof.com.databindingtalk.R;
import gof.com.databindingtalk.databinding.TalkItemBinding;
import gof.com.databindingtalk.models.Talk;

public class TalkAdapter extends RecyclerView.Adapter<TalkAdapter.TalkViewHolder> {
    private final Context context;
    private List<Talk> talks;
    private OnItemClickListener listener;

    public TalkAdapter(List<Talk> talks, Context context, OnItemClickListener listener) {
        this.talks = talks;
        this.context = context;
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(View itemView, Talk talk);
    }

    @Override
    public TalkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TalkViewHolder((TalkItemBinding) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.talk_item, parent, false));
    }

    @Override
    public void onBindViewHolder(TalkViewHolder holder, int position) {
        Talk currentTalk = talks.get(position);
        holder.getBinding().setModel(currentTalk);
        Picasso.with(context).load(currentTalk.imageUrl).into(holder.getBinding().talkItemImage);
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
            itemView.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(itemView.getRoot(), talks.get(position));
                        }
                    }
                }
            });
        }

        TalkItemBinding getBinding() {
            return binding;
        }
    }
}
