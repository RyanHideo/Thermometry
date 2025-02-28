package com.silo.monitoring.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SiloMonitorView extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Monitoramento de Silo");
        
        BorderPane root = new BorderPane();
        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        drawSilo(gc);
        drawTemperatureScale(gc);
        
        // Botões de navegação
        Button prevButton = new Button("<<");
        Button nextButton = new Button(">>");
        HBox buttonBox = new HBox(10, prevButton, nextButton);
        root.setBottom(buttonBox);
        
        root.setCenter(canvas);
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void drawSilo(GraphicsContext gc) {
        // Fundo
        gc.setFill(Color.DARKGREEN);
        gc.fillRect(0, 0, 800, 600);
        
        // Corpo do silo
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(200, 100, 400, 400);
        
        // Temperatura simulada (amostra)
        gc.setFill(Color.YELLOW);
        gc.fillRect(220, 120, 360, 360);
    }
    
    private void drawTemperatureScale(GraphicsContext gc) {
        int x = 650, y = 100, width = 20, height = 400;
        
        for (int i = 0; i < height; i++) {
            double ratio = (double) i / height;
            gc.setFill(Color.hsb((1 - ratio) * 240, 1.0, 1.0));
            gc.fillRect(x, y + i, width, 1);
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
