package com.is.see.ui.filter.main;

/**
 * Created by Administrator on 2016/7/14.
 */
public class Radius {

    private int radius;
    private String name;

    public Radius() {
    }

    public Radius(int radius, String name) {
        this.radius = radius;
        this.name = name;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
