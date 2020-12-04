package com.example.philipshuelampapp.service.network;

import com.example.philipshuelampapp.model.Lamp;

import org.json.JSONObject;

public interface IHueEmulatorServiceListener {
    void onLampsReceived(Lamp newLamps);
    void onLampsError(Lamp newLamps);
    void onActionSuccess(String response);
    void onActionError();
}
