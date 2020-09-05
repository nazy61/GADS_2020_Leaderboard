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
import com.nazycodes.gads2020leaderboard.models.SkillIQLeaderModel;

import java.util.List;

public class SkillIQLeadersRecyclerAdapter extends RecyclerView.Adapter<SkillIQLeadersRecyclerAdapter.MyViewHolder>{
    List<SkillIQLeaderModel> skillIQLeaderModels;
    Context context;

    public SkillIQLeadersRecyclerAdapter(List<SkillIQLeaderModel> skillIQLeaderModels, Context context) {
        this.skillIQLeaderModels = skillIQLeaderModels;
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
        final SkillIQLeaderModel learnerLeader = skillIQLeaderModels.get(position);
        String description = learnerLeader.getScore() + " Skill IQ Score, " + learnerLeader.getCountry();

        holder.name.setText(learnerLeader.getName());
        holder.description.setText(description);
        Glide.with(context).load(learnerLeader.getBadgeUrl()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return skillIQLeaderModels.size();
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
