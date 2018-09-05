package sample;

import currency.Currency;
import internationalTime.internationalTime;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;


public class DashboardController implements Initializable{

    @FXML
    public Label EURUSD_label,EURCAD_Label,nycTime,londonTime,beijingTime,sydneyTime,joburgTime;

    @FXML
    private AnchorPane currencyPanel,botswanaCompaniesPanel,usdPanel,euroPanel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // task to run goes here
                updateEuroLabels();
                updateTimeLabels();
            }
        };
        Timer timer = new Timer();

        // schedules the task to be run in an 10th of a second interval
        timer.scheduleAtFixedRate(task, 0,100);
    }



    public void showCurrenciesPane(){

        currencyPanel.toFront();
    }

    public void showBotswanaCompaniesPane(){

        botswanaCompaniesPanel.toFront();
    }

    //Currency navigation panel buttons

    public void showUSD(){

        usdPanel.toFront();

    }

    public void showEuro(){

        euroPanel.toFront();
    }


    private void updateEuroLabels(){

        Platform.runLater(()-> {

            String EURCAD_labelText = Double.toString(Currency.getEURCAD());

            EURCAD_Label.setText(EURCAD_labelText);

            String EURUSD_labelText = Double.toString(Currency.getEURUSD());

            EURUSD_label.setText(EURUSD_labelText);

        });
    }

    private void updateTimeLabels(){

        Platform.runLater(()-> {

            internationalTime intTimeObj = new internationalTime();

                nycTime.setText(intTimeObj.getNycTime());
                londonTime.setText(intTimeObj.getLondonTime());
                beijingTime.setText(intTimeObj.getShanghaiTime());
                sydneyTime.setText(intTimeObj.getSydneyTime());
                joburgTime.setText(intTimeObj.getJoburgTime());

        });
    }
}