package FalconAPI.apps.bird;

import FalconAPI.android.Android;
import FalconAPI.apps.bird.howToRide.HowToRide;
import FalconAPI.apps.bird.birdEyeView.BirdEyeView;
import FalconAPI.apps.bird.initialScreen.InitialScreen;
import FalconAPI.apps.bird.rentalAgreementPage.RentalAgreementPage;
import FalconAPI.apps.bird.sideBar.SideBar;
import FalconAPI.interfaces.Activity;
import FalconAPI.interfaces.Application;
import FalconCore.FalconLogger;
import io.appium.java_client.TouchAction;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.xpath.operations.And;
import org.openqa.selenium.Dimension;

import java.io.File;
import java.util.Random;

import static FalconAPI.android.Android.pilot;

/**
 * Created by ShenYuSun. bird is going to implements Application interface to get the methods, and then define them.
 */
public class Bird implements Application,Activity{

    // Add Menu package item in to bird class.
    public BirdEyeView birdEyeView = new BirdEyeView();
    public SideBar sideBar = new SideBar();

    @Override
    public Object waitToLoad() {
        //todo For future purpose.
        return null;
    }

    @Override
    public boolean invalidEmailMessage() {
        File imageFile = new File("./Bird_UI_Viewer/TempScreenShot.png");
        ITesseract instance = new Tesseract();
        instance.setDatapath("./src/main/java");
        instance.setLanguage("eng");

        try {
            Thread.sleep(5000);
            Android.adb.captureScreenShot();
        } catch(Exception e){
            FalconLogger.log.error(e.getMessage());
        }

        try{
            String result = instance.doOCR(imageFile);
            FalconLogger.log.info("The OCR result is: " + result);

            if (result.contains("Invalid email. Please try again.")){
                return true;
            }else{
                return false;
            }
        }catch(TesseractException e){
            System.err.println(e.getMessage());
        }
        return false;
    }

    public HowToRide howToRide = new HowToRide();
    public InitialScreen initialScreen = new InitialScreen();
    public RentalAgreementPage rentalAgreementPage = new RentalAgreementPage();

    @Override
    public String packageId() {
        return "co.bird.android";
    }

    @Override
    public String activityID() {
        return "co.bird.android.app.feature.main.MainActivity";
    }

    @Override
    public void clearData() {
        Android.adb.clearAppData(packageId());
    }

    @Override
    public Object open() {
        Android.adb.openAppsActivity(packageId(), activityID());
        return null;
    }

    @Override
    public String randomEmail() {

        // Generate a random email value for testing purpose. Avoid verify email triggers.
        String characters ="abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder buildString = new StringBuilder();
        Random rnd = new Random();
        while(buildString.length() < 10){
            int index = (int) (rnd.nextFloat() * characters.length());
            buildString.append(characters.charAt(index));
        }
        String randomString = buildString.toString();
        String randomEmail = randomString + "@gmail.com";

        return randomEmail;

    }

    @Override
    public void swipeToBottom() {
        // TODO: Currently, Appium did not have stable method for scrolling. A lot of Swipe methods are depreciated.
        // We need to design or waiting for newer Appium to support scroll future.
        // Another solution would be let development team add text-description attribute, and then we can use ScrollTo method
        // provided by Appium to scroll to text-description.
        try{
            Dimension size = pilot.manage().window().getSize();
            int startY = (int) (size.height * 0.80);
            int endY = (int) (size.height * 0.20);
            int x = size.width/2;
            FalconLogger.log.debug("The Swipe action coordinates : " + x + " " + startY + " " + endY);

            for (int i = 1; i <= 2; i++){
                Thread.sleep(15000);
                new TouchAction(pilot).press(x, startY).moveTo(x, endY).release().perform();
                //Thread.sleep(10000);
                //new TouchAction(pilot).press(x, startY).moveTo(x, endY).release().perform();
                //Thread.sleep(5000);
            }

        }catch(Exception e){
            System.out.println("Touch actions did not perform correctly. The calc of the screen size may be inaccurate.");
        }
    }

    @Override
    public void takeScreenShot() {
        Android.adb.takeScreenShot();
    }

    // TODO: We can add more method in Application interface, and then implement more if we need.
}
