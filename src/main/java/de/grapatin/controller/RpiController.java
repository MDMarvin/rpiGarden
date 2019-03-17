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

    @RequestMapping("/lightKitchen")
    public String light() {

        if (pin == null) {
            GpioController gpioController = GpioFactory.getInstance();
            pin = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_03, PinState.LOW);
        }

        pin.toggle();

        return "OK";
    }


    @RequestMapping("/lightTools")
    public String lightTools() {

        if (pin == null) {
            GpioController gpioController = GpioFactory.getInstance();
            pin = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_02, PinState.LOW);
        }

        pin.toggle();

        return "OK";
    }
}
