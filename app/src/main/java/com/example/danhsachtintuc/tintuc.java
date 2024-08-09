package com.example.danhsachtintuc;

public class tintuc {
    private String date;
    private String title;
    private String noidung;

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getNoidung() {
        return noidung;
    }

    public String getDate() {
        return date;
    }

    // Constructor
    public tintuc( String title, String noidung,String date) {
        this.date = date;
        this.title = title;
        this.noidung = noidung;
    }

}
