package com.example.artreview_parag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReviewAdapt extends RecyclerView.Adapter<ReviewAdapt.ViewHolder> {

    private ArrayList<Review_data> reviewData;
    private Context context;
    private View.OnClickListener RecAdapterListener;

    public ReviewAdapt(ArrayList<Review_data> reviewData, Context context) {
        this.reviewData = reviewData;
        this.context = context;
    }

    @NonNull
    @Override
    public ReviewAdapt.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_list_item, parent, false);

        return new ReviewAdapt.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewAdapt.ViewHolder holder, int position) {
        holder.username.setText("UserName: " + reviewData.get(position).getUserName());
        holder.review.setText("Review: " + reviewData.get(position).getReview());
        holder.rating.setText("Rating: " + reviewData.get(position).getRating());

    }

    @Override
    public int getItemCount() {

        return  reviewData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView username, review, rating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.username);
            review = itemView.findViewById(R.id.review);
            rating = itemView.findViewById(R.id.rating);


            itemView.setTag(this);

            itemView.setOnClickListener(RecAdapterListener);

        }
    }
}

