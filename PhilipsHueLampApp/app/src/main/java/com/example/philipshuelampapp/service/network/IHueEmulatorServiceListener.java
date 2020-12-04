package com.example.philipshuelampapp.service.network;

import com.example.philipshuelampapp.model.Lamp;

public interface IHueEmulatorServiceListener {
    void onLampsReceived(Lamp lamp);
    void onLampsError();
}
