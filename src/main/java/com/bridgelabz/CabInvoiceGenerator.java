package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;

public class CabInvoiceGenerator {
    private static final double COST_PER_KILOMETER = 10;
    private static final int COST_PER_MIN = 1;
    private double MINIMUM_FARE = 5;
    private final RideRepository rideRepository;

    public CabInvoiceGenerator(){
        this.rideRepository = new RideRepository();
    }

    public double calculateFare(double distance, int time) {
        double totalFare = distance * COST_PER_KILOMETER + time * COST_PER_MIN;
        return Math.max(totalFare, MINIMUM_FARE);
    }
    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }
    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }

    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId, rides);
    }


}
