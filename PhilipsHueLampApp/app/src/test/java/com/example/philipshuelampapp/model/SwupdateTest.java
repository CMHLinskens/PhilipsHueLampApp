package com.example.philipshuelampapp.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SwupdateTest {
    @Test
    public void test_swupdate_state() {
        String state = "statetest";
        Swupdate swupdate = new Swupdate();
        swupdate.setState(state);
        assertEquals(swupdate.getState(), state);
    }
    @Test
    public void test_swupdate_lastinstall() {
        String lastinstall = "statetest";
        Swupdate swupdate = new Swupdate();
        swupdate.setLastinstall(lastinstall);
        assertEquals(swupdate.getLastinstall(), lastinstall);
    }
    @Test
    public void test_swupdate_additionalproperty() {
        String property = "test";
        Object testObj = new Object();
        Swupdate swupdate = new Swupdate();
        swupdate.setAdditionalProperty(property, testObj);
        assertEquals(swupdate.getAdditionalProperties().get("test"), testObj);
    }
}
