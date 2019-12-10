package com.example.artreview_parag;

public class Review_data {

    String UserName,Review;
    int Rating;

    public Review_data(String userName, String review, int rating) {
        UserName = userName;
        Review = review;
        Rating = rating;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getReview() {
        return Review;
    }

    public void setReview(String review) {
        Review = review;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }
}
