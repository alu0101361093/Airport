package es.ull.flights;

import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Given there is a flight")
public class FlightTest {

    private Flight flight1;
    private Flight flight2;

    @BeforeEach
    void setUp() {
        flight1 = new Flight("AB123", 50);
        flight2 = new Flight("CD3456", 120);
    }

    @Test
    @DisplayName("We can get its flight number and number of seats")
    public void testAttributesFlight() {
        assertAll("Verify all conditions for a flight",
                () -> assertEquals("AB123", flight1.getFlightNumber()),
                () -> assertEquals("CD3456", flight2.getFlightNumber()),
                () -> assertEquals(0, flight1.getNumberOfPassengers()),
                () -> assertEquals(0, flight2.getNumberOfPassengers())
        );
    }
}

