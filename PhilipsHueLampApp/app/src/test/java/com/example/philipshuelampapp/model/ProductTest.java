package com.example.philipshuelampapp.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    @Test
    public void test_product_name() {
        String name = "LAMP WOONKAMER";
        Product product = new Product();
        product.setName(name);
        assertEquals(product.getName(), name);
    }

    @Test
    public void test_product_modelid() {
        String modelid = "LC007";
        Product product = new Product();
        product.setModelid(modelid);
        assertEquals(product.getModelid(), modelid);
    }

    @Test
    public void test_product_state() {
        State state = new State();
        state.setBri(254);
        state.setHue(25555);
        Product product = new Product();
        product.setState(state);
        assertEquals(product.getState(), state);
    }
}