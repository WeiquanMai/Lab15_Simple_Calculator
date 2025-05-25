/*
CSC-239 JAVA
Project Name: Simple Calculator
Student: Weiquan Mai
Date: April 14, 2025
Description: This project utilizes JavaFX to display a simple calculator on the screen that supports the add, subtract, multiply, and divide functions.
*/

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SimpleCalculator extends Application {
    private TextField tfNumber1 = new TextField();
    private TextField tfNumber2 = new TextField();
    private TextField tfResult = new TextField();
    private Button btAdd = new Button("Add");
    private Button btSubtract = new Button("Subtract");
    private Button btMultiply = new Button("Multiply");
    private Button btDivide = new Button("Divide");

    @Override
    public void start(Stage primaryStage){
        // Create a border pane
        BorderPane bPane = new BorderPane();

        // Create a flow pane
        FlowPane fPane = new FlowPane();
        fPane.setPadding(new Insets(10));
        fPane.setHgap(5);
        fPane.setVgap(5);

        // Place nodes inside of flow pane
        tfNumber1.setPrefColumnCount(3);
        tfNumber2.setPrefColumnCount(3);
        tfResult.setEditable(false);
        fPane.getChildren().addAll(new Label("Number 1:"), tfNumber1,
        new Label("Number 2:"), tfNumber2, new Label ("Result: "), tfResult);

        // Create HBox and add buttons into HBox
        HBox hbox1 = new HBox(10, btAdd, btSubtract, btMultiply, btDivide);
        hbox1.setAlignment(Pos.CENTER);
        hbox1.setPadding(new Insets(0,0,10,0));

        // Add flow pane and HBox into BorderPane
        bPane.setCenter(fPane);
        bPane.setBottom(hbox1);

        //Set handlers for action events
        btAdd.setOnAction((ActionEvent e) ->{
            double a = Double.parseDouble(tfNumber1.getText());
            double b = Double.parseDouble(tfNumber2.getText());
            tfResult.setText(String.format("%.2f",a+b));
        });
        btSubtract.setOnAction((ActionEvent e) ->{
            double a = Double.parseDouble(tfNumber1.getText());
            double b = Double.parseDouble(tfNumber2.getText());
            tfResult.setText(String.format("%.2f",a-b));
        });
        btMultiply.setOnAction((ActionEvent e) ->{
            double a = Double.parseDouble(tfNumber1.getText());
            double b = Double.parseDouble(tfNumber2.getText());
            tfResult.setText(String.format("%.2f",a*b));
        });
        btDivide.setOnAction((ActionEvent e) ->{
            double a = Double.parseDouble(tfNumber1.getText());
            double b = Double.parseDouble(tfNumber2.getText());
            tfResult.setText(String.format("%.2f",a/b));
        });

        // Create a scene and place it on the stage
        Scene scene = new Scene(bPane,550,100);
        primaryStage.setTitle("Lab15a");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args){
        launch(args);
    }
}
    
