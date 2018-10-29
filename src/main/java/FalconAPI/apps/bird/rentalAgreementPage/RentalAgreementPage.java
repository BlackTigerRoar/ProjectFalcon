package FalconAPI.apps.bird.rentalAgreementPage;

import FalconAPI.android.Android;
import FalconAPI.interfaces.Activity;
import FalconCore.FalconLogger;

import java.util.NoSuchElementException;

/**
 * Created by ShenYuSun. This RentalAgreementPage class is the screen when
 * user clicks "ALLOW" at location permission dialog.
 *  This is linked to RentalAgreementPageUiObjects class, and then create touch action.
 *  This one implement Activity interface to wait for the objecet to show up.
 */
public class RentalAgreementPage {

    public RentalAgreementPageUiObjects uiObject = new RentalAgreementPageUiObjects();

    public void touchTopCheckBox(){
        try{
            FalconLogger.log.info("Touching Top Check Box ->I certify that I have read.....");
            uiObject.agreementCheckBox1().touchIt();
        }catch (NoSuchElementException e){
            throw new AssertionError("Unable to touch Top Check box. The object is not there or covered by other things");
        }
    }

    public void touchBottomCheckBox(){
        try{
            FalconLogger.log.info("Touching Top Check Box ->I certify that I am the Rider....");
            uiObject.agreementCheckBox2().touchIt();
        }catch (NoSuchElementException e){
            throw new AssertionError("Unable to touch Bottom Check box. The object is not there or covered by other things");
        }
    }

    public void touchIagree(){
        try{
            FalconLogger.log.info("Touching I Agree button");
            uiObject.iAgreeButton().touchIt();
        }catch (NoSuchElementException e){
            throw new AssertionError("Unable to touch I Agree button. The object is not there or covered by other things");
        }
    }


}
