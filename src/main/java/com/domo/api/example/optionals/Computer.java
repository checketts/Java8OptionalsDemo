package com.domo.api.example.optionals;

import java.util.Optional;

/**
 * Created by clintchecketts on 2/2/15.
 */
public class Computer {

    private Optional<Soundcard> soundcard = Optional.empty();

    public Optional<Soundcard> getSoundcard() {
        return soundcard;
    }

    public void setSoundcard(Optional<Soundcard> soundcard) {
        this.soundcard = soundcard;
    }
}
