package com.example.huiying.test2.GetternSetter;

/**
 * Created by huiying on 4/11/2017.
 */

public class coupons {
    private int id;
    private Integer photoID;
    private String storeName;
    private String expiryDate;
    private String note;

    public coupons(int id, Integer photoID, String storeName, String expiryDate, String note) {
        this.id = id;
        this.photoID = photoID;
        this.storeName = storeName;
        this.expiryDate = expiryDate;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getPhotoID() {
        return photoID;
    }

    public void setPhotoID(Integer photoID) {
        this.photoID = photoID;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}


