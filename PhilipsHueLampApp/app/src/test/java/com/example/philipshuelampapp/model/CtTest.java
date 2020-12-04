package com.example.philipshuelampapp.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CtTest {
    @Test
    public void test_control_min() {
        int min = 10;
        Ct ct = new Ct();
        ct.setMin(min);
        assertEquals(ct.getMin(), min);
    }
    @Test
    public void test_control_max() {
        int max = 10;
        Ct ct = new Ct();
        ct.setMax(max);
        assertEquals(ct.getMax(), max);
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
