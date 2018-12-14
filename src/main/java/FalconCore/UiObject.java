package FalconCore;

import FalconCore.captains.TimeCaptain;
import org.openqa.selenium.*;
import java.util.NoSuchElementException;

import static FalconAPI.android.Android.pilot;

/**
 * Created by ShenYuSun
 */
public class UiObject {

    private String pointer;



    UiObject(String pointer){
        this.pointer = pointer;
        //System.out.println(this.pointer);

    }

    // We need a class to define if it's xPath or not
    private boolean isXpath(){
        return !pointer.contains("UiSelector");
    }


    // We need a way to find out whether or not button, tab, etc is there or not.
    // A method to check if it is exists or not.
    public boolean exists(){
        try{
            // define a web element.
            WebElement element;

            // If xPath return true then find the XPath. Else, Pick by element.
            if (isXpath())
                element = pilot.findElementByXPath(pointer);
            else
                element = pilot.findElementByAndroidUIAutomator(pointer);

            return element.isDisplayed();

         // Catch to prevernt exception form this call: element.isDisplayed()
        }catch (NoSuchElementException e){
            return false;
        }
    }

    // Create more checks for other attributes.
    // This is follow by the general logic from above. If it's there, then return true. If not, false.
    // Or get attribute such as Text, name, className, resourceID, and also Actions.

    /**
     * True or False section
     */

    public boolean isChecked(){
        WebElement element;

        if (isXpath())
            element = pilot.findElementByXPath(pointer);
        else
            element = pilot.findElementByAndroidUIAutomator(pointer);

        return element.getAttribute("checked").equals("true");
    }

    public boolean isCheckable(){
        WebElement element;

        if (isXpath())
            element = pilot.findElementByXPath(pointer);
        else
            element = pilot.findElementByAndroidUIAutomator(pointer);

        return element.getAttribute("checkable").equals("true");
    }

    public boolean isClickable(){
        WebElement element;

        if (isXpath())
            element = pilot.findElementByXPath(pointer);
        else
            element = pilot.findElementByAndroidUIAutomator(pointer);

        return element.getAttribute("clickable").equals("true");
    }

    public boolean isEnabled(){
        WebElement element;

        if (isXpath())
            element = pilot.findElementByXPath(pointer);
        else
            element = pilot.findElementByAndroidUIAutomator(pointer);

        return element.getAttribute("enabled").equals("true");
    }

    public boolean isFocusable(){
        WebElement element;

        if (isXpath())
            element = pilot.findElementByXPath(pointer);
        else
            element = pilot.findElementByAndroidUIAutomator(pointer);

        return element.getAttribute("focusable").equals("true");
    }

    public boolean isFocused(){
        WebElement element;

        if (isXpath())
            element = pilot.findElementByXPath(pointer);
        else
            element = pilot.findElementByAndroidUIAutomator(pointer);

        return element.getAttribute("focused").equals("true");
    }

    public boolean isScrollable(){
        WebElement element;

        if (isXpath())
            element = pilot.findElementByXPath(pointer);
        else
            element = pilot.findElementByAndroidUIAutomator(pointer);

        return element.getAttribute("scrollable").equals("true");
    }

    public boolean isLongClickable(){
        WebElement element;

        if (isXpath())
            element = pilot.findElementByXPath(pointer);
        else
            element = pilot.findElementByAndroidUIAutomator(pointer);

        return element.getAttribute("longClickable").equals("true");
    }

    public boolean isSelected(){
        WebElement element;

        if (isXpath())
            element = pilot.findElementByXPath(pointer);
        else
            element = pilot.findElementByAndroidUIAutomator(pointer);

        return element.getAttribute("selected").equals("true");
    }

    /**
     * Return data value section
     */
    public Point getLocation(){
        WebElement element;

        if (isXpath())
            element = pilot.findElementByXPath(pointer);
        else
            element = pilot.findElementByAndroidUIAutomator(pointer);

        return element.getLocation();
    }

    public String getText(){
        WebElement element;

        if (isXpath())
            element = pilot.findElementByXPath(pointer);
        else
            element = pilot.findElementByAndroidUIAutomator(pointer);

        return element.getAttribute("name");
    }

    public String getResourceId(){
        WebElement element;

        if (isXpath())
            element = pilot.findElementByXPath(pointer);
        else
            element = pilot.findElementByAndroidUIAutomator(pointer);

        return element.getAttribute("resourceId");
    }

    public String getClassName(){
        WebElement element;

        if (isXpath())
            element = pilot.findElementByXPath(pointer);
        else
            element = pilot.findElementByAndroidUIAutomator(pointer);

        return element.getAttribute("className");
    }

    public String getContentDesc(){
        WebElement element;

        if (isXpath())
            element = pilot.findElementByXPath(pointer);
        else
            element = pilot.findElementByAndroidUIAutomator(pointer);

        return element.getAttribute("contentDesc");
    }


    /**
     * Basic Actions
     */

    public UiObject clearText(){
        if (isXpath())
            pilot.findElementByXPath(pointer).clear();
        else
            pilot.findElementByAndroidUIAutomator(pointer).clear();

        return this;
    }

    public UiObject typeText(String value){
        if (isXpath())
            pilot.findElementByXPath(pointer).sendKeys(value);
        else
            pilot.findElementByAndroidUIAutomator(pointer).sendKeys(value);

        return this;
    }

    public UiObject touchIt(){
        if (isXpath())
            pilot.findElementByXPath(pointer).click();
        else
            pilot.findElementByAndroidUIAutomator(pointer).click();

        return this;
    }


    public UiObject waitToShowUp(int seconds){

        TimeCaptain timer = new TimeCaptain();
        timer.begin();

        while (!timer.expired(seconds)) {
            if (exists())
                break;
        }

        if (timer.expired(seconds) && !exists())
            throw new AssertionError("Element " + pointer + " not show up within ideal seconds: " + seconds);

        return this;
    }


    public UiObject waitToBeGone(int seconds){

        TimeCaptain timer = new TimeCaptain();
        timer.begin();

        while (!timer.expired(seconds)) {
            if (!exists())
                break;
        }

        if (timer.expired(seconds) && exists())
            throw new AssertionError("Element " + pointer + " not gone within ideal seconds: " + seconds);

        return this;
    }


}
