package com.ag.movieland.entity;

public class Movie {
    private int id;
    private String namerussian;
    private String namenative;
    private String picturepath;
    private int yearofrelease;
    private double rating;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameRussian() {
        return namerussian;
    }

    public void setNameRussian(String namerussian) {
        this.namerussian = namerussian;
    }

    public String getNameNative() {
        return namenative;
    }

    public void setNameNative(String namenative) {
        this.namenative = namenative;
    }

    public String getPicturePath() {
        return picturepath;
    }

    public void setPicturePath(String picturepath) {
        this.picturepath = picturepath;
    }

    public int getYearOfRelease() {
        return yearofrelease;
    }

    public void setYearOfRelease(int yearofrelease) {
        this.yearofrelease = yearofrelease;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", namerussian='" + namerussian + '\'' +
                ", namenative='" + namenative + '\'' +
                ", yearofrelease=" + yearofrelease +
                '}';
    }
}
