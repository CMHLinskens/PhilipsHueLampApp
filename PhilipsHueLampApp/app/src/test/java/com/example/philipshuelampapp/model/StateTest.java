package com.example.philipshuelampapp.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(state.getBri(), brightness);
    }
    @Test
    public void test_state_hue() {
        int hue = 25555;
        State state = new State();
        state.setHue(hue);
        assertEquals(state.getHue(), hue);
    }
    @Test
    public void test_state_sat() {
        int saturation = 25555;
        State state = new State();
        state.setSat(saturation);
        assertEquals(state.getSat(), saturation);
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
        assertEquals(state.getCt(), ct);
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
