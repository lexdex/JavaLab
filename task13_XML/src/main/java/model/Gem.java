package model;



public class Gem {
    enum Preciousness {
        SemiPrecious,
        Precious
    }

    private String name;
    private String origin;
    private Integer value;
    private Preciousness type;
    private model.GemParameters parameters;

    public Gem(String name, String origin, Integer value, Preciousness type, GemParameters parameters) {
        this.name = name;
        this.origin = origin;
        this.value = value;
        this.type = type;
        this.parameters = parameters;
    }

    public Preciousness getType() {
        return type;
    }

    public void setType(Preciousness type) {
        this.type = type;
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
        return "~~" + name.toUpperCase() + "~~" + "\n" +  "origin= " + origin  +
                ", value= " + value +
                ", type= " + type +
                ", parameters= " + parameters +
                "; ";
    }
}
