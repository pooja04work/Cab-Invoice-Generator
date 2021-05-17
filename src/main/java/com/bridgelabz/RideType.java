package com.bridgelabz;

public enum RideType {
    NORMAL(10.0, 1.0, 5.0),
    PREMIUM(15.0, 2.0, 20.0);

    private final double COST_PER_KM;
    private final double COST_PER_MIN;
    private final double MIN_FARE;

    RideType(double COST_PER_KM, double COST_PER_MIN, double MIN_FARE) {
        this.COST_PER_KM = COST_PER_KM;
        this.COST_PER_MIN = COST_PER_MIN;
        this.MIN_FARE = MIN_FARE;
    }
    double calculateCostOfCabRide(Ride ride) {
        double rideCost = ride.distance * COST_PER_KM + ride.time * COST_PER_MIN;
        return Math.max(rideCost, MIN_FARE);
        }
}