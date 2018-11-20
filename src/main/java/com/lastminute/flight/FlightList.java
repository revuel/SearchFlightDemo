package com.lastminute.flight;

import com.lastminute.CsvFiles;

import java.math.BigDecimal;
import java.util.*;

public class FlightList {

    private static final Integer PRICES_CODE_INDEX = 0;
    private static final Integer PRICES_PRICE_INDEX = 1;
    private static final Integer ROUTES_CODE_INDEX = 2;
    private static final Integer ROUTES_ORIGIN_INDEX = 0;
    private static final Integer ROUTES_DESTINIY_INDEX = 1;

    private List<Flight> flightlist = new ArrayList<>();

    private List<Flight> getFlightlist() {
        return flightlist;
    }

    public List<Flight> fromCSVtoFlightList(String pricesFile, String routesFile,
                                           Integer flightCodeIndexPrices,
                                           Integer flightCodeIndexRoutes) throws Exception {

        // Read CSV files (using provided csv parser implementation)
        List<List<String>> flightPrices = CsvFiles.readAllRecords(pricesFile);
        List<List<String>> flightRoutes = CsvFiles.readAllRecords(routesFile);

        // Sort both lists of lists
        flightPrices.sort(Comparator.comparing(e -> e.get(flightCodeIndexPrices)));
        flightRoutes.sort(Comparator.comparing(e -> e.get(flightCodeIndexRoutes)));

        // List Iterators
        Iterator it1 = flightPrices.iterator();
        Iterator it2 = flightRoutes.iterator();

        while (it1.hasNext() && it2.hasNext()) {
            List<String> valueFlightPrices = (List<String>) it1.next();
            List<String> valueFlightRoutes = (List<String>) it2.next();

            if(valueFlightPrices.get(PRICES_CODE_INDEX).equals(valueFlightRoutes.get(ROUTES_CODE_INDEX))) {

                this.flightlist.add(new Flight(
                        valueFlightRoutes.get(ROUTES_CODE_INDEX),
                        valueFlightRoutes.get(ROUTES_ORIGIN_INDEX),
                        valueFlightRoutes.get(ROUTES_DESTINIY_INDEX),
                        BigDecimal.valueOf(Long.parseLong(valueFlightPrices.get(PRICES_PRICE_INDEX)))));
                // I really don't like it. But since we're reading from CSV files... without headers...
            }
        }

        return getFlightlist();
    }

}
