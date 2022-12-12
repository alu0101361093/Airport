package es.ull.passengers;

import es.ull.flights.Flight;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Given there are passengers")
public class PassengerTest {
    private Passenger passenger1;
    private Passenger passenger2;

    @BeforeEach
    void setUp() {
        passenger1 = new Passenger("1", "Passenger1", "US");
        passenger2 = new Passenger("2", "Passenger2", "ES");
    }

    @Test
    @DisplayName("Then we can get their ID, name and country code.")
    public void testAttributesPassenger() {
        assertAll("Verify all conditions for a passenger",
                () -> assertEquals("1", passenger1.getIdentifier()),
                () -> assertEquals("2", passenger2.getIdentifier()),
                () -> assertEquals("Passenger1", passenger1.getName()),
                () -> assertEquals("Passenger2", passenger2.getName()),
                () -> assertEquals("US", passenger1.getCountryCode()),
                () -> assertEquals("ES", passenger2.getCountryCode())
        );
    }

    @Test
    @DisplayName("Then we can get their all of their information in a String format.")
    public void testToStringPassenger() {
        assertEquals("Passenger " + "Passenger1" + " with identifier: " + "1" +
                " from " + "US", passenger1.toString());
        assertEquals("Passenger " + "Passenger2" + " with identifier: " + "2" +
                " from " + "ES", passenger2.toString());
    }








}
