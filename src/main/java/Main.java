import com.lastminute.flight.FlightList;
import com.lastminute.price.PriceFlight;
import com.lastminute.search.SearchFlight;
import com.lastminute.flight.Flight;

import java.math.BigDecimal;
import java.util.*;

public class Main {

    private static final String FLIGHT_PRICES_FILENAME = "flight-prices.csv";
    private static final String FLIGHT_ROUTES_FILENAME = "flight-routes.csv";
    private static final Integer CODE_INDEX_PRICES = 0;
    private static final Integer CODE_INDEX_ROUTES = 2;
    private static final String LOG_DECORATOR = "---------------------";


    public static void main(String[] args) throws Exception {

        // This Main class and main method is just for demonstration purposes

        List<Flight> myFlights = new FlightList().fromCSVtoFlightList(FLIGHT_PRICES_FILENAME,
                FLIGHT_ROUTES_FILENAME, CODE_INDEX_PRICES, CODE_INDEX_ROUTES);

        // Examples from the spec
        tinyDemoWrapper(myFlights, "AMS", "FRA", BigDecimal.valueOf(31), BigDecimal.valueOf(1));
        tinyDemoWrapper(myFlights, "LHR", "IST", BigDecimal.valueOf(15), BigDecimal.valueOf(3));
        tinyDemoWrapper(myFlights, "BCN", "MAD", BigDecimal.valueOf(2), BigDecimal.valueOf(2));
        tinyDemoWrapper(myFlights, "CDG", "FRA", BigDecimal.valueOf(1), BigDecimal.valueOf(1));

        // Other examples (uncomment if you need to verify further behaviour)
        /*
        tinyDemoWrapper(myFlights, "AMS", "FRA", BigDecimal.valueOf(-1), BigDecimal.valueOf(1));
        tinyDemoWrapper(myFlights, "AMS", "FRA", BigDecimal.valueOf(1), BigDecimal.valueOf(-1));
        tinyDemoWrapper(myFlights, "AMS", "FRA", BigDecimal.valueOf(0), BigDecimal.valueOf(1));
        tinyDemoWrapper(myFlights, "AMS", "FRA", BigDecimal.valueOf(0), BigDecimal.valueOf(0));

        List<Flight> noFlights = new ArrayList<>();
        tinyDemoWrapper(noFlights, "AMS", "FRA", BigDecimal.valueOf(1), BigDecimal.valueOf(1));
        */
    }

    public static void tinyDemoWrapper(List<Flight> myFlights, String origin, String destiny,
                                       BigDecimal daysToDeparture, BigDecimal numTickets){

        System.out.println(LOG_DECORATOR);
        List<Flight> result =  SearchFlight.directSearch(myFlights, origin, destiny);
        result.forEach(e -> {
            BigDecimal cost = PriceFlight.calculateTotal(e,daysToDeparture, numTickets);
            System.out.println(e.getCode() +" "+ e.getOrigin() +" "+ e.getDestiny() +" "+ cost +" €");
        });
    }
}
