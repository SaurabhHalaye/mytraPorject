package utils;

import Pages.Basepage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateNTime extends Basepage {

    public boolean getTodayDay() {
        boolean result = false;
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String todaysDay = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
        System.out.println("Todays day : " + todaysDay);
        if (todaysDay.equalsIgnoreCase("Saturday") || todaysDay.equalsIgnoreCase("Sunday")) {
            result = false;
        }
        else
        {
            result = true;
        }
        return  result;
    }

    public int getCurrentTime(){
        Calendar calendar = new GregorianCalendar();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if(hour == 00){
            hour = hour + 1;
        }
        int minute = calendar.get(Calendar.MINUTE);
        String currentime = "";
        if (minute<10){
            currentime = hour + "0" +minute;
        }
        else {
            currentime = hour +""+ minute;
        }
        int currentTime = Integer.parseInt(currentime);
        return currentTime;
    }
}
