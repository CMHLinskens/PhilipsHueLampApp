package com.example.philipshuelampapp.service.network;

import com.example.philipshuelampapp.model.Lamp;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class HueEmulatorServiceMockTest {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    HueEmulatorService hueEmulatorServiceMock;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void retrieve_lamps_from_emulator() {
        hueEmulatorServiceMock = new HueEmulatorService();
        Lamp lamps = hueEmulatorServiceMock.getLights();
        boolean check = !lamps.equals(null);
        assertTrue(check);
    }
}
