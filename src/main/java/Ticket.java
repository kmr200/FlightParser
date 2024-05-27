public class Ticket {

    private String origin;
    private String origin_name;
    private String destination;
    private String destination_name;
    private String departure_date;
    private String departure_time;
    private String arrival_date;
    private String arrival_time;
    private String carrier;
    private int stops;
    private int price;

    public int getFlightDuration() {

        Integer departureDay = Integer.parseInt(departure_date.split("\\.")[0]);
        Integer arrivalDay = Integer.parseInt(arrival_date.split("\\.")[0]);

        Integer departureHour = Integer.parseInt(departure_time.split(":")[0]);
        Integer arrivalHour = Integer.parseInt(arrival_time.split(":")[0]);

        Integer departureMinutes = Integer.parseInt(departure_time.split(":")[1]);
        Integer arrivalMinutes = Integer.parseInt(arrival_time.split(":")[1]);

        return
                (arrivalDay - departureDay)*24*60
                + (arrivalHour - departureHour)*60
                + (arrivalMinutes - departureMinutes);
    }

    public String getArrival_date() {
        return arrival_date;
    }

    public Ticket setArrival_date(String arrival_date) {
        this.arrival_date = arrival_date;
        return this;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public Ticket setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
        return this;
    }

    public String getCarrier() {
        return carrier;
    }

    public Ticket setCarrier(String carrier) {
        this.carrier = carrier;
        return this;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public Ticket setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
        return this;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public Ticket setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
        return this;
    }

    public String getDestination() {
        return destination;
    }

    public Ticket setDestination(String destination) {
        this.destination = destination;
        return this;
    }

    public String getDestination_name() {
        return destination_name;
    }

    public Ticket setDestination_name(String destination_name) {
        this.destination_name = destination_name;
        return this;
    }

    public String getOrigin() {
        return origin;
    }

    public Ticket setOrigin(String origin) {
        this.origin = origin;
        return this;
    }

    public String getOrigin_name() {
        return origin_name;
    }

    public Ticket setOrigin_name(String origin_name) {
        this.origin_name = origin_name;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Ticket setPrice(int price) {
        this.price = price;
        return this;
    }

    public int getStops() {
        return stops;
    }

    public Ticket setStops(int stops) {
        this.stops = stops;
        return this;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "arrival_date='" + arrival_date + '\'' +
                ", origin='" + origin + '\'' +
                ", origin_name='" + origin_name + '\'' +
                ", destination='" + destination + '\'' +
                ", destination_name='" + destination_name + '\'' +
                ", departure_date='" + departure_date + '\'' +
                ", departure_time='" + departure_time + '\'' +
                ", arrival_time='" + arrival_time + '\'' +
                ", carrier='" + carrier + '\'' +
                ", stops=" + stops +
                ", price=" + price +
                '}';
    }
}
