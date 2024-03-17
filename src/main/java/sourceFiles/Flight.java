package sourceFiles;

public class Flight {
    private String flightNumber;
    private String airline;
    private int capacity;
    private int bookedSeats;

    public Flight(String flightNumber, String airline, int capacity) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.capacity = capacity;
        this.bookedSeats = 0;
    }

    public boolean bookSeat() {
        if (bookedSeats < capacity) {
            bookedSeats++;
            return true;
        }
        return false;
    }

    public String getFlightDetails() {
        return "Flight: " + flightNumber + ", Airline: " + airline + ", Available Seats: " + (capacity - bookedSeats);
    }
}
