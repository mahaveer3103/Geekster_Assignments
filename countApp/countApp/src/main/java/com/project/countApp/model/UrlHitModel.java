package com.project.countApp.model;

    public class UrlHitModel {

    private int hit;
    private String userName;

    public UrlHitModel() {
    }

    public UrlHitModel(String userName,int hit) {
        this.hit = hit;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    @Override
    public String toString() {
        return "UrlHitModel{" +
                "hit=" + hit +
                ", userName='" + userName + '\'' +
                '}';
    }
}
