package gof.com.databindingtalk.talklist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;

import gof.com.databindingtalk.R;
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
        View contactView = LayoutInflater.from(parent.getContext()).inflate(R.layout.talk_item, parent, false);
        return new TalkViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(TalkViewHolder holder, int position) {
        // Get the data model based on position
        Talk currentTalk = talks.get(position);
        // Set item views based on your views and data model
        holder.title.setText(currentTalk.title);
        holder.rating.setText(String.format(Locale.getDefault(), "%d", currentTalk.rating));
        Picasso.with(context).load(currentTalk.imageUrl).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return talks.size();
    }

    class TalkViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView title;
        private TextView rating;

        public TalkViewHolder(final View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.talk_item_image);
            title = (TextView) itemView.findViewById(R.id.talk_title);
            rating = (TextView) itemView.findViewById(R.id.talk_rating);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(itemView, talks.get(position));
                        }
                    }
                }
            });
        }
    }
}
