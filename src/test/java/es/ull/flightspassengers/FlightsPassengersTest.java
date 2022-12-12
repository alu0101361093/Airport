package es.ull.flightspassengers;

import es.ull.flights.Flight;
import es.ull.passengers.Passenger;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Given there are flights and passengers")
public class FlightsPassengersTest {

    private Flight flight1;
    private Flight flight2;
    private Passenger passenger1;
    private Passenger passenger2;

    @BeforeEach
    void setUp() {
        flight1 = new Flight("AB123", 50);
        flight2 = new Flight("CD3456", 120);
        passenger1 = new Passenger("1", "Passenger1", "US");
        passenger2 = new Passenger("1", "Passenger2", "ES");
    }

    @Test
    @DisplayName("Then we can add a passenger to a flight.")
    public void testAddPassengerFlight() {
        assertTrue(flight1.addPassenger(passenger1));
        assertEquals(1, flight1.getNumberOfPassengers());
        assertEquals(flight1, passenger1.getFlight());
    }

    @Test
    @DisplayName("Then we cannot add a passenger to a flight more than once.")
    public void testAddPassengerTwiceToFlight() {
        flight1.addPassenger(passenger1);
        assertFalse(flight1.addPassenger(passenger1));
        assertNotEquals(2, flight1.getNumberOfPassengers());
    }

    @Test
    @DisplayName("Then we cannot add a passenger to a flight more than once.")
    public void testAddPassengerToFullFlight() {
        flight1.addPassenger(passenger1);
        assertFalse(flight1.addPassenger(passenger1));
        assertNotEquals(2, flight1.getNumberOfPassengers());
    }

    @Test
    @DisplayName("Then we can add a passenger to a flight and then remove them")
    public void testAddAndRemovePassengerToFlight() {
        flight1.addPassenger(passenger1);
        assertTrue(flight1.removePassenger(passenger1));
        assertEquals(0, flight1.getNumberOfPassengers());
    }

    @Test
    @DisplayName("Then we cannot add a passenger to a flight that is already full")
    public void testAddAndRemovePassengerTwiceToFlight() {

        for (int i = 1; i <= 50; i++) {
            Passenger pass = new Passenger("" + i, "Pass" + i,
                    "US");
            assertTrue(flight1.addPassenger(pass));
        }

        assertEquals(50, flight1.getNumberOfPassengers());

        RuntimeException e = assertThrows(RuntimeException.class, () -> flight1.addPassenger(passenger1));
        assertEquals("Not enough seats for flight AB123", e.getMessage());

        assertNotEquals(flight1, passenger1.getFlight());
    }

    @Test
    @DisplayName("Then we can make a passenger join another flight")
    public void testJoinFlightPassenger() {
        flight1.addPassenger(passenger1);
        passenger1.joinFlight(flight2);
        assertEquals(0, flight1.getNumberOfPassengers());
        assertEquals(flight2, passenger1.getFlight());
        assertEquals(1, flight2.getNumberOfPassengers());
    }
}
