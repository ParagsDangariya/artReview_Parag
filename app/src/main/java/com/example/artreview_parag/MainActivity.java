package com.example.artreview_parag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {


    ArrayList<artList_data> artListData;
    RecyclerView recyclerView;
    RecycleAdapt recAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.artList_recycleview);

        artListData = new ArrayList<artList_data>();
        recAdapter = new RecycleAdapt(artListData,getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(recAdapter);


        String artlist  = "http://192.168.2.23:8080/StreetArtGallery/streetart/database/ArtList";


        //String mysts = null;
        try {
            String mysts = new Sycdata().execute(artlist).get();
            System.out.println("this main activity"+mysts);

            JSONObject mainobj = new JSONObject(mysts);

            JSONArray art_list = mainobj.getJSONArray("ArtList");



            for(int i = 0; i<art_list.length();i++) {


                JSONObject childobj = art_list.getJSONObject(i);

                int artid = childobj.getInt("ARTID");
                String nameofart = childobj.getString("NAMEOFART");

                artListData.add(new artList_data(nameofart,artid));


            }

            recAdapter.notifyDataSetChanged();
            recAdapter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
                    int position = viewHolder.getAdapterPosition();
                    Intent i = new Intent(MainActivity.this,ArtActivity.class);
                    i.putExtra("ARTID",artListData.get(position).getArt_id());
                    i.putExtra("NAMEOFART",artListData.get(position).getNameofart());

                    startActivity(i);
                }
            });
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //System.out.println("this main activity"+mysts);

    }
}
