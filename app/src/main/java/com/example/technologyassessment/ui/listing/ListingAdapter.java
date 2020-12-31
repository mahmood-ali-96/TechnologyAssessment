package com.example.technologyassessment.ui.listing;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.technologyassessment.data.network.response.Results;
import com.example.technologyassessment.databinding.ListItemBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import javax.inject.Inject;

public class ListingAdapter extends RecyclerView.Adapter<ListingAdapter.articlesViewHolder> {

    private List<Results> results;
    private ListItemBinding binding;
    private Onitemclicklistener mlistener;

    @Inject
    public ListingAdapter() {
    }

    public void setList(List<Results> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public articlesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new articlesViewHolder(binding,mlistener);
    }

    @Override
    public void onBindViewHolder(@NonNull articlesViewHolder holder, int position) {
        ((articlesViewHolder) holder).populate((articlesViewHolder) holder, position);
    }

    @Override
    public int getItemCount() {
        return results == null ? 0 : results.size();
    }

    public class articlesViewHolder extends RecyclerView.ViewHolder {

        ListItemBinding projectItemBinding;

        public articlesViewHolder(@NonNull ListItemBinding itemView, final Onitemclicklistener listener) {
            super(itemView.getRoot());
            projectItemBinding = itemView;

            projectItemBinding.articalCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnArticalClick(getAdapterPosition());
                }
            });
        }

        public void populate(articlesViewHolder viewHolder, int position) {

            viewHolder.projectItemBinding.setResulte(results.get(position));
            if (results.get(position).getMedia().size() > 0)
                viewHolder.projectItemBinding.setUrl(results.get(position)
                        .getMedia().get(0).getMedia_metadata()
                        .get(0).getUrl());
            else viewHolder.projectItemBinding.setUrl("Non");
        }
    }

    public interface Onitemclicklistener{
        void OnArticalClick(int position);
    }

    public void setOnitemclicklistener(Onitemclicklistener listener){
        mlistener=listener;
    }

}
