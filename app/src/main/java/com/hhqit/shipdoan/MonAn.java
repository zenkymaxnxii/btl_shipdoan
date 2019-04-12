package com.hhqit.shipdoan;

import com.google.gson.annotations.SerializedName;

public class MonAn {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("image")
    private String images;
    @SerializedName("price")
    private int price;
    @SerializedName("des")
    private String description;

    public MonAn(int id, String name, String images, int price, String description) {
        this.id = id;
        this.name = name;
        this.images = images;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
