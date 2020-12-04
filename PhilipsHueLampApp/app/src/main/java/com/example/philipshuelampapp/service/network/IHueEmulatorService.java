package com.example.philipshuelampapp.service.network;

import com.example.philipshuelampapp.model.Lamp;

public interface IHueEmulatorService {
    void getLights();
    void setBridgeUri(String uri);
    void setUsername(String username);
}
