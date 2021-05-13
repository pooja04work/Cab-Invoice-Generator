package com.bridgelabz;

public class CabInvoiceGenerator {
    private static final double COST_PER_KILOMETER = 10;
    private static final int COST_PER_MINUTE = 1;
    private double MINIMUM_FARE = 5d;

    public double calculateFare(double distance, int time) {
        double totalFare = distance * COST_PER_KILOMETER + time * COST_PER_MINUTE;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public double calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }
}
