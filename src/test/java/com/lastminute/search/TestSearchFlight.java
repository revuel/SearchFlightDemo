package com.lastminute.search;

import com.lastminute.flight.Flight;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class TestSearchFlight {

    private Flight testValidFlight;
    private List<Flight> testListFlight = new ArrayList<>();

    @Before
    public void setUp() {
        testValidFlight = new Flight("TEST", "MAD", "NYC", BigDecimal.valueOf(100.0));
        testListFlight.add(testValidFlight);
    }

    @Test
    public void whenValidArgs_returnFlightList(){
        List<Flight> expected = testListFlight;

        List<Flight> actual = SearchFlight.directSearch(testListFlight, "MAD", "NYC");

        assertEquals(expected, actual);

    }

    @Test
    public void whenNoDirectFlightFound_returnEmpty(){
        List<Flight> actual = SearchFlight.directSearch(testListFlight, "MAD", "FRA");
        assertTrue(actual.isEmpty());
    }

    @Test
    public void whenInexistengOriginArg_returnEmpty(){
        List<Flight> actual = SearchFlight.directSearch(testListFlight, "", "NYC");
        assertTrue(actual.isEmpty());
    }

    @Test
    public void whenInexistengDestinyArg_returnEmpty(){
        List<Flight> actual = SearchFlight.directSearch(testListFlight, "MAD", "");
        assertTrue(actual.isEmpty());
    }

    @Test
    public void whenEmptyFlightsArg_returnEmpty(){
        List<Flight> noFlights = new ArrayList<>();

        List<Flight> actual = SearchFlight.directSearch(noFlights, "MAD", "NYC");
        assertTrue(actual.isEmpty());
    }
}
