package com.silo.monitoring.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SiloMonitorView extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Monitoramento de Silo");
        
        BorderPane root = new BorderPane();
        Canvas canvas = new Canvas(900, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        drawBackground(gc);
        drawSilo(gc);
        drawTopView(gc);
        drawTemperatureScale(gc);
        
        // Botões de navegação
        Button prevButton = new Button("<<");
        Button nextButton = new Button(">>");
        HBox buttonBox = new HBox(10, prevButton, nextButton);
        root.setBottom(buttonBox);
        
        root.setCenter(canvas);
        Scene scene = new Scene(root, 900, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void drawBackground(GraphicsContext gc) {
        gc.setFill(Color.DARKSLATEGRAY);
        gc.fillRect(0, 0, 900, 600);
    }
    
    private void drawSilo(GraphicsContext gc) {
        // Base do silo
        gc.setFill(Color.BROWN);
        gc.fillRect(150, 450, 500, 50);
        
        // Estrutura do silo (trapézio reto)
        gc.setFill(Color.LIGHTGREEN);
        gc.fillPolygon(new double[]{200, 450, 550, 800}, new double[]{450, 150, 150, 450}, 4);
        
        // Linhas divisórias do silo
        gc.setStroke(Color.WHITE);
        gc.setFont(new Font(16));
        gc.strokeText("1", 480, 120);
        gc.strokeText("2", 260, 300);
        gc.strokeText("4", 680, 300);
        gc.setStroke(Color.DARKGRAY);
        gc.strokeLine(350, 170, 350, 450);
        gc.strokeLine(650, 170, 650, 450);
        
        // Sensores
        gc.setFill(Color.RED);
        for (int i = 0; i < 4; i++) {
            gc.fillOval(330 + (i * 100), 200, 10, 10);
            gc.fillOval(330 + (i * 100), 280, 10, 10);
            gc.fillOval(330 + (i * 100), 360, 10, 10);
        }
    }
    
    private void drawTopView(GraphicsContext gc) {
        // Vista superior do silo
        gc.setFill(Color.LIGHTGRAY);
        gc.fillOval(700, 170, 140, 140);
        
        // Linhas divisórias
        gc.setStroke(Color.DARKGRAY);
        gc.strokeLine(770, 170, 770, 310);
        gc.strokeLine(700, 240, 840, 240);
        
        // Sensores
        gc.setFill(Color.RED);
        gc.fillOval(760, 190, 10, 10);
        gc.fillOval(780, 190, 10, 10);
        gc.fillOval(760, 280, 10, 10);
        gc.fillOval(780, 280, 10, 10);
    }
    
    private void drawTemperatureScale(GraphicsContext gc) {
        int x = 860, y = 150, width = 20, height = 300;
        
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
