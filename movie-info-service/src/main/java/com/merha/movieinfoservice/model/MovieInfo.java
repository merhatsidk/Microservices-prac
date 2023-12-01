package com.merha.movieinfoservice.model;

public class MovieInfo {

    private String id;
    private String desc;

    public MovieInfo() {
    }

    public MovieInfo(String id, String desc){
        this.id = id;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
