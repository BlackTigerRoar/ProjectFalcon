package FalconAPI.apps.bird.initialScreen;

import FalconCore.UiObject;
import FalconCore.UiSelector;

/**
 * Created by ShenYuSun. This class is going to hold all the initial screen objects.
 */
public class InitialScreenUiObjects {

    private static UiObject
        enterEmail, rideButton, birdLogo, locationPermissionPopUp, denyButton, allowButton, ageAgreement;

    public UiObject rideButton(){
        if (rideButton == null){
            rideButton = new UiSelector().text("RIDE").createiObject();
        }

        return rideButton;
    }

    public UiObject ageAgreement(){
        if (ageAgreement == null){
            ageAgreement = new UiSelector().resourceId("co.bird.android:id/agreementText").createiObject();
        }

        return ageAgreement;
    }

    public UiObject enterEmail(){
        if (enterEmail == null){
            enterEmail = new UiSelector().text("ENTER EMAIL").createiObject();
        }

        return enterEmail;
    }

    public UiObject birdLogo(){
        if (birdLogo == null){
            birdLogo = new UiSelector().resourceId("co.bird.android:id/logoImage").createiObject();
        }

        return birdLogo;
    }

    public UiObject locationPermissionPopUp(){
        if (locationPermissionPopUp == null){
            locationPermissionPopUp = new UiSelector().resourceId("com.android.packageinstaller:id/permission_message").createiObject();
        }

        return locationPermissionPopUp;
    }

    public UiObject allowButton(){
        if (allowButton == null){
            allowButton = new UiSelector().text("ALLOW").createiObject();
        }

        return allowButton;
    }

    // // TODO: We need to add DENY button, and LocationIcon.

}
