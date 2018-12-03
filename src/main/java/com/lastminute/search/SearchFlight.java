package com.lastminute.search;

import com.lastminute.flight.Flight;

import java.util.*;
import java.util.stream.Collectors;

public class SearchFlight {

    private static final String NO_FLIGHTS = "no flights available";

    public static List<Flight> directSearch(List<Flight> flights, String origin, String destiny) {

        List<Flight> ocurrences;

        ocurrences = flights.stream()
                .filter(f -> f.getOrigin().equals(origin))
                .filter(e -> e.getDestiny().equals(destiny))
                .collect(Collectors.toList());

        if (ocurrences.isEmpty()) System.out.println(NO_FLIGHTS);

        return ocurrences;
    }

    public static List<List<Flight>> oneStopOverSearch(List<Flight> flights, String origin, String destiny) {

        // We need two lists, one for the departures and the other for the destinations

        List<Flight> originFlights;
        List<Flight> destinyFlights;

        // Filter departures (origin arg)
        originFlights = flights.stream()
                .filter(f -> f.getOrigin().equals(origin))
                .collect(Collectors.toList());

        // Filter destinations (destiny arg)
        destinyFlights = flights.stream()
                .filter(f -> f.getDestiny().equals(destiny))
                .collect(Collectors.toList());

        /*System.out.println("ORIGINS");
        originFlights.forEach(e -> System.out.println(e.getOrigin() +" "+e.getDestiny()));
        System.out.println("DESTINIES");
        destinyFlights.forEach(e -> System.out.println(e.getOrigin() +" "+e.getDestiny()));*/

        // A nested list for matching the stopover
        List<List<Flight>> flightsAvailable = new ArrayList<>();

        // External iteration over the two lists
        for (Flight originFlight: originFlights) {

            for (Flight destinyFlight: destinyFlights) {

                if (originFlight.getDestiny().equals(destinyFlight.getOrigin()) &&
                        destinyFlight.getDestiny().equals(destiny)) {

                    // Add the matches to the nested list
                    List<Flight> match = new ArrayList<>();
                    match.add(originFlight);
                    match.add(destinyFlight);

                    flightsAvailable.add(match);

                }

            }

        }

        System.out.println("MATCHES");
        flightsAvailable.forEach(e -> { e.stream()
                        .forEach(f -> System.out.print(
                                    f.getOrigin() +" "+
                                    f.getDestiny() + " "+
                                    f.getCode() + " "));
                        System.out.println(" ");

        });

        return flightsAvailable;
    }

}
