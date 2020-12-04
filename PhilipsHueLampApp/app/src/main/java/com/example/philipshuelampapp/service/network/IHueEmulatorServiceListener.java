package com.example.philipshuelampapp.service.network;

import com.example.philipshuelampapp.model.Lamp;

public interface IHueEmulatorServiceListener {
    void onLampsReceived(Lamp newLamps);
    void onLampsError(Lamp newLamps);
    void onActionSuccess();
    void onActionError();
}
