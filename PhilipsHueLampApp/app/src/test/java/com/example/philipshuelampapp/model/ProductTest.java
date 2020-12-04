package com.example.philipshuelampapp.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ProductTest {
    @Test
    public void test_product_state() {
        State state = new State();
        Product product = new Product();
        product.setState(state);
        assertEquals(product.getState(), state);
    }
    @Test
    public void test_product_swupdate() {
        Swupdate swupdate = new Swupdate();
        Product product = new Product();
        product.setSwupdate(swupdate);
        assertEquals(product.getSwupdate(), swupdate);
    }
    @Test
    public void test_product_type() {
        String type = "Philips Hue Light";
        Product product = new Product();
        product.setType(type);
        assertEquals(product.getType(), type);
    }
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
    public void test_product_manufacturername() {
        String manufacturername = "Philips";
        Product product = new Product();
        product.setManufacturername(manufacturername);
        assertEquals(product.getManufacturername(), manufacturername);
    }
    @Test
    public void test_product_productname() {
        String productname = "Philips Hue Lamp";
        Product product = new Product();
        product.setProductname(productname);
        assertEquals(product.getProductname(), productname);
    }
    @Test
    public void test_product_capabilities() {
        Capabilities capabilities = new Capabilities();
        Product product = new Product();
        product.setCapabilities(capabilities);
        assertEquals(product.getCapabilities(), capabilities);
    }
    @Test
    public void test_product_config() {
        Config config = new Config();
        Product product = new Product();
        product.setConfig(config);
        assertEquals(product.getConfig(), config);
    }
    @Test
    public void test_product_uniqueid() {
        String uniqueid = "00:33:32:88:12-a1";
        Product product = new Product();
        product.setUniqueid(uniqueid);
        assertEquals(product.getUniqueid(), uniqueid);
    }
    @Test
    public void test_product_swversion() {
        String swversion = "32879";
        Product product = new Product();
        product.setSwversion(swversion);
        assertEquals(product.getSwversion(), swversion);
    }
    @Test
    public void test_product_additionalproperty() {
        String property = "test";
        Object testObj = new Object();
        Product product = new Product();
        product.setAdditionalProperty(property, testObj);
        assertEquals(product.getAdditionalProperties().get("test"), testObj);
    }
}