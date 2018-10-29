package tests;

import FalconAPI.android.Android;
import FalconAPI.apps.bird.Bird;
import FalconCore.FalconLogger;
import FalconCore.captains.FlightCaptain;
import FalconCore.captains.TestCaptain;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static FalconAPI.android.Android.pilot;

/**
 * Created by ShenYuSun
 */
public class Navigation extends TestCaptain {

    // set up this so we don't have to call Android.app.bird every time.
    // We just need to call bird.
    private static Bird bird = Android.app.bird;

    @BeforeClass
    public static void beforeClass(){
        bird.open();
    }

    @Before
    public void before(){
        testInfo.suite("Navigation");
    }

    @Test
    public void test1(){
        testInfo.id("Test1").name("Verify Bird Intro Screen has all the elements");
        Assert.assertTrue(bird.initialScreen.uiObject.birdLogo().exists());
        Assert.assertTrue(bird.initialScreen.uiObject.enterEmail().exists());
        Assert.assertTrue(bird.initialScreen.uiObject.rideButton().exists());
    }

    @Test
    public void test2(){
        testInfo.suite("Navigation").id("Test2").name("Verify initial age agreement and Privacy Policy, etc. info are presented.");
        bird.initialScreen.touchEnterEmail();
        Assert.assertTrue(bird.initialScreen.uiObject.ageAgreement().exists());
        Assert.assertEquals(bird.initialScreen.uiObject.ageAgreement().getText(),
                "By clicking 'RIDE', I confirm that I'm at least 18 years old, and I agree to Bird's Terms of Service and Privacy Policy");
    }


    @Test
    public void test3(){
        testInfo.id("Test3").name("Verify Rental Agreement check boxes are there.");

        bird.initialScreen.uiObject.enterEmail().touchIt();
        String randomEmail = bird.randomEmail();

        bird.initialScreen.uiObject.enterEmail().typeText(randomEmail);
        bird.initialScreen.touchRideButton();
        bird.initialScreen.touchAllowButton();
        bird.swipeToBottom();
        Assert.assertTrue(bird.rentalAgreementPage.uiObject.agreementCheckBox1().exists());
        Assert.assertTrue(bird.rentalAgreementPage.uiObject.agreementCheckBox2().exists());
        Assert.assertTrue(bird.rentalAgreementPage.uiObject.iAgreeButton().exists());
    }

    @Test
    public void test4(){
        testInfo.id("Test4").name("Verify Rider screen elements are displayed.");

        bird.rentalAgreementPage.touchTopCheckBox();
        bird.rentalAgreementPage.touchBottomCheckBox();
        bird.rentalAgreementPage.touchIagree();

        Assert.assertTrue(bird.birdEyeView.uiObject.howToRide().exists());
        Assert.assertTrue(bird.birdEyeView.uiObject.myLocation().exists());
        Assert.assertTrue(bird.birdEyeView.uiObject.nearByBirds().exists());
        Assert.assertTrue(bird.birdEyeView.uiObject.rideButton().exists());
        Assert.assertTrue(bird.birdEyeView.uiObject.scanButton().exists());
        Assert.assertTrue(bird.birdEyeView.uiObject.sideBar().exists());

    }


    @Test
    public void test5() throws MalformedURLException {
        testInfo.id("Test5").name("Verify Invalid Email message show up.");
        FlightCaptain.retirePilot();
        FlightCaptain.createPilot();
        pilot.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        bird.initialScreen.touchEnterEmail();
        bird.initialScreen.uiObject.enterEmail().typeText("badbad");
        Android.pilot.hideKeyboard();

        try {
            Thread.sleep(5000);
            Android.adb.captureScreenShot();
        } catch(Exception e){
            FalconLogger.log.error(e.getMessage());
        }

        boolean returnValue = false;

        File imageFile = new File("./Bird_UI_Viewer/TempScreenShot.png");
        ITesseract instance = new Tesseract();
        instance.setDatapath("./src/main/java");
        instance.setLanguage("eng");


        try{
            String result = instance.doOCR(imageFile);
            FalconLogger.log.debug("The OCR result is: " + result);
            FalconLogger.log.info("The words on the pic are: /n" + result);
            if (result.contains("Invalid email. Please try again.")){
                FalconLogger.log.info("Caught Invalid email message!");
                returnValue = true;
            }else{
                returnValue = false;
            }
        }catch(TesseractException e){
            FalconLogger.log.error(e.getMessage());
        }

        Assert.assertEquals(true, returnValue);

    }


}
