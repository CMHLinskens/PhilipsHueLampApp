package com.example.philipshuelampapp.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CapabilitiesTest {
    @Test
    public void test_capabilities_certified() {
        boolean certified = true;
        Capabilities capabilities = new Capabilities();
        capabilities.setCertified(certified);
        assertEquals(capabilities.getCertified(), certified);
    }
    @Test
    public void test_capabilities_control() {
        Control control = new Control();
        Capabilities capabilities = new Capabilities();
        capabilities.setControl(control);
        assertEquals(capabilities.getControl(), control);
    }
    @Test
    public void test_capabilities_streaming() {
        Streaming streaming = new Streaming();
        Capabilities capabilities = new Capabilities();
        capabilities.setStreaming(streaming);
        assertEquals(capabilities.getStreaming(), streaming);
    }
    @Test
    public void test_capabilities_additionalproperty() {
        String property = "test";
        Object testObj = new Object();
        Capabilities capabilities = new Capabilities();
        capabilities.setAdditionalProperty(property, testObj);
        assertEquals(capabilities.getAdditionalProperties().get("test"), testObj);
    }
}
