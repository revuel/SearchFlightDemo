package com.lastminute.price;

import com.lastminute.flight.Flight;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestPriceFlight {

    private Flight testFlight;

    @Before
    public void setUp(){
        testFlight = new Flight("TEST01", "MAD", "NYC", new BigDecimal("100"));
    }

    @Test
    public void whenValidArgs_departureGE31_calculateTotalMustAssignAccordingPrice(){

        BigDecimal testNumTickets = new BigDecimal("2");
        BigDecimal testCostRate = new BigDecimal("0.8");
        BigDecimal testBasePrice = new BigDecimal("100");
        BigDecimal testDaysToDeparture = new BigDecimal("31");

        BigDecimal expected = testNumTickets.multiply(testBasePrice).multiply(testCostRate);

        BigDecimal actual = PriceFlight.calculateTotal(testFlight, testDaysToDeparture, testNumTickets);

        assertEquals(expected, actual);

    }

    @Test
    public void whenValidArgs_departureGE16_calculateTotalMustAssignAccordingPrice(){

        BigDecimal testNumTickets = new BigDecimal("2");
        BigDecimal testCostRate = new BigDecimal("1.0");
        BigDecimal testBasePrice = new BigDecimal("100");
        BigDecimal testDaysToDeparture = new BigDecimal("16");

        BigDecimal expected = testNumTickets.multiply(testBasePrice).multiply(testCostRate);

        BigDecimal actual = PriceFlight.calculateTotal(testFlight, testDaysToDeparture, testNumTickets);

        assertEquals(expected, actual);

    }

    @Test
    public void whenValidArgs_departureGE3_calculateTotalMustAssignAccordingPrice(){

        BigDecimal testNumTickets = new BigDecimal("2");
        BigDecimal testCostRate = new BigDecimal("1.2");
        BigDecimal testBasePrice = new BigDecimal("100");
        BigDecimal testDaysToDeparture = new BigDecimal("3");

        BigDecimal expected = testNumTickets.multiply(testBasePrice).multiply(testCostRate);

        BigDecimal actual = PriceFlight.calculateTotal(testFlight, testDaysToDeparture, testNumTickets);

        assertEquals(expected, actual);

    }

    @Test
    public void whenValidArgs_departureGE0_calculateTotalMustAssignAccordingPrice(){

        BigDecimal testNumTickets = new BigDecimal("2");
        BigDecimal testCostRate = new BigDecimal("1.5");
        BigDecimal testBasePrice = new BigDecimal("100");
        BigDecimal testDaysToDeparture = new BigDecimal("2");

        BigDecimal expected = testNumTickets.multiply(testBasePrice).multiply(testCostRate);

        BigDecimal actual = PriceFlight.calculateTotal(testFlight, testDaysToDeparture, testNumTickets);

        assertEquals(expected, actual);

    }

    @Test
    public void whenFlightIsNull_onCalculateTotal_returnNull () {

        BigDecimal testDaysToDeparture = new BigDecimal("30");
        BigDecimal testNumTickets = new BigDecimal("2");

        BigDecimal actual = PriceFlight.calculateTotal(null, testDaysToDeparture, testNumTickets);

        assertNull(actual);

    }

    @Test
    public void whenDepartureIsNull__onCalculateTotal_returnNull () {

        BigDecimal testNumTickets = new BigDecimal("2");

        BigDecimal actual = PriceFlight.calculateTotal(testFlight, null, testNumTickets);

        assertNull(actual);
    }

    @Test
    public void whenNumTicketsIsNull__onCalculateTotal_returnNull () {

        BigDecimal testDaysToDeparture = new BigDecimal("30");

        BigDecimal actual = PriceFlight.calculateTotal(testFlight, testDaysToDeparture, null);

        assertNull(actual);
    }

    @Test
    public void whenDepartureIsNegative__onCalculateTotal_returnNull () {

        BigDecimal testDaysToDeparture = new BigDecimal("-1");
        BigDecimal testNumTickets = new BigDecimal("1");

        BigDecimal actual = PriceFlight.calculateTotal(testFlight, testDaysToDeparture, testNumTickets);

        assertNull(actual);

    }

    @Test
    public void whenNumTicketsIsNegative__onCalculateTotal_returnNull () {

        BigDecimal testDaysToDeparture = new BigDecimal("1");
        BigDecimal testNumTickets = new BigDecimal("-1");

        BigDecimal actual = PriceFlight.calculateTotal(testFlight, testDaysToDeparture, testNumTickets);

        assertNull(actual);
    }
}
