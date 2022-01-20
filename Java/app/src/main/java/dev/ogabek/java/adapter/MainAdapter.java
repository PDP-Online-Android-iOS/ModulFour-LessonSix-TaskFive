package dev.ogabek.java.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.ogabek.java.R;
import dev.ogabek.java.model.Member;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_SIMPLE_VIEW = 0;
    private static final int TYPE_ADS_VIEW = 1;

    Context context;
    List<Member> members;

    public MainAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
    }

    @Override
    public int getItemViewType(int position) {
        if (isAdsLayout(position)) {
            return TYPE_ADS_VIEW;
        } else {
            return TYPE_SIMPLE_VIEW;
        }
    }

    private boolean isAdsLayout(int position) {
        return position != 0 && position % 13 == 0;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == TYPE_ADS_VIEW) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ads_layout, parent ,false);
            return new ItemSimpleViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_layout, parent ,false);
            return new ItemAdsViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    private static class ItemAdsViewHolder extends RecyclerView.ViewHolder {
        public ItemAdsViewHolder(View view) {
            super(view);
        }
    }

    private static class ItemSimpleViewHolder extends RecyclerView.ViewHolder {
        public ItemSimpleViewHolder(View view) {
            super(view);
        }
    }
}
