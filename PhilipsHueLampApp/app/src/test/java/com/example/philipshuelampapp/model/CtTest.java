package com.example.philipshuelampapp.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CtTest {
    @Test
    public void test_control_min() {
        int min = 10;
        Ct ct = new Ct();
        ct.setMin(min);
        boolean check = ct.getMin() == min;
        assertTrue(check);
    }
    @Test
    public void test_control_max() {
        int max = 10;
        Ct ct = new Ct();
        ct.setMax(max);
        boolean check = ct.getMax() == max;
        assertTrue(check);
    }
    @Test
    public void test_ct_additionalproperty() {
        String property = "test";
        Object testObj = new Object();
        Ct ct = new Ct();
        ct.setAdditionalProperty(property, testObj);
        assertEquals(ct.getAdditionalProperties().get("test"), testObj);
    }
}
