package de.grapatin;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplicationBuilder applicationBuilder = new SpringApplicationBuilder(App.class);
        applicationBuilder.build().addListeners(new ApplicationPidFileWriter("./bin/shutdown.pid"));
        applicationBuilder.run(args);
    }
}
