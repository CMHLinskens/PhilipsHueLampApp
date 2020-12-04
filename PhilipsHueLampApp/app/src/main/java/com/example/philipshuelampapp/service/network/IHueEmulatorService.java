package com.example.philipshuelampapp.service.network;

public interface IHueEmulatorService {
    void getLights();
    void setLightPowerState(String id, boolean state);
    void setLightBrightness(String id, int value);
    void setLightHue(String id, int value);
    void setLightSaturation(String id, int value);
    void setLightName(String id, String name);
    void setBridgeUri(String uri);
    void setUsername(String username);
}
