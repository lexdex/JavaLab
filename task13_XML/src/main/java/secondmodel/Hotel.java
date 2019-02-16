package secondmodel;


public class Hotel {

    private int star;
    private int room;
    private boolean television;
    private boolean wiFi;
    private boolean breakfast;

    public Hotel() {
    }

    public Hotel(int star, int room, boolean television, boolean wiFi, boolean breakfast) {
        this.star = star;
        this.room = room;
        this.television = television;
        this.wiFi = wiFi;
        this.breakfast = breakfast;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public void setTelevision(boolean television) {
        this.television = television;
    }

    public void setWiFi(boolean wiFi) {
        this.wiFi = wiFi;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "star=" + star +
                ", room=" + room +
                ", television=" + television +
                ", wiFi=" + wiFi +
                ", breakfast=" + breakfast +
                '}';
    }
}
