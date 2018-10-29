package FalconAPI.apps.bird.howToRide;

import FalconCore.UiObject;
import FalconCore.UiSelector;

/**
 * Created by ShenYuSun. This class is going to hold all the how to ride ui objects.
 */
public class HowToRideUiObjects {

    private static UiObject
        backButton,
        nextButton;
    // TODO: Add more UI objects from "How to Ride" screen.

    public UiObject backButton(){
        if (backButton == null){
            backButton = new UiSelector().className("android.widget.ImageButton").createiObject();
        }
        return backButton;
    }

    public UiObject nextButton(){
        if (nextButton == null)
            nextButton = new UiSelector().text("NEXT").createiObject();

        return nextButton;
    }
}
