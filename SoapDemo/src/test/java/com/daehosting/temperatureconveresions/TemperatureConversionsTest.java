package com.daehosting.temperatureconveresions;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by Joe on 10/12/2016.
 */
public class TemperatureConversionsTest {

    TemperatureConversionsSoapType service;

    @Before
    public void setup() {
        service = new TemperatureConversions().getTemperatureConversionsSoap12();
    }

    @Test
    public void getTemperatureConversionsSoap12() throws Exception {
        BigDecimal result = service.celsiusToFahrenheit(BigDecimal.valueOf(0.0));
        assertEquals("The conversion from celius to fahrenheit failed.", result, BigDecimal.valueOf(32));
    }

    @Test
    public void testWindChillInCelsius() {
        BigDecimal result = service.windChillInCelsius(BigDecimal.valueOf(10), BigDecimal.valueOf(20));
        assertEquals(result, BigDecimal.valueOf(-3.37));
    }
}