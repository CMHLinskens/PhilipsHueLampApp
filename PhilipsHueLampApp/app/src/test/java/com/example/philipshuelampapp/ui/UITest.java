package com.example.philipshuelampapp.ui;

import com.example.philipshuelampapp.MainActivity;
import com.example.philipshuelampapp.model.Product;

import org.junit.Test;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

public class UITest {
    @Test
    public void ui_test(){
        MainActivity mainActivity = new MainActivity();
        LampAdapter lampAdapter = new LampAdapter(mainActivity.getLamps());
        lampAdapter.getItemCount();
        LampFragment lampFragment = new LampFragment();
        Product lamp = lampFragment.getLamp();
        LampItem lampItem = new LampItem(new Product());
        ListFragment listFragment = new ListFragment();
        LampAdapter adapter = listFragment.getAdapter();
        assertNull(lamp);
        assertNull(adapter);
        assertNotEquals(mainActivity, null);
        assertNotEquals(lampAdapter, null);
        assertNotEquals(lampFragment, null);
        assertNotEquals(lampItem, null);
        assertNotEquals(listFragment, null);
    }
}
