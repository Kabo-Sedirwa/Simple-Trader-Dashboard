package sample;

import currency.Currency;
import internationalTime.internationalTime;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Timer;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        Currency currencyObj = new Currency();
        internationalTime intTimeObj = new internationalTime();

        //Get instance every 10th of a second.(This is for the clocks on the dashboard to be updated)
        Timer timer1 = new Timer();
        timer1.schedule(intTimeObj, 0, 100);

        //Get the EUR based pairs every hour
        Timer timer = new Timer();
        timer.schedule(currencyObj, 0, 3600000);



        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        root.getStylesheets().add("/sample/bse.css");
        primaryStage.setTitle("BSE");
        primaryStage.setScene(new Scene(root));
        primaryStage.setMaximized(true);
        primaryStage.show();

    }


    public static void main(String[] args) {


        launch(args);

    }
}
