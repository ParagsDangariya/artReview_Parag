package com.example.artreview_parag;

public class artList_data {

    String nameofart;
    int art_id;

    public artList_data(String nameofart, int art_id) {
        this.nameofart = nameofart;
        this.art_id = art_id;
    }

    public String getNameofart() {
        return nameofart;
    }

    public void setNameofart(String nameofart) {
        this.nameofart = nameofart;
    }

    public int getArt_id() {
        return art_id;
    }

    public void setArt_id(int art_id) {
        this.art_id = art_id;
    }
}
