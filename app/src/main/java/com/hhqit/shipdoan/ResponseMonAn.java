package com.hhqit.shipdoan;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseMonAn {
    @SerializedName("status")
    private String status;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private List<MonAn> monAnList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<MonAn> getMonAnList() {
        return monAnList;
    }

    public void setMonAnList(List<MonAn> monAnList) {
        this.monAnList = monAnList;
    }
}
