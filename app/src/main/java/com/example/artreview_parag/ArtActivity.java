package com.example.artreview_parag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ArtActivity extends AppCompatActivity {


    Button review,artistlist;
    int art_id;
    String nameofart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art);

        Intent i = getIntent();

        if(getIntent()!=null){
            art_id = i.getIntExtra("ARTID",11);

            nameofart =i.getStringExtra("NAMEOFART");
        }

        //artdetails = findViewById(R.id.artdetail);
        review =findViewById(R.id.review);
        artistlist = findViewById(R.id.artt);

        /*artdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ArtActivity.this, ArtDetailsActivity.class);
                myIntent.putExtra("ARTID",art_id);

                myIntent.putExtra("NAMEOFART",nameofart);


                startActivity(myIntent);
            }

        });*/

        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ArtActivity.this, ReviewActivity.class);
                myIntent.putExtra("ARTID",art_id);
                myIntent.putExtra("NAMEOFART",nameofart);


                startActivity(myIntent);
            }

        });

        artistlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ArtActivity.this, ArtistlistActivity.class);
                myIntent.putExtra("ARTID",art_id);
                myIntent.putExtra("NAMEOFART",nameofart);


                startActivity(myIntent);
            }

        });



    }
}
