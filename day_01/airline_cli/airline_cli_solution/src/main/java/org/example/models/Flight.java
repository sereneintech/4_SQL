package org.example.models;

import java.util.ArrayList;

public class Flight {
    private int id;
    private String destination;
    private ArrayList<Passenger> passengers;
    private Enum<FlightStatus> status;

    public Flight(int id, String destination) {
        this.id = id;
        this.destination = destination;
        this.passengers = new ArrayList<Passenger>();
        this.status = FlightStatus.ACTIVE;
    }

    public int getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Enum<FlightStatus> getStatus() {
        return status;
    }

    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
    }

    public void cancelFlight() {
        this.status = FlightStatus.CANCELLED;
    }
}
