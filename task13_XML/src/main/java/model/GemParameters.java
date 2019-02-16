package model;

public class GemParameters {
    private String color;
    private int transparency;
    private int faces;

    public GemParameters(String color, int transparency, int faces) {
        this.color = color;
        this.transparency = transparency;
        this.faces = faces;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTransparency() {
        return transparency;
    }

    public void setTransparency(int transparency) {
        this.transparency = transparency;
    }

    public int getFaces() {
        return faces;
    }

    public void setFaces(int faces) {
        this.faces = faces;
    }

    @Override
    public String toString() {
        return "[color='" + color + ", transparency=" + transparency + ", faces=" + faces + "]";
    }
}
