package com.example.huiying.test2.GetternSetter;

/**
 * Created by huiying on 4/13/2017.
 */

public class records {
    private Integer cate_pic;
    private String note;
    private String date;
    private String amount;

    public records(Integer cate_pic, String note, String date, String amount) {
        this.cate_pic = cate_pic;
        this.note = note;
        this.date = date;
        this.amount = amount;
    }

    public Integer getCate_pic() {
        return cate_pic;
    }

    public void setCate_pic(Integer cate_pic) {
        this.cate_pic = cate_pic;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
