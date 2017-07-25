package com.example.squirrel_trip.squirreltrip.model;

public class Picture {
    private String pictures;
    private String textToCheckBox;
    private String getTextToRatingBar;
    private String like_rating;

    public Picture(String picture, String textToCheckBox, String getTextToRatingBar, String like_rating) {
        this.pictures = picture;
        this.textToCheckBox = textToCheckBox;
        this.getTextToRatingBar = getTextToRatingBar;
        this.like_rating = like_rating;
    }
    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public String getTextToCheckBox() {
        return textToCheckBox;
    }

    public void setTextToCheckBox(String textToCheckBox) {
        this.textToCheckBox = textToCheckBox;
    }

    public String getGetTextToRatingBar() {
        return getTextToRatingBar;
    }

    public void setGetTextToRatingBar(String getTextToRatingBar) {
        this.getTextToRatingBar = getTextToRatingBar;
    }


    public String getLike_rating() {
        return like_rating;
    }

    public void setLike_rating(String like_rating) {
        this.like_rating = like_rating;
    }
}



