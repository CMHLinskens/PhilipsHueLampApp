package com.example.philipshuelampapp;

import com.example.philipshuelampapp.model.Lamp;
import com.example.philipshuelampapp.service.network.HueEmulatorService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HueEmulatorServiceTest {
    @Test
    public void retrieveLampsTest() {
        HueEmulatorService hueEmulatorService = new HueEmulatorService();
        Lamp lamps = hueEmulatorService.getLights();
        assertTrue(lamps.getProduct() != null);
    }
}