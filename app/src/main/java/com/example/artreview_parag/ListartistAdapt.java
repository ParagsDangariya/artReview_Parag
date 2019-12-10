package com.example.artreview_parag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListartistAdapt extends RecyclerView.Adapter<ListartistAdapt.ViewHolder> {

    private ArrayList<ListArtist_data> listArtistData;
    private Context context;
    private View.OnClickListener RecAdapterListener;

    public ListartistAdapt(ArrayList<ListArtist_data> listArtistData, Context context) {
        this.listArtistData = listArtistData;
        this.context = context;
    }

    @NonNull
    @Override
    public ListartistAdapt.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.artistlist_item, parent, false);

        return new ListartistAdapt.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListartistAdapt.ViewHolder holder, int position) {

        holder.firstname.setText("FirstName: " + listArtistData.get(position).getFirstname());
        holder.lastname.setText("Lastname: " + listArtistData.get(position).getLastname());
        holder.dob.setText("DateOfBirth: " + listArtistData.get(position).getDob());
        holder.email.setText("Email: " + listArtistData.get(position).getEmail());
        holder.address.setText("Address: " + listArtistData.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return listArtistData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView firstname, lastname, dob,email,address;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            firstname = itemView.findViewById(R.id.firstname);
            lastname= itemView.findViewById(R.id.lastname);
            dob = itemView.findViewById(R.id.dob);
            email = itemView.findViewById(R.id.email);
            address = itemView.findViewById(R.id.address);


            itemView.setTag(this);

            itemView.setOnClickListener(RecAdapterListener);

        }
    }
}
