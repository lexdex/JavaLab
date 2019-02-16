package com.company.model;

public class Gem implements Comparable<Gem> {
    @Override
    public int compareTo(Gem g) {
        return this.value.compareTo(g.getValue());
    }

    public enum Preciousness {
        SEMI_PRECIOUS,
        PRECIOUS
    }

    private String name;
    private String origin;
    private Integer value;
    private Preciousness preciousness;
    private GemParameters parameters;

    public static final String GEM = "gem";
    public static final String NAME = "name";
    public static final String ORIGIN = "origin";
    public static final String VALUE = "value";
    public static final String PARAMETERS = "parameters";
    public static final String PRECIOUSNESS = "preciousness";

    public Gem() {
    }

    public Gem(String name, String origin, Integer value, Preciousness preciousness, GemParameters parameters) {
        this.name = name;
        this.origin = origin;
        this.value = value;
        this.preciousness = preciousness;
        this.parameters = parameters;
    }

    public Preciousness getPreciousness() {
        return preciousness;
    }

    public void setPreciousness(Preciousness preciousness) {
        this.preciousness = preciousness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public GemParameters getParameters() {
        return parameters;
    }

    public void setParameters(GemParameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "~~" + name.toUpperCase() + "~~" + "\n" + "origin= " + origin +
                ", value= " + value +
                ", preciousness= " + preciousness +
                ", parameters= " + parameters +
                "; ";
    }
}
