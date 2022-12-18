package org.example;

import org.example.models.Flight;
import org.example.models.FlightStatus;
import org.example.models.Passenger;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Flight> flights = new ArrayList<>();
    private static ArrayList<Passenger> passengers = new ArrayList<>();

    public static void main(String[] args) {
        welcome();
    }

    private static void welcome() {
        System.out.println("Welcome to Bright Airlines!");
        menu();
    }

    private static void menu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter a number to select an option. Available options:");
        System.out.println("1 - Add a flight");
        System.out.println("2 - View flights");
        System.out.println("3 - Search flights by destination");
        System.out.println("4 - Cancel a flight");
        System.out.println("5 - Create a passenger");
        System.out.println("6 - View Passengers");
        System.out.println("7 - Add passenger to a flight");

        int input = scanner.nextInt();
        switch (input) {
            case 1:
                addFlight();
                break;
            case 2:
                viewFlights();
                break;
            case 3:
                searchFlightsByDestination();
                break;
            case 4:
                cancelFlight();
                break;
            case 5:
                addPassenger();
                break;
            case 6:
                viewPassengers();
                break;
            case 7:
                addPassengerToFlight();
                break;
            default:
                System.out.println("Invalid input, please try again");
        }
    }

    private static void searchFlightsByDestination() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a destination");
        String input = scanner.nextLine();

        System.out.printf("Search results for %s:\n", input);
        for (Flight flight : flights) {
            if(flight.getDestination().contains(input)) {
                System.out.printf("[Flight %x]: %s - Passengers: %x - Status: %s\n", flight.getId(), flight.getDestination(), flight.getPassengers().size(), flight.getStatus());
            }
        }

        menu();
    }


    private static void addFlight() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a destination");
        String destination = scanner.nextLine();
        int flightId = flights.size();
        Flight flight = new Flight(flightId, destination);
        flights.add(flight);
        System.out.println(String.format("Flight %x to %s added!", flightId, destination));

        menu();
    }

    private static void viewFlights() {
        System.out.println("Available flights:");
        for (Flight flight : flights) {
            System.out.printf("[Flight %x]: %s - Passengers: %x - Status: %s\n", flight.getId(), flight.getDestination(), flight.getPassengers().size(), flight.getStatus());
        }

        menu();
    }

    private static void cancelFlight() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the flight ID");
        int flightId = scanner.nextInt();
        Boolean found = false;
        for (Flight flight : flights) {
            if (flight.getId() == flightId) {
                flight.cancelFlight();
                found = true;
                System.out.printf("Flight %x to %s has been cancelled\n", flight.getId(), flight.getDestination());
            }
        }

        if(found == false) {
            System.out.printf("Error: Could not find Flight with ID %s", flightId);
        }

        menu();
    }

    private static void viewPassengers() {
        System.out.println("Passengers:");
        for (Passenger passenger : passengers) {
            System.out.printf("[Passenger %x]: %s - %s\n", passenger.getId(), passenger.getName(), passenger.getEmail());
        }

        System.out.println("\n");
        menu();
    }

    private static void addPassenger() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the passenger name");
        String name = scanner.nextLine();

        System.out.println("Please enter the passenger email");
        String email = scanner.nextLine();

        Passenger passenger = new Passenger(passengers.size(), name, email);
        passengers.add(passenger);

        System.out.println("Passenger added");

        menu();
    }

    private static void addPassengerToFlight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the passenger ID");
        int passengerId = scanner.nextInt();

        Passenger selectedPassenger = null;
        Boolean found = false;
        for (Passenger passenger : passengers) {
            if (passenger.getId() == passengerId) {
                found = true;
                selectedPassenger = passenger;
                break;
            }
        }

        if(found == false) {
            System.out.printf("Error: Could not find Passenger with ID %s", passengerId);
            menu();
            return;
        }

        System.out.println("Please enter the flight ID");
        int flightId = scanner.nextInt();
        found = false;
        for (Flight flight : flights) {
            if (flight.getId() == flightId) {
                found = true;
                if(flight.getStatus() == FlightStatus.CANCELLED) {
                    System.out.printf("Cannot add passenger, flight %x has been cancelled\n", flight.getId());
                    break;
                }
                flight.addPassenger(selectedPassenger);
                System.out.printf("[Passenger %x] %s has been added to [Flight %x] to %s\n", selectedPassenger.getId(),selectedPassenger.getName(), flight.getId(), flight.getDestination());
            }
        }

        if(found == false) {
            System.out.printf("Error: Could not find Flight with ID %s", flightId);
        }

        menu();
    }
}