package FalconAPI.apps.bird.rentalAgreementPage;

import FalconCore.UiObject;
import FalconCore.UiSelector;

/**
 * Created by ShenYuSun. This class is going to hold all the RentalAgreementPage ui objects.
 */
public class RentalAgreementPageUiObjects {

    private static UiObject
        agreementCheckBox1,
        agreementCheckBox2,
        iAgreeButton,
        rentalAgreement,
        backButton;

    public UiObject agreementCheckBox1(){
        if (agreementCheckBox1 == null){
            agreementCheckBox1 = new UiSelector().resourceId("agreement_checkbox_section15").createiObject();
        }
        return agreementCheckBox1;
    }

    public UiObject agreementCheckBox2(){
        if (agreementCheckBox2 == null){
            agreementCheckBox2 = new UiSelector().resourceId("agreement_checkbox_under_18").createiObject();
        }
        return agreementCheckBox2;
    }

    public UiObject iAgreeButton(){
        if (iAgreeButton == null){
            iAgreeButton = new UiSelector().text("I AGREE").createiObject();
        }
        return iAgreeButton;
    }

    public UiObject rentalAgreement(){
        if (rentalAgreement == null){
            rentalAgreement = new UiSelector().text("Rental Agreement").createiObject();
        }
        return rentalAgreement;
    }

    // TODO: Need to implement back arrow button.
}
