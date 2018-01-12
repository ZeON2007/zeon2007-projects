package by.herzhot;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Main extends Application {

    private Animation animation = new Animation(this);
    private double[] payments;
    private double amountBYN = 40000;
    private int years = 15;
    private double refundingRate = 11;

    private Text[] text = new Text[years * 12];

    public Main() {
        for (int i = 0; i < text.length; i++) {
            text[i] = new Text();
            text[i].setLayoutY(50 + i*25);
            text[i].setFill(Color.GREENYELLOW);
            text[i].setTextAlignment(TextAlignment.LEFT);
            text[i].setFont(Font.font(20));
        }
    }

    public static void main1(String[] args) {
        Application.launch(args);
    }

    public double[] getPayments() {
        return payments;
    }

    public Text[] getText() {
        return text;
    }

    public static void main(String[] args) {

        double amountBYN = 50000;
        int years = 15;
        double refundingRate = 11;


        double[] payments = new PaymentCalculator(years * 12, amountBYN, refundingRate).calculatePayments(true);
//        System.out.println("Monthly payment: " + (payments[0] + amountBYN * ((double) 10/((double) 100 * (double) 12))));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group root = new Group();
        Scene scene = new Scene(root, 800, 400, Color.BLACK);
        primaryStage.setScene(scene);

        Button calculateButton = new Button("CALCULATE");

        Label label1 = new Label("AMOUNT: ");
        label1.setTextFill(Color.GREEN);
        label1.setTextAlignment(TextAlignment.CENTER);
        TextField amountValue = new TextField(String.valueOf(amountBYN));
        Label label2 = new Label("YEARS: ");
        label2.setTextFill(Color.GREEN);
        label2.setTextAlignment(TextAlignment.CENTER);
        TextField yearsValue = new TextField(String.valueOf(years));

        HBox hBox = new HBox(calculateButton, label1, amountValue, label2, yearsValue);
        hBox.setSpacing(10);

        root.getChildren().add(hBox);
        root.getChildren().addAll(text);

        calculateButton.setOnAction(event -> {
            amountBYN = Double.valueOf(amountValue.getCharacters().toString());
            System.out.println(amountBYN);
            years = Integer.valueOf(yearsValue.getCharacters().toString());
            System.out.println(years);
            payments = new PaymentCalculator(years * 12, amountBYN, refundingRate).calculatePayments(true);
            text = new Text[years * 12];
            for (int i = 0; i < text.length; i++) {
                text[i] = new Text();
                text[i].setLayoutY(50 + i*25);
                text[i].setFill(Color.GREENYELLOW);
                text[i].setTextAlignment(TextAlignment.LEFT);
                text[i].setFont(Font.font(20));
            }
            root.getChildren().addAll(text);
        });

        animation.start();
        primaryStage.show();
    }
}
