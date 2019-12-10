package com.example.artreview_parag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleAdapt extends RecyclerView.Adapter<RecycleAdapt.ViewHolder> {

    private ArrayList<artList_data> artListData;
    private Context context;
    private View.OnClickListener RecAdapterListener;

    public RecycleAdapt(ArrayList<artList_data> artListData, Context context) {
        this.artListData = artListData;
        this.context = context;
    }



    @NonNull
    @Override
    public RecycleAdapt.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.art_list_item, parent, false);

        return new RecycleAdapt.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapt.ViewHolder holder, int position) {

        holder.art_name.setText("Art Name: "+artListData.get(position).getNameofart());
    }


    public void setOnClickListener(View.OnClickListener clickListener) {

        RecAdapterListener = clickListener;

    }

    @Override
    public int getItemCount() {
        return artListData.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView art_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            art_name = itemView.findViewById(R.id.art_name);


            itemView.setTag(this);

            itemView.setOnClickListener(RecAdapterListener);

        }
    }
}
