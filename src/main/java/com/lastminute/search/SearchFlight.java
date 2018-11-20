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

}
