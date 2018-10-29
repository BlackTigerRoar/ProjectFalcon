package FalconCore.captains;

import FalconAPI.android.Android;
import FalconCore.ADB;
import FalconCore.FalconLogger;
import com.sun.xml.internal.bind.v2.TODO;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ShenYuSun  - CHECK line 49 FUNCTION FOR SERVER INFO.
 */
public class FlightCaptain {

    //// TODO: Add funtionality to launch test suite without manually launch Appium server.
    // Create a hashmap to hosts String and URL.

    private static HashMap<String, URL> hosts;
    // This is use for checking if device is ready for testing. If appium unlock app is there, then we know that
    // the device has been or ready to be tested.
    private static String appiumUnlockApp = "io.appium.unlock";

    private static DesiredCapabilities getCapabilities(String deviceID){
        FalconLogger.log.info("Generating Pilot capabilities for device: " + deviceID);

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceID);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        //desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "co.bird.android");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".app.feature.main.MainActivity");

        return desiredCapabilities;
    }

    // Here we can add more devices we want to test.
    // We can add soemthing like:
    // hosts.put("Another Device ID", new URL("http://localhost:4723/wd/hub"));
    // If we want to test all the devices together, then we can change the Appium port to something like:
    // hosts.put("Another Device ID", new URL("http://127.0.0.2:4723/wd/hub")); base on our appium server.
    private static URL host(String deviceID) throws MalformedURLException{
        if(hosts == null){
            hosts = new HashMap<>();
            hosts.put("ce08171843b39b17057e", new URL("http://localhost:4723/wd/hub"));
            // Running more device and at parallel example:
            hosts.put("Another Device ID", new URL("http://127.0.0.2:5555"));
            hosts.put("Another Device ID", new URL("http://127.0.0.3:6666"));
        }

        return hosts.get(deviceID);
    }


    private static ArrayList<String> getAvailableDevicesForTests(){
        FalconLogger.log.info("Checking Devices Availability");

        // Create array for available device and connected devices.
        ArrayList<String> availableDevices = new ArrayList<>();
        ArrayList<String> connectedDevices = ADB.getConnectedDevices();

        for (Object connectedDevice: connectedDevices){
            String device = connectedDevice.toString();
            ArrayList apps = new ADB(device).getInstalledPackages();
            if (apps.contains(appiumUnlockApp))
                availableDevices.add(device);
            else
                FalconLogger.log.info("Device: " + device + "don't have " + appiumUnlockApp + " already. It has not been tested");
        }

        if (availableDevices.size() == 0)
            throw new RuntimeException("There is no device is available for testing....");

        return availableDevices;
    }


    public static void createPilot() throws MalformedURLException {
        ArrayList<String> devices = getAvailableDevicesForTests();

        try {

            for (String device : devices) {
                FalconLogger.log.info("Let's try to create new Pilot for device: " + device);

                Android.pilot = new AndroidDriver(host(device), getCapabilities(device));
                Android.adb = new ADB(device);
                break;
            }

        } catch (Exception e){
            // If something happend, then print out stack trace, and then move to the next device.
            e.printStackTrace();
        }

    }

    // At the end of the test, if pilot is not null, then we need to retire the pilot to bring the device to
    // beginning test state. I don't have apk file, so I don't need to uninstall the package.
    // If test is invovled with apk, then we need to uninstall the package. We can also uninstall unlock package.

    public static void retirePilot(){
        if (Android.pilot != null){
            FalconLogger.log.info("Retiring Android Pilot");

            Android.pilot.quit();
            // TODO: we can uninstall package here. However, ADB class needs to have unisntallPackage method.
        }
        else
            FalconLogger.log.info("Android Pilot is not on duty. No Pilot to be retired.");

    }


}


