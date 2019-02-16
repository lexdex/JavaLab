package secondmodel;



public class Tour {

    private int tourId;
    private String type;
    private String country;
    private int days;
    private int nights;
    private String transport;
    private Hotel hotel;
    private int cost;

    public Tour() {
    }

    public Tour(int tourId, String type, String country, int days, int nights, String transport, Hotel hotel, int cost) {
        this.tourId = tourId;
        this.type = type;
        this.country = country;
        this.days = days;
        this.nights = nights;
        this.transport = transport;
        this.hotel = hotel;
        this.cost = cost;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "tourId=" + tourId +
                ", type='" + type + '\'' +
                ", country='" + country + '\'' +
                ", days=" + days +
                ", nights=" + nights +
                ", transport='" + transport + '\'' +
                ", hotel=" + hotel +
                ", cost=" + cost +
                '}';
    }
}
