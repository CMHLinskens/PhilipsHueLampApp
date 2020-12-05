package com.example.philipshuelampapp.service.network;

import android.os.AsyncTask;
import android.util.Log;

import com.example.philipshuelampapp.model.Lamp;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HueEmulatorService implements IHueEmulatorService{

    private static final String LOGTAG = HueEmulatorService.class.getSimpleName();
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private final OkHttpClient client = new OkHttpClient();
    private String bridgeUri = "http://10.0.2.2:80/api/";
    private String username = "newdeveloper";
    private final String category = "/lights";

    @Override
    public Lamp getLights() {
        // Form the uri
        final String uri = bridgeUri+username+category;

        // Create request
        final Request allLightsRequest = new Request.Builder().url(uri).build();

        // Send request on new thread
        AsyncTask task = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                Lamp lamp;
                try (Response response = client.newCall(allLightsRequest).execute()){
                    // Im using FasterXML Jackson to map JSON
                    Log.d(LOGTAG, response.body().toString());
                    lamp = new ObjectMapper().readValue(response.body().string(), Lamp.class);
                } catch (IOException e) {
                    Log.d(LOGTAG, e.getLocalizedMessage());
                    lamp = new Lamp();
                }
                return lamp;
            }
        };

        try {
            return (Lamp)(task.execute().get());
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
//        new Thread(() -> {
//            try (Response response = client.newCall(allLightsRequest).execute()){
//                // Im using FasterXML Jackson to map JSON
//                Log.d(LOGTAG, response.body().toString());
//                Lamp lamp = new ObjectMapper().readValue(response.body().string(), Lamp.class);
//                listener.onLampsReceived(lamp);
//            } catch (IOException e) {
//                Log.d(LOGTAG, e.getLocalizedMessage());
//                Lamp lamp = new Lamp();
//                listener.onLampsError(lamp);
//            }
//        });
        return null;
    }

    @Override
    public void setLightPowerState(String id, boolean state) {
        // Form the uri
        final String uri = bridgeUri + username + category + "/"+id +"/state";

        // Create params
        JSONObject params = new JSONObject();
        try {
            params.put("on", state);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(params.toString(), JSON);

        // Create request
        final Request powerStateRequest = new Request.Builder().url(uri).put(body).build();

        // Send request on new thread
        sendActionRequestOnNewThread(powerStateRequest);
    }

    @Override
    public void setLightBrightness(String id, int value) {
        // Form the uri
        final String uri = bridgeUri + username + category + "/"+id +"/state";

        // Create params
        JSONObject params = new JSONObject();
        try {
            params.put("bri", value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(params.toString(), JSON);

        // Create request
        final Request brightnessChangeRequest = new Request.Builder().url(uri).put(body).build();

        // Send request on new thread
        sendActionRequestOnNewThread(brightnessChangeRequest);
    }

    @Override
    public void setLightHue(String id, int value) {
        // Form the uri
        final String uri = bridgeUri + username + category + "/"+id +"/state";

        // Create params
        JSONObject params = new JSONObject();
        try {
            params.put("hue", value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(params.toString(), JSON);

        // Create request
        final Request hueChangeRequest = new Request.Builder().url(uri).put(body).build();

        // Send request on new thread
        sendActionRequestOnNewThread(hueChangeRequest);
    }

    @Override
    public void setLightSaturation(String id, int value) {
        // Form the uri
        final String uri = bridgeUri + username + category + "/"+id +"/state";

        // Create params
        JSONObject params = new JSONObject();
        try {
            params.put("sat", value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(params.toString(), JSON);

        // Create request
        final Request saturationChangeRequest = new Request.Builder().url(uri).put(body).build();

        // Send request on new thread
        sendActionRequestOnNewThread(saturationChangeRequest);
    }

    @Override
    public void setLightName(String id, String name) {
        // Form the uri
        final String uri = bridgeUri + username + category + "/"+id;

        // Create params
        JSONObject params = new JSONObject();
        try {
            params.put("name", name);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(params.toString(), JSON);

        // Create request
        final Request nameChangeRequest = new Request.Builder().url(uri).put(body).build();

        // Send request on new thread
        sendActionRequestOnNewThread(nameChangeRequest);
    }

    private void sendActionRequestOnNewThread(Request httpRequest){
        // Send request on new thread
        new Thread(() -> {
            try (Response response = client.newCall(httpRequest).execute()){
                // Im using FasterXML Jackson to map JSON
                Log.d(LOGTAG, response.body().toString());
            } catch (IOException e) {
                Log.d(LOGTAG, e.getLocalizedMessage());
            }
        }).start();
    }

    public void setBridgeUri(String bridgeUri) {
        this.bridgeUri = bridgeUri;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
