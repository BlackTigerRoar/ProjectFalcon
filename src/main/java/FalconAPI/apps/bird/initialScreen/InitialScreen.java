package FalconAPI.apps.bird.initialScreen;

import FalconAPI.android.Android;
import FalconAPI.apps.bird.birdEyeView.BirdEyeView;
import FalconAPI.apps.bird.rentalAgreementPage.RentalAgreementPage;
import FalconAPI.interfaces.Activity;
import FalconCore.FalconLogger;

import java.util.NoSuchElementException;

/**
 * Created by ShenYuSun. This InitialScreen class is the screen we see when user first open Bird.
 *  This is linked to InitialScreenUiObject class, and then create touch action.
 */
public class InitialScreen {


    public InitialScreenUiObjects uiObject = new InitialScreenUiObjects();

    public InitialScreen touchRideButton(){
        try{
            FalconLogger.log.debug("Touching Ride Button");
            uiObject.rideButton().touchIt();
            return this;

        } catch(NoSuchElementException e) {
            throw new AssertionError("Unable to find Ride Button. It is not there or covered by other objects");
        } catch (AssertionError e){
            throw new AssertionError("Ride button failed to return to Bird Eye View within 5 seconds");
        }

    }

    public InitialScreen touchEnterEmail() {
        try {
            FalconLogger.log.debug("Touching ENTER EMAIL");
            uiObject.enterEmail().touchIt();
            return this;
        } catch (NoSuchElementException e) {
            throw new AssertionError("Unable to find Ride Button. It is not there or covered by other objects");
        }
    }

    public InitialScreen touchAllowButton(){
        try {
            FalconLogger.log.debug("Touching Location ALLOW button");
            uiObject.allowButton().touchIt();
            //Android.app.bird.rentalAgreementPage.uiObject.rentalAgreement().waitToShowUp(10);
            return this;

        } catch (NoSuchElementException e) {
            throw new AssertionError("Unable to find ALLOW button. It is not there or covered by other objects");
        }
    }



    // // TODO: We need to add DENY button, and LocationIcon.
}
