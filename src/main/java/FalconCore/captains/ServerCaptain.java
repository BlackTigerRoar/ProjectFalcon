package FalconCore.captains;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by ShenYuSun
 *
 * This class show you about the server that's running the automation
 */
public class ServerCaptain {

    private static String OS;
    private static String ANDROID_HOME;

    public static String getOS(){
        if(OS == null)
            OS = System.getenv("os.name");

        return OS;
    }

    public static boolean isWindows(){
        return getOS().startsWith("Windows");
    }

    public static boolean isMacOS(){
        return getOS().startsWith("Mac");
    }

    public static String getAndroidHome(){
        if(ANDROID_HOME == null){
            ANDROID_HOME = "/Users/ShenYuSun/Library/Android/sdk";   //System.getenv("ANDROID_HOME)");
            if(ANDROID_HOME == null)
                throw new RuntimeException("Please set ANDROID_HOME. If you are on mac: make sure you do 'launchctl set'" +
                "env ANDROID_HOME $YOUR_Variable - You need to re-launch your application");
        }

        return ANDROID_HOME;
    }

    public static String exectuCommand(String command){
        String result = null;

        try{
            Scanner scanner = new Scanner(Runtime.getRuntime().exec(command).getInputStream()).useDelimiter("\\A");
            if (scanner.hasNext())
                result = scanner.next();
        }catch(IOException e){
            throw new RuntimeException(e.getMessage());
        }

        return result;
    }
}
