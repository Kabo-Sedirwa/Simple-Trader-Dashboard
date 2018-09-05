package currency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.TimerTask;
import java.net.URL;
import org.json.*;

public class Currency extends TimerTask  {

    //Euro based currency pairs
    private static double EURUSD;
    private static double EURCAD;


    @Override
    public void run() {
        pullEuroPairs();
        System.out.println("Pulling Currencies every minute "+getEURCAD()+" "+getEURUSD());
    }

    private void pullEuroPairs(){

        try {
            URL url = new URL("http://data.fixer.io/api/latest?access_key=5bc175e4affec44777c4c7ad902cff9c");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));

            String inputLine;

            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);

                JSONObject myResponse = new JSONObject(response.toString());

                double EURCAD_value  = (double) myResponse.getJSONObject("rates").get("CAD");
                setEURCAD(EURCAD_value);

                double EURUSD_value  = (double) myResponse.getJSONObject("rates").get("USD");
                setEURUSD(EURUSD_value);
            }
            in.close();
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static double getEURUSD() {
        return EURUSD;
    }

    private void setEURUSD(double EURUSD) {
        this.EURUSD = EURUSD;
    }

    public static  double getEURCAD() {
        return EURCAD;
    }

    private void setEURCAD(double EURCAD) {
        this.EURCAD = EURCAD;
    }
}
