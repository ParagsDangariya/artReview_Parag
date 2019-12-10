package com.example.artreview_parag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ArtistlistActivity extends AppCompatActivity {


    ArrayList<ListArtist_data> listArtistData;
    RecyclerView recyclerView;
    ListartistAdapt recAdapter;
    int art_id;
    String nameofart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artistlist);


        recyclerView = findViewById(R.id.artist_recycleview);

        Intent myintent = getIntent();

        if(getIntent()!=null){
            art_id = myintent.getIntExtra("ARTID",12);

            nameofart =myintent.getStringExtra("NAMEOFART");
        }
        listArtistData = new ArrayList<ListArtist_data>();
        recAdapter = new ListartistAdapt(listArtistData,getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(recAdapter);




        String artistlist = "http://192.168.2.23:8080/StreetArtGallery/streetart/database/listofartistsworkedonart&"+art_id;


        String mysts = null;
        try {
            mysts = new Sycdata().execute(artistlist).get();
            System.out.println("this main activity"+mysts);

            JSONObject mainobj = new JSONObject(mysts);

            JSONArray artist = mainobj.getJSONArray("ArtistList");



            for(int i = 0; i<artist.length();i++) {


                JSONObject childobj = artist.getJSONObject(i);

                String firstname = childobj.getString("FIRSTNAME");
                String lastname = childobj.getString("LASTNAME");
                String dateofbirth = childobj.getString("DATEOFBIRTH");
                String email = childobj.getString("EMAIL");
                String address = childobj.getString("ADDRESS");



                listArtistData.add(new ListArtist_data(firstname,lastname,dateofbirth,email,address));


            }

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
