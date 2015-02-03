package com.domo.api.example.traditional;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ComputerTest {

    Computer computer;

    @Before
    public void setUp() throws Exception {
        computer = new Computer();
    }

    @Test
    public void getSoundcardUsb_shouldBeUnknownByDefault() throws Exception {
        String version = "UNKNOWN";
        if(computer != null){
            Soundcard soundcard = computer.getSoundcard();
            if(soundcard != null){
                USB usb = soundcard.getUSB();
                if(usb != null){
                    version = usb.getVersion();
                }
            }
        }
        assertThat(version).isEqualTo("UNKNOWN");
    }

    @Test
    public void example_getSoundcardUsb_extractingVals() throws Exception {
        if(computer.getSoundcard() != null){
            USB usb = computer.getSoundcard().getUSB();
            if(usb != null && "3.0".equals(usb.getVersion())){
                System.out.println("ok");
            }
        }
    }
}