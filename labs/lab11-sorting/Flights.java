import java.io.*;
import java.util.*;

public class Flights {
    ArrayList<Plane> FlightList = new ArrayList<>();

    public Flights(String fileName) {
        CSVReader reader = new CSVReader(fileName, false);
        while (reader.hasNext()) {
            List<String> p = reader.getNext();
            FlightList.add(new Plane(p.get(0), p.get(1), Integer.parseInt(p.get(2))));
        }
    }

    public ArrayList<Plane> filter(String airline) {
        ArrayList<Plane> lst = new ArrayList<>();
        for (Plane p : FlightList) {
            if (p.airline.equalsIgnoreCase(airline)) {
                lst.add(p);
            }
        }
        return lst;
    }

    public ArrayList<Plane> sorter(ArrayList<Plane> p) {
        Collections.sort(p, new Comparator<Plane>() {
            @Override
            public int compare(Plane a, Plane b) {
                // First compare by airline
                int airlineCompare = a.airline.compareTo(b.airline);
                if (airlineCompare != 0) {
                    return airlineCompare;
                }

                // If airlines are same, compare by city
                int cityCompare = a.city.compareTo(b.city);
                if (cityCompare != 0) {
                    return cityCompare;
                }

                // If cities are same, compare by time
                return Integer.compare(a.time, b.time);
            }
        });
        return p;
    }

    public Plane findFlight(String airline, String city, int earliest, int latest) {
        ArrayList<Plane> shortened = filter(airline);
        shortened = sorter(shortened);

        for (Plane p : shortened) {
            if (p.city.equalsIgnoreCase(city)) {
                if (p.time > earliest && p.time < latest) {
                    return p;
                }
            }
        }
        return new Plane("nonexistent", "nowhere", -1);
    }

    public static void main(String[] args) {
        Flights flights = new Flights("Airport.csv");

        ArrayList<Plane> unitedFlights = flights.filter("United");
        System.out.println("United Flights: " + unitedFlights.size());

        Plane found = flights.findFlight("United", "Phoenix", 400, 600);
        System.out.println("Found flight: " + found.airline + " to " + found.city + " at " + found.time);
    }
}