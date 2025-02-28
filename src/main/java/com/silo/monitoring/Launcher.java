package com.silo.monitoring;

import com.silo.monitoring.view.SiloMonitorView;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Launcher {
    public static void main(String[] args) {
        // Inicia o Spring Boot em uma thread separada
        new Thread(() -> SpringApplication.run(Launcher.class, args)).start();
        
        // Inicia a interface JavaFX
        Application.launch(SiloMonitorView.class, args);
    }
}

