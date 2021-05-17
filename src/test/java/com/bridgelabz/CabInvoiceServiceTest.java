package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceServiceTest {
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare(){
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = cabInvoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnMinimumFare(){
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = cabInvoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenRides_ShouldReturnInvoiceSummary() {
        CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
        Ride[] rides = {
                new Ride(2.0, 5, RideType.NORMAL),
                new Ride(0.1, 1, RideType.NORMAL)
        };
        InvoiceSummary actualInvoiceSummary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
    }


    @Test
    public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
        String userId = "Pooja";
        Ride[] rides = {
                new Ride(2.0, 5, RideType.NORMAL),
                new Ride(0.1, 1, RideType.NORMAL),
                new Ride(20, 10, RideType.NORMAL)
        };
        CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
        invoiceGenerator.addRides(userId, rides);
        InvoiceSummary actualInvoiceSummary = invoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3,240.0);
        Assert.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
    }

    @Test
    public void givenUserIdAndRidesForTwoCategoriesRides_ShouldReturnInvoiceSummary() {
        String userId = "Pooja";
        Ride[] rides = {
                        new Ride(2.0, 5, RideType.PREMIUM),
                        new Ride(20, 10, RideType.PREMIUM)
                        };
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        cabInvoiceGenerator.addRides(userId, rides);
        InvoiceSummary summary = cabInvoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 360);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }
}
