package com.domo.api.example.optionals;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by clintchecketts on 2/2/15.
 */
public class OptionalComputerTest {

    Computer computer;

    @Before
    public void setUp() throws Exception {
        computer = new Computer();

        Soundcard soundcard = new Soundcard();
        USB usb1 = new USB();
        usb1.setVersion("3.0");
        soundcard.setUSB(Optional.of(usb1));
        computer.setSoundcard(Optional.of(soundcard));
    }

    @Test
    public void getSoundcardUsb_shouldBeUnknownByDefault() throws Exception {
        String version = computer.getSoundcard()
                .flatMap(Soundcard::getUSB)
                .map(USB::getVersion)
                .orElse("UNKNOWN");
        assertThat(version).isEqualTo("3.0");
    }

    @Test
    public void badExample_getSoundcardUsb_avoidTheseChecks() throws Exception {
        if(computer.getSoundcard().isPresent()){
            System.out.println(computer.getSoundcard().get());
        }
    }

    @Test
    public void example_getSoundcardUsb_defaultValues() throws Exception {
        Soundcard soundcard = computer.getSoundcard().orElse(new Soundcard());

        soundcard = computer.getSoundcard().orElseThrow(IllegalStateException::new);
    }
    @Test
    public void example_getSoundcardUsb_extractingVals() throws Exception {
        boolean wasPresent = false;
        computer.getSoundcard().map(Soundcard::getUSB)
                .filter(usb -> "3.0".equals(usb.get().getVersion()))
                .ifPresent(usb -> System.out.println("ok"));

        Soundcard soundcard = new Soundcard();
        USB usb1 = new USB();
        usb1.setVersion("3.0");
        soundcard.setUSB(Optional.of(usb1));
        computer.setSoundcard(Optional.of(soundcard));

        String notFinal = "ok for reals";
        computer.getSoundcard().map(Soundcard::getUSB)
                .filter(usb -> "3.0".equals(usb.get().getVersion()))
                .ifPresent(usb -> System.out.println(notFinal));
    }

    @Test
    public void example_getSoundcardUsb_extractingValsInner() throws Exception {
//        String version = computer.getSoundcard()
//                .map(Soundcard::getUSB)
//                .map(USB::getVersion)
//                .orElse("UNKNOWN");

        String version = computer.getSoundcard()
                .flatMap(Soundcard::getUSB)
                .map(USB::getVersion)
                .orElse("UNKNOWN");

        assertThat(version).isEqualTo("3.0");
    }
}
