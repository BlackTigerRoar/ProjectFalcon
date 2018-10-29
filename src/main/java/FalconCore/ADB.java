package FalconCore;


import FalconCore.captains.ServerCaptain;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static FalconAPI.android.Android.pilot;

/**
 * Created by ShenYuSun.
 *
 *  Useful command to find package, and activity:
 " adb shell dumpsys window windows | grep Focus"
 *
 * use ADB to launch app
 * adb shell am start -c api.android.intent.LAUNCHER -a api.android.category.MAIN -n packageName/Activity
 *
 * Use logcat to catch log and trouble shooting
 * adb logcat -d (-d is currently in the memory. without d, it'll keep going)
 *
 * Screenshot
 * adb shell screencap /sdcard/Android/screenshot.png
 *
 * Browse file
 * adb shell
 *
 * Force stop
 * adb shell am force-stop package name
 *
 * Wipe cache, data
 * adb shell pm clear package name
 *
 * Send Key Event
 * adb shell input text "type word"
 *
 * adb shell input keyevent 4
 *
 * return hashmap with properties of the devices
 * adb shell getprop yourKey
 */


public class ADB {


    public String Id;

    // This constructor public method is helpful for because we can access device id without instantiate new adb.
    public ADB(String deviceId){
        Id = deviceId;
    }


    public static String command(String command){
        // Doing this way so we don't have to add Logger at the every single method.
        FalconLogger.log.debug("Generating ADB Command: " + command);

        if (command.startsWith("adb"))
            command = command.replace("adb", ServerCaptain.getAndroidHome()+"/platform-tools/adb ");
        else
            throw new RuntimeException("Falcon: I can only run ADB commands!");

        FalconLogger.log.debug("Generating ADB command: " + command);

        String result = ServerCaptain.exectuCommand(command);

        FalconLogger.log.debug("Result of ADB command: " + result);

        if(result == null)
            return "";
        else
            return result;
    }


    public static void killServer(){
        command("adb kill-server");
    }

    public static void startServer(){
        command("adb start-server");
    }

    // Clear app data
    public void clearAppData(String packageId){
        FalconLogger.log.info("Clean up data for the next test");
        command("adb -s " + Id + " shell pm clear " +packageId);
    }


    // This method trim down the "adb devices" output, and then only store connected device ID.
    public static ArrayList getConnectedDevices(){
        ArrayList devices = new ArrayList();
        String result = command("adb devices");
        for (String row : result.split("\n")){
            row = row.trim();
            if (row.endsWith("device"))
                devices.add(row.replace("device", "").trim());
        }
        return devices;

    }

    // Get all the installed packagese from the devices.
    // Save those into an array, and return it.
    public ArrayList getInstalledPackages(){
        ArrayList packages = new ArrayList();
        String [] result = command("adb -s " + Id + " shell pm list packages").split("\n");

        for (String packageID : result){
            packages.add(packageID.replace("package:","").trim());
        }

        return packages;
    }

    // open Apps activity by package id and activity id
    public void openAppsActivity(String packageID, String activityID){
        command("adb -s " + Id + " shell am start -c api.android.intent.category.LAUNCHER -a api.android.intent.action.MAIN -n " +
        packageID + "/" + activityID);
    }

    // Take a screen shot on the current screen
    public void takeScreenShot(){
        command("adb exec-out screencap -p > InvalidEmailScreenShot.png");
    }

    public void captureScreenShot() throws IOException{
        File f=((TakesScreenshot)pilot).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(f, new File("./Bird_UI_Viewer/TempScreenShot.png"));
    }
    // TODO:
    /* We can add more ADB command in here. Basically it is going to be a tons of public void method so we can call it.
    *  such as
    *  public void forceStepApp(), getAndroidVersion(), pushFile(), pullFile(), etc.
    *  This is part of the framework that is going to be very useful in the future.
    * */
}
