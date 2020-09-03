package com.ilyo.gadsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ilyo.gadsapp.model.Learner;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by iLyas Dev on 02/09/2020
 */
public class LeaderBoardAdapter extends RecyclerView.Adapter<LeaderBoardAdapter.MyViewHolder> {

    private List<Learner> listLearners;
    private final LayoutInflater layoutInflater;

    public LeaderBoardAdapter(Context context, List<Learner> listLearners) {
        this.listLearners = listLearners;

        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_row_list_learners, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Bind data with each view item
        Learner learner = listLearners.get(position);

        StringBuilder textDetail = new StringBuilder();
        if(learner.getScore() != 0){
            textDetail.append(learner.getScore())
                    .append(" skill IQ Score, ")
                    .append(learner.getCountry());
        }else{
            textDetail.append(learner.getHours())
                    .append(" learning hours, ")
                    .append(learner.getCountry())
                    .append(".");
        }

        holder.textViewFullName.setText(learner.getName());
        holder.textViewDetail.setText(textDetail);
        Picasso.get()
                .load(learner.getBadgeUrlImage())
                .placeholder(R.drawable.badge)
                .into(holder.imageViewBadge);
    }

    @Override
    public int getItemCount() {
        return listLearners.size();
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewFullName;
        private TextView textViewDetail;
        private ImageView imageViewBadge;

        public MyViewHolder(View itemView) {
            super(itemView);

            textViewFullName = itemView.findViewById(R.id.text_fullName);
            textViewDetail = itemView.findViewById(R.id.text_details);
            imageViewBadge = itemView.findViewById(R.id.imgBadge);
        }
    }
}
