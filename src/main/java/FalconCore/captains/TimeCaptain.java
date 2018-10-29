package FalconCore.captains;
import java.util.Date;

/**
 * Created by ShenYuSun - Time function for testing purpose.
 */
public class TimeCaptain {

    public long beginTimeStamp;

    public void begin(){
        beginTimeStamp = getTimeStamp();
    }

    public static long getTimeStamp(){
        return new Date().getTime();

    }

    public boolean expired(int seconds){
        int difference = (int) ((getTimeStamp() - beginTimeStamp / 1000));
        return difference > seconds;
    }




}
