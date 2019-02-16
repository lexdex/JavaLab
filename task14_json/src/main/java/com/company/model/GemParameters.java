package com.company.model;

public class GemParameters {
    private String color;
    private Integer transparency;
    private Integer faces;

    public static final String COLOR = "color";
    public static final String TRANSPARENCY = "transparency";
    public static final String FACES = "faces";

    public GemParameters(){}

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTransparency() {
        return transparency;
    }

    public void setTransparency(Integer transparency) {
        this.transparency = transparency;
    }

    public int getFaces() {
        return faces;
    }

    public void setFaces(Integer faces) {
        this.faces = faces;
    }

    @Override
    public String toString() {
        return "[color= " + color + ", transparency=" + transparency + ", faces=" + faces + "]";
    }
}
