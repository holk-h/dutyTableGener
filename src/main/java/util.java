import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class util {
    public static int getWeek(String dates)
    {

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        Date d=null;
        try {
            d=f.parse(dates);
        } catch (ParseException e) {

            e.printStackTrace();
        }
        assert d != null;
        cal.setTime(d);
        int w=cal.get(Calendar.DAY_OF_WEEK)-1;
        if(w==0) w=7;
        return w;
    }

    public static void main(String[] args) {
    }
}
