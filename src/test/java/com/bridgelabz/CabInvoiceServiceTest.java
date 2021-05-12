package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceServiceTest {
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare(){
        CabInvoiceGenerator cabinvoiceGenerator = new CabInvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = cabinvoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnMinimumFare(){
        CabInvoiceGenerator cabinvoiceGenerator = new CabInvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = cabinvoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }
}
