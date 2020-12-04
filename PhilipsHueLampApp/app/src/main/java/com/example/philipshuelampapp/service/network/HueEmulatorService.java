package com.example.philipshuelampapp.service.network;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.philipshuelampapp.model.Lamp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HueEmulatorService implements IHueEmulatorService{

    private static final String LOGTAG = HueEmulatorService.class.getSimpleName();

    private RequestQueue queue;
    private IHueEmulatorServiceListener listener;
    private String          bridgeUri    =   "http://10.0.2.2:80/api/";
    private String          username     =   "newdeveloper";
    private String          category     =   "/lights";

    public HueEmulatorService(Context appContext, IHueEmulatorServiceListener responseListener){
        queue = Volley.newRequestQueue(appContext);
        listener = responseListener;
    }

    @Override
    public void getLights() {
        // Form the uri
        final String uri = bridgeUri+username+category;

        // Create request
        StringRequest request =  new StringRequest(
                Request.Method.GET,
                uri,
                response -> {
                    Log.d(LOGTAG, response);
                    try {
                        Lamp lamp = new ObjectMapper().readValue(response, Lamp.class);
                        listener.onLampsReceived(lamp);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                        listener.onLampsError();
                    }
                },
                error -> {
                    error.printStackTrace();
                });

        // add request to queue
        queue.add(request);

//        final Request allLightsRequest = new Request.Builder().url(uri).build();
//
//        try (Response response = client.newCall(allLightsRequest).execute()){
//            // Im using FasterXML Jackson to map JSON
//            lamp = new ObjectMapper().readValue(response.body().string(), Lamp.class);
//            Log.d(TAG, response.body().toString());
//        } catch (IOException e) {
//            Log.d(TAG, e.getLocalizedMessage());
//            lamp = new Lamp();
//        }
    }

    public void setBridgeUri(String bridgeUri) {
        this.bridgeUri = bridgeUri;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
