package internationalTime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.TimerTask;

public class internationalTime extends TimerTask {

    private static String shanghaiTime,nycTime,londonTime,sydneyTime,johannesburgTime;

    @Override
    public void run() {
        getCurrentShanghaiTime();
        getCurrentNycTime();
        getCurrentLondonTime();
        getCurrentSydneyTime();
        getCurrentJohannesburgTime();

    }

    //Get times of countries with major markets

    private void getCurrentShanghaiTime(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        setShanghaiTime(simpleDateFormat.format(date));

    }

    private void getCurrentNycTime(){

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        setNycTime(simpleDateFormat.format(date));

    }

    private void getCurrentLondonTime(){

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/London"));
        setLondonTime(simpleDateFormat.format(date));

    }

   private void getCurrentSydneyTime(){

       Date date = new Date();
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
       simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Australia/Sydney"));
       setSydneyTime(simpleDateFormat.format(date));

    }

   private void getCurrentJohannesburgTime(){

       Date date = new Date();
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
       simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Africa/Johannesburg"));
       setJoburgTime(simpleDateFormat.format(date));

    }


    //Getters and setters
    public String getShanghaiTime() {
        return shanghaiTime;
    }

    private void setShanghaiTime(String shanghaiTime) {
        this.shanghaiTime = shanghaiTime;
    }

    public String getNycTime() {
        return nycTime;
    }

    private void setNycTime(String nycTime) {
        this.nycTime = nycTime;
    }

    public String getLondonTime() {
        return londonTime;
    }

    private void setLondonTime(String londonTime) {
        this.londonTime = londonTime;
    }

    public String getSydneyTime() {
        return sydneyTime;
    }

    private void setSydneyTime(String sydneyTime) {
        this.sydneyTime = sydneyTime;
    }

    public String getJoburgTime() {
        return johannesburgTime;
    }

    private void setJoburgTime(String joburgTime) {
        this.johannesburgTime = joburgTime;
    }
}
