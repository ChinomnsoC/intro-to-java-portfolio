public class Plane {
    String airline;
    String city;
    int time;
    public Plane(String airline, String city, int time){
        this.airline = airline;
        this.city = city;
        this.time = time;
    }

    public String toString(){
        int hour = time / 100;
        int min = time % 100;
        return String.format("Airline: %s\nCity: %s\nTime: %d:%d\n", airline, city, hour, min);
    }
}