package com.example.philipshuelampapp.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ControlTest {
    @Test
    public void test_control_mindimlevel() {
        int mindimlevel = 100;
        Control control = new Control();
        control.setMindimlevel(mindimlevel);
        assertEquals(control.getMindimlevel(), mindimlevel);
    }
    @Test
    public void test_control_maxlumen() {
        int maxlumen = 50;
        Control control = new Control();
        control.setMaxlumen(maxlumen);
        assertEquals(control.getMaxlumen(), maxlumen);
    }
    @Test
    public void test_control_colorgamuttype() {
        String colorgamuttype = "colortypetest";
        Control control = new Control();
        control.setColorgamuttype(colorgamuttype);
        assertEquals(control.getColorgamuttype(), colorgamuttype);
    }
    @Test
    public void test_control_colorgamut() {
        List<List<Double>> colorgamut = new ArrayList<>();
        Control control = new Control();
        control.setColorgamut(colorgamut);
        assertEquals(control.getColorgamut(), colorgamut);
    }
    @Test
    public void test_control_ct() {
        Ct ct = new Ct();
        Control control = new Control();
        control.setCt(ct);
        assertEquals(control.getCt(), ct);
    }
    @Test
    public void test_control_additionalproperty() {
        String property = "test";
        Object testObj = new Object();
        Control control = new Control();
        control.setAdditionalProperty(property, testObj);
        assertEquals(control.getAdditionalProperties().get("test"), testObj);
    }
}
