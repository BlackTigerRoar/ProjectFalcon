
import FalconCore.FalconLogger;
import FalconCore.captains.FlightCaptain;
import org.apache.log4j.Level;
import org.junit.runner.JUnitCore;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import static FalconAPI.android.Android.pilot;
import tests.TestController;

/**
 * Created by ShenYuSun. This is the main runner. Falcon takes off from here!!
 */
public class FalconRunner {

    public static void main(String[] args) throws MalformedURLException
    {

        FalconLogger.log.setLevel(Level.DEBUG);

        try{
            FlightCaptain.createPilot();
            pilot.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            JUnitCore.runClasses(TestController.class);

        }finally {
            FlightCaptain.retirePilot();
        }


    }
}
