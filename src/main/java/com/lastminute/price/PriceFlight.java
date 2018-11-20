package com.lastminute.price;
import com.lastminute.flight.Flight;
import java.math.BigDecimal;

public class PriceFlight {

    public static BigDecimal calculateTotal(Flight flight, BigDecimal daysToDeparture, BigDecimal numTickets) {

        if (checkArgs(flight, daysToDeparture, numTickets)) {
            return (flight.getBasePrice()
                    .multiply(priceFactorByDays(daysToDeparture)))
                    .multiply(numTickets);
        } else {
            return null;
        }
    }

    private static BigDecimal priceFactorByDays (BigDecimal daysToDeparture) {

        if ( daysToDeparture.compareTo(BigDecimal.valueOf(31)) >= 0 ) {
            return BigDecimal.valueOf(0.8);
        } else if ( daysToDeparture.compareTo(BigDecimal.valueOf(16)) >= 0 ) {
            return BigDecimal.valueOf(1.0);
        } else if ( daysToDeparture.compareTo(BigDecimal.valueOf(3)) >= 0 ) {
            return BigDecimal.valueOf(1.2);
        } else if ( daysToDeparture.compareTo(BigDecimal.valueOf(0)) >= 0 ) {
            return BigDecimal.valueOf(1.5);
        }
        return null;
    }

    private static boolean checkArgs(Flight flight, BigDecimal daysToDeparture, BigDecimal numTickets){
        return checkFlight(flight) &&
                checkPositiveNotNull(daysToDeparture) &&
                checkPositiveNotNull(numTickets);
    }

    private static boolean checkFlight(Flight flight){
        return flight != null;
    }

    private static boolean checkPositiveNotNull(BigDecimal bigdecimal) {
        return bigdecimal != null && bigdecimal.signum() != -1;
    }


}
