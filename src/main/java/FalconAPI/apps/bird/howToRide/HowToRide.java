package FalconAPI.apps.bird.howToRide;

import FalconAPI.android.Android;
import FalconAPI.apps.bird.birdEyeView.BirdEyeView;
import FalconAPI.interfaces.Activity;
import FalconCore.FalconLogger;

import java.util.NoSuchElementException;

/**
 * Created by ShenYuSun. This HowToRide class is the screen we see when user click How To Ride button.
 *  This is linked to HowToRideUiObjects class, and then create touch action.
 *  This one implement Activity interface to wait for the objecet to show up.
 */
public class HowToRide implements Activity {


    public HowToRideUiObjects uiObject = new HowToRideUiObjects();

    @Override
    public HowToRide waitToLoad() {
        try{
            FalconLogger.log.info("Waiting for How To Ride screen activity...");
            uiObject.backButton().waitToShowUp(5);
            return Android.app.bird.howToRide;

        } catch(AssertionError e){
            throw new AssertionError("How to Ride activity failed to open or to load");
        }
    }

    @Override
    public boolean invalidEmailMessage() {
        return false;
    }


    public BirdEyeView touchBackButton(){
        try{
            FalconLogger.log.info("Touching Back Arrow button");
            uiObject.backButton().touchIt();
            Android.app.bird.birdEyeView.uiObject.rideButton().waitToShowUp(5);
            return Android.app.bird.birdEyeView;

        } catch(NoSuchElementException e) {
            throw new AssertionError("Unable to find Back Arrow button. It is not there or covered by other objects");
        } catch (AssertionError e){
            throw new AssertionError("Back Arrow button failed to return to Bird Eye View within 5 seconds");
        }


    }

}
