package com.nazycodes.gads2020leaderboard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nazycodes.gads2020leaderboard.R;
import com.nazycodes.gads2020leaderboard.models.LearnerLeaderModel;

import java.util.List;

public class LearnersLeadersRecyclerAdapter extends RecyclerView.Adapter<LearnersLeadersRecyclerAdapter.MyViewHolder>{
    List<LearnerLeaderModel> learnerLeaders;
    Context context;

    public LearnersLeadersRecyclerAdapter(List<LearnerLeaderModel> learnerLeaders, Context context) {
        this.learnerLeaders = learnerLeaders;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final LearnerLeaderModel learnerLeader = learnerLeaders.get(position);
        String description = learnerLeader.getHours() + " learning hours, " + learnerLeader.getCountry();

        holder.name.setText(learnerLeader.getName());
        holder.description.setText(description);
        Glide.with(context).load(learnerLeader.getBadgeUrl()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return learnerLeaders.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, description;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            image = itemView.findViewById(R.id.image);
        }
    }
}
