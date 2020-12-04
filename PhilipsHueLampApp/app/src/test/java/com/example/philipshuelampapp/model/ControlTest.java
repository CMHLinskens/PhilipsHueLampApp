package com.example.philipshuelampapp.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;


public class ControlTest {
    @Test
    public void test_control_mindimlevel() {
        int mindimlevel = 100;
        Control control = new Control();
        control.setMindimlevel(mindimlevel);
        boolean check = control.getMindimlevel() == mindimlevel;
        assertTrue(check);
    }
    @Test
    public void test_control_maxlumen() {
        int maxlumen = 50;
        Control control = new Control();
        control.setMaxlumen(maxlumen);
        boolean check = control.getMaxlumen() == maxlumen;
        assertTrue(check);
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
