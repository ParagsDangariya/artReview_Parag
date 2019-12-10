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

public class ReviewActivity extends AppCompatActivity {


    ArrayList<Review_data> reviewData;
    RecyclerView recyclerView;
    ReviewAdapt recAdapter;
    int art_id;
    String nameofart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);


        recyclerView = findViewById(R.id.review_recycleview);

        Intent myintent = getIntent();

        if(getIntent()!=null){
            art_id = myintent.getIntExtra("ARTID",12);

            nameofart =myintent.getStringExtra("NAMEOFART");
        }
        reviewData = new ArrayList<Review_data>();
        recAdapter = new ReviewAdapt(reviewData,getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(recAdapter);

        String review = "http://192.168.2.23:8080/StreetArtGallery/streetart/database/ArtReview&"+art_id;


        String mysts = null;
        try {
            mysts = new Sycdata().execute(review).get();
            System.out.println("this main activity"+mysts);

            JSONObject mainobj = new JSONObject(mysts);

            JSONArray reviews = mainobj.getJSONArray("Reviews");



            for(int i = 0; i<review.length();i++) {


                JSONObject childobj = reviews.getJSONObject(i);

                String username = childobj.getString("UserName");
                String reviewus = childobj.getString("Review");
                int rating = childobj.getInt("Rating");


                reviewData.add(new Review_data(username,reviewus,rating));


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
