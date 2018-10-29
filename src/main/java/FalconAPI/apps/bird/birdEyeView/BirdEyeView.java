package FalconAPI.apps.bird.birdEyeView;

import FalconAPI.android.Android;
import FalconAPI.interfaces.Activity;
import FalconCore.FalconLogger;

import java.util.NoSuchElementException;

/**
 * Created by ShenYuSun. This BirdEyeView class is the screen we see when user log in to bird app.
 *  This is linked to BirdEyeViewUiObjects class, and then create touch action.
 */
public class BirdEyeView implements Activity {

    public BirdEyeViewUiObjects uiObject = new BirdEyeViewUiObjects();

    public void touchRideButton(){
        try{

            FalconLogger.log.info("Touching on the Ride button");
            uiObject.rideButton().touchIt();

        } catch (NoSuchElementException e){
            // We need to do try and catch here because some times other things may pops up after we touch it.
            // That may or may not block the object.
            throw new AssertionError("Unable to touch Ride button. The object is not there or covered by other things");
        }


    }


    @Override
    public BirdEyeView waitToLoad() {
        try{
            FalconLogger.log.info("Waiting for Bird Eye View activity");
            uiObject.rideButton().waitToShowUp(5);
            return Android.app.bird.birdEyeView;

        } catch (AssertionError e){
            throw new AssertionError("Bird Eye View failed to open or to load.");
        }
    }

    @Override
    public boolean invalidEmailMessage() {
        return false;
    }

    // TODO: We need to implement rest of actions on the home screen. mylocation, how to ride, nearby birds, qa code, and side bar.
}
