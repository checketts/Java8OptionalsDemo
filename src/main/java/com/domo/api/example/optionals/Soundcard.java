package com.domo.api.example.optionals;

import java.util.Optional;

/**
 * Created by clintchecketts on 2/2/15.
 */
public class Soundcard {
    private Optional<USB> usb = Optional.empty();

    public Optional<USB> getUSB() {
        return usb;
    }

    public void setUSB(Optional<USB> usb) {
        this.usb = usb;
    }
}
