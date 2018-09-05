package sample;

import currency.Currency;
import internationalTime.internationalTime;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        Currency currencyObj = new Currency();
        internationalTime intTimeObj = new internationalTime();
        DashboardController dashObj = new DashboardController();

        Timer timer1 = new Timer();
        timer1.schedule(intTimeObj, 0, 1000);

        Timer timer = new Timer();
        timer.schedule(currencyObj, 0, 60000);



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
