package com.example.philipshuelampapp.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConfigTest {
    @Test
    public void test_config_archetype() {
        String archetype = "archtest";
        Config config = new Config();
        config.setArchetype(archetype);
        assertEquals(config.getArchetype(), archetype);
    }
    @Test
    public void test_config_function() {
        String function = "functiontest";
        Config config = new Config();
        config.setFunction(function);
        assertEquals(config.getFunction(), function);
    }
    @Test
    public void test_config_direction() {
        String direction = "directiontest";
        Config config = new Config();
        config.setDirection(direction);
        assertEquals(config.getDirection(), direction);
    }
    @Test
    public void test_config_additionalproperty() {
        String property = "test";
        Object testObj = new Object();
        Config config = new Config();
        config.setAdditionalProperty(property, testObj);
        assertEquals(config.getAdditionalProperties().get("test"), testObj);
    }
}
