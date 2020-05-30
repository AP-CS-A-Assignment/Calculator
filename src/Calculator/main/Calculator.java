package Calculator.main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;

/**
 * A basic Calculator
 */
public class Calculator extends Application {

    /**
     * Launches the program
     * @param args
     */
    public static void main(String[] args) {
        Calculator.launch(args);
    }

    /**
     * Sets up the stage and its parameters
     * @param stage
     */
    private void setUpStage(Stage stage) {
        stage.setTitle("Calculator");
        stage.setOnCloseRequest(event -> Platform.exit());
        stage.show();
    }

    /**
     * Sets up the scene
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {

        setUpStage(stage);
        VBox vBox = new VBox(20);
        vBox.setAlignment(Pos.CENTER);

            HBox inputHBox = new HBox(20);

                TextField first = new TextField();

                TextField second = new TextField();

                Label out = new Label("= ")   ;

            inputHBox.getChildren().addAll(first, second, out);

            HBox buttons = new HBox(10);
            buttons.setAlignment(Pos.CENTER);

                Button mult = new Button("*");
                mult.setOnMouseClicked(event -> onMult(first.getText(), second.getText(), out, stage));

                Button div = new Button("/");
                div.setOnMouseClicked(event -> onDiv(first.getText(), second.getText(), out, stage));

                Button add = new Button("+");
                add.setOnMouseClicked(event -> onAdd(first.getText(), second.getText(), out, stage));

                Button sub = new Button("-");
                sub.setOnMouseClicked(event -> onSub(first.getText(), second.getText(), out, stage));

            buttons.getChildren().addAll(mult, div, add, sub);

        vBox.getChildren().addAll(inputHBox, buttons);


        Scene scene = new Scene(vBox);
        stage.setScene(scene);
    }

    /**
     * Validates that the entered numbers are valid characters
     * @param in1 First String
     * @param in2 Second String
     * @return
     */
    private double[] validate(String in1, String in2) {
        double[] out = new double[2];
        try {
            out[0] = Double.parseDouble(in1);
            out[1] = Double.parseDouble(in2);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please use only numbers");
        }
        return out;
    }

    /**
     * Called when the multiplication button is pressed
     * @param in1 first number string
     * @param in2 second number string
     */
    private void onMult(String in1, String in2, Label out, Stage stage) {
        double[] nums = validate(in1, in2);

        String str = "=" + (nums[0] * nums[1]);

        out.setText(str);
        stage.sizeToScene();
    }

    /**
     * Called when the division button is pressed
     * @param in1 first number string
     * @param in2 second number string
     */
    private void onDiv(String in1, String in2, Label out, Stage stage) {
        double[] nums = validate(in1, in2);

        String str = "=" + (nums[0] / nums[1]);

        out.setText(str);
        stage.sizeToScene();
    }

    /**
     * Called when the addition button is pressed
     * @param in1 first number string
     * @param in2 second number string
     */
    private void onAdd(String in1, String in2, Label out, Stage stage) {
        double[] nums = validate(in1, in2);

        String str = "=" + (nums[0] + nums[1]) ;

        out.setText(str);
        stage.sizeToScene();
    }

    /**
     * Called when the subtraction button is pressed
     * @param in1 first number string
     * @param in2 second number string
     */
    private void onSub(String in1, String in2, Label out, Stage stage) {
        double[] nums = validate(in1, in2);

        String str = "=" + (nums[0] - nums[1]);

        out.setText(str);
        stage.sizeToScene();
    }
}
