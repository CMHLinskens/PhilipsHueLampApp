package com.example.philipshuelampapp.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StreamingTest {
    @Test
    public void test_streaming_renderer() {
        boolean renderer = true;
        Streaming streaming = new Streaming();
        streaming.setRenderer(renderer);
        assertEquals(streaming.getRenderer(), renderer);
    }
    @Test
    public void test_streaming_proxy() {
        boolean proxy = false;
        Streaming streaming = new Streaming();
        streaming.setProxy(proxy);
        assertEquals(streaming.getProxy(), proxy);
    }
    @Test
    public void test_streaming_additionalproperty() {
        String property = "test";
        Object testObj = new Object();
        Streaming streaming = new Streaming();
        streaming.setAdditionalProperty(property, testObj);
        assertEquals(streaming.getAdditionalProperties().get("test"), testObj);
    }
}
