package com.example.philipshuelampapp.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class StateTest {
    @Test
    public void test_state_on() {
        boolean on = false;
        State state = new State();
        state.setOn(on);
        assertEquals(state.getOn(), on);
    }
    @Test
    public void test_state_bri() {
        int brightness = 155;
        State state = new State();
        state.setBri(brightness);
        boolean check = state.getBri() == brightness;
        assertTrue(check);
    }
    @Test
    public void test_state_hue() {
        int hue = 25555;
        State state = new State();
        state.setHue(hue);
        boolean check = state.getHue() == hue;
        assertTrue(check);
    }
    @Test
    public void test_state_sat() {
        int saturation = 25555;
        State state = new State();
        state.setSat(saturation);
        boolean check = state.getSat() == saturation;
        assertTrue(check);
    }
    @Test
    public void test_state_effect() {
        String effect = "effecttest";
        State state = new State();
        state.setEffect(effect);
        assertEquals(state.getEffect(), effect);
    }
    @Test
    public void test_state_xy() {
        List<Double> xy = new ArrayList<>();
        State state = new State();
        state.setXy(xy);
        assertEquals(state.getXy(), xy);
    }
    @Test
    public void test_state_ct() {
        int ct = 2;
        State state = new State();
        state.setCt(ct);
        boolean check = state.getCt() == ct;
        assertTrue(check);
    }
    @Test
    public void test_state_alert() {
        String alert = "none";
        State state = new State();
        state.setAlert(alert);
        assertEquals(state.getAlert(), alert);
    }
    @Test
    public void test_state_colormode() {
        String colormode = "colorloop";
        State state = new State();
        state.setColormode(colormode);
        assertEquals(state.getColormode(), colormode);
    }
    @Test
    public void test_state_mode() {
        String mode = "modetest";
        State state = new State();
        state.setMode(mode);
        assertEquals(state.getMode(), mode);
    }
    @Test
    public void test_state_reachable() {
        boolean reachable = true;
        State state = new State();
        state.setReachable(reachable);
        assertEquals(state.getReachable(), reachable);
    }
    @Test
    public void test_state_additionalproperty() {
        String property = "test";
        Object testObj = new Object();
        State state = new State();
        state.setAdditionalProperty(property, testObj);
        assertEquals(state.getAdditionalProperties().get("test"), testObj);
    }
}
