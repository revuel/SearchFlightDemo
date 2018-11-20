package com.lastminute.flight;

import java.math.BigDecimal;

public class Flight {

    private String code;
    private String origin;
    private String destiny;
    private BigDecimal basePrice;

    public Flight(String code, String origin, String destiny, BigDecimal basePrice){
        setCode(code);
        setOrigin(origin);
        setDestiny(destiny);
        setBasePrice(basePrice);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }
}
