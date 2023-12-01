package com.merha.moviecatalogservice.model;

public class MovieInfo {

    private String name;
    private String desc;

    public MovieInfo() {
    }

    public MovieInfo(String name, String desc){
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setId(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
