package FalconAPI.apps.bird.birdEyeView;

import FalconCore.UiObject;
import FalconCore.UiSelector;

/**
 * Created by ShenYuSun. This class is going to hold all the bird eye view objects.
 */
public class BirdEyeViewUiObjects {

    private static UiObject
            ride, myLocation, howToRide, nearByBirds, scanButton, sideBar;


    public UiObject rideButton(){
        if (ride == null){
            ride = new UiSelector().text("RIDE").createiObject();
        }

        return ride;
    }

    public UiObject myLocation(){
        if (myLocation == null){
            myLocation = new UiSelector().resourceId("co.bird.android:id/myLocationButton").createiObject();
        }

        return myLocation;
    }

    public UiObject howToRide(){
        if (howToRide == null){
            howToRide = new UiSelector().text("HOW TO RIDE").createiObject();
        }

        return howToRide;
    }

    public UiObject nearByBirds(){
        if (nearByBirds == null){
            nearByBirds = new UiSelector().text("Nearby Birds").createiObject();
        }

        return nearByBirds;
    }

    public UiObject scanButton(){
        if (scanButton == null){
            scanButton = new UiSelector().resourceId("co.bird.android:id/scanButton").createiObject();
        }

        return scanButton;
    }

    public UiObject sideBar(){
        if (sideBar == null){
            sideBar = new UiSelector().className("android.widget.ImageButton").createiObject();
        }

        return sideBar;
    }
}
