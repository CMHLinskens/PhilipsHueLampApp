package com.example.philipshuelampapp.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LampTest {
    @Test
    public void test_lamp_product() {
        Product product = new Product();
        Lamp lamp = new Lamp();
        lamp.setProduct(product);
        assertEquals(lamp.getProduct(), product);
    }
    @Test
    public void test_lamp_product2() {
        Product product = new Product();
        Lamp lamp = new Lamp();
        lamp.setProduct2(product);
        assertEquals(lamp.getProduct2(), product);
    }
    @Test
    public void test_lamp_product3() {
        Product product = new Product();
        Lamp lamp = new Lamp();
        lamp.setProduct3(product);
        assertEquals(lamp.getProduct3(), product);
    }
    @Test
    public void test_lamp_additionalproperty() {
        String property = "test";
        Object testObj = new Object();
        Lamp lamp = new Lamp();
        lamp.setAdditionalProperty(property, testObj);
        assertEquals(lamp.getAdditionalProperties().get("test"), testObj);
    }
}