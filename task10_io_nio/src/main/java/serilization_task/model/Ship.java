package serilization_task.model;

import java.io.Serializable;
import java.util.List;

public class Ship implements Serializable{

    private List<Droid> droidList;

    public Ship(List<Droid> droidList) {
        this.droidList = droidList;
    }

    @Override
    public String toString() {
        return "Ship [" +
                "droidList =" + droidList +
                ']';
    }
}
