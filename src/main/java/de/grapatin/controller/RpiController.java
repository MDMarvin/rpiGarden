package de.grapatin.controller;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RpiController {

    private static GpioPinDigitalOutput pin;


    @RequestMapping("/")
    public String greeting() {
        return "Hallo Welt!";
    }

    @RequestMapping("/light")
    public String light() {

        if (pin == null) {
            GpioController gpioController = GpioFactory.getInstance();
            pin = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_22, PinState.LOW);
        }

        pin.toggle();

        return "OK";
    }
}
