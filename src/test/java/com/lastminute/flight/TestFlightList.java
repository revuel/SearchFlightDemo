package com.lastminute.flight;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestFlightList {

    String FLIGHT_PRICES_FILENAME;
    String FLIGHT_ROUTES_FILENAME;
    Integer CODE_INDEX_PRICES;
    Integer CODE_INDEX_ROUTES;
    List<Flight> expectedFlightList;

    @Before
    public void setUp() throws Exception {
        FLIGHT_PRICES_FILENAME = "flight-prices.csv";
        FLIGHT_ROUTES_FILENAME = "flight-routes.csv";
        CODE_INDEX_PRICES = 0;
        CODE_INDEX_ROUTES = 2;
        expectedFlightList = new FlightList().fromCSVtoFlightList(FLIGHT_PRICES_FILENAME,
                FLIGHT_ROUTES_FILENAME, CODE_INDEX_PRICES, CODE_INDEX_ROUTES);
    }

    @Test
    public void whenValidArgs_fromCSVtoFlightListMustReturnFlightList () throws Exception {

        List<Flight> testFlightList = new FlightList().fromCSVtoFlightList("flight-prices.csv",
                "flight-routes.csv", 0, 2);

        assertEquals(expectedFlightList.get(0).getCode(), testFlightList.get(0).getCode());

    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void whenPricesFileNotFound_ExpectException() throws Exception {

        exception.expect(Exception.class);

        List<Flight> testFlightList = new FlightList().fromCSVtoFlightList("inexistent-file.csv",
                FLIGHT_ROUTES_FILENAME, CODE_INDEX_PRICES, CODE_INDEX_ROUTES);
    }

    @Test
    public void whenRoutesFileNotFound_ExpectException() throws Exception {

        exception.expect(Exception.class);

        List<Flight> testFlightList = new FlightList().fromCSVtoFlightList(FLIGHT_PRICES_FILENAME,
                "inexistent-file.csv", CODE_INDEX_PRICES, CODE_INDEX_ROUTES);
    }

    @Test
    public void whenNegativeIndexCodePrices_ExpectException() throws Exception {

        exception.expect(Exception.class);

        List<Flight> testFlightList = new FlightList().fromCSVtoFlightList(FLIGHT_PRICES_FILENAME,
                FLIGHT_ROUTES_FILENAME, -1, CODE_INDEX_ROUTES);
    }

    @Test
    public void whenNegativeIndexCodeRoutes_ExpectException() throws Exception {

        exception.expect(Exception.class);

        List<Flight> testFlightList = new FlightList().fromCSVtoFlightList(FLIGHT_PRICES_FILENAME,
                FLIGHT_ROUTES_FILENAME, CODE_INDEX_PRICES, -1);
    }

    @Test
    public void whenOutOfBoundIndexCodePrices_ExpectException() throws Exception {

        exception.expect(Exception.class);

        List<Flight> testFlightList = new FlightList().fromCSVtoFlightList(FLIGHT_PRICES_FILENAME,
                FLIGHT_ROUTES_FILENAME, 10, CODE_INDEX_ROUTES);
    }

    @Test
    public void whenOutOfBoundIndexCodeRoutes_ExpectException() throws Exception {

        exception.expect(Exception.class);

        List<Flight> testFlightList = new FlightList().fromCSVtoFlightList(FLIGHT_PRICES_FILENAME,
                FLIGHT_ROUTES_FILENAME, CODE_INDEX_PRICES, 10);
    }
}
