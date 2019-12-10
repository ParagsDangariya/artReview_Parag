package com.example.artreview_parag;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpHandler {
    public HttpHandler(){

    }
    public String makeserviceCall(String rurl){


       String response = null;

    try {

        URL url1 = new URL(rurl);

        HttpURLConnection con = (HttpURLConnection) url1.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type","application/json");

        //read response
        InputStream in =new BufferedInputStream(con.getInputStream());

        response = convertStream(in);

    }catch (MalformedURLException e){
        Log.e("Httphandler class","Mail"+e.getMessage());
    }catch (IOException e){
        Log.e("Httphandler class","Mail"+e.getMessage());
    }
    System.out.println("this is response"+ response);
        return response ;
    }

    public String convertStream(InputStream is){


        BufferedReader read = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        try{


        while ((line= read.readLine())!= null)
        {
            sb.append(line).append("\n");
        }

        }catch (IOException e){
            Log.e("Convert Stream","Mail"+e.getMessage());
        }finally {
            try{
                is.close();
            }catch (IOException e){
                Log.e("Convrt Finally","Mail"+e.getMessage());
            }
        }
        return sb.toString();
    }
}
