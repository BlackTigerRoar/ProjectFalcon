package FalconCore;

/**
 * Created by ShenYuSun
 * This class simply the UI Selector and follow DRY principle!
 * From "driver.findElementsByUIAutomator("new UiSelector().text(\"something\")").click();"
 * to new UiSelector().resourceId("hello");   ----- much clean and easy to re-use!
 */

public class UiSelector {

    private String pointer = "new UiSelector()";

    public UiSelector resourceId(String value){
        pointer += ".resourceId(\"" + value + "\")";
        FalconLogger.log.debug("Generated new UiObject: " + this.pointer);
        return this;
    }

    public UiSelector className(String value){
        pointer += ".className(\"" + value + "\")";
        return this;
    }

    public UiSelector classNameMatches(String regex){
        pointer += ".classNameMatches(\"" + regex + "\")";
        return this;
    }

    public UiSelector text(String value){
        pointer += ".text(\"" + value + "\")";
        return this;
    }

    public UiSelector textContains(String value){
        pointer += ".textContains(\"" + value + "\")";
        return this;
    }

    public UiSelector index(int value){
        pointer += ".index(" + value + ")";
        return this;
    }

    public UiSelector clickable(boolean value){
        pointer += ".clickable(" + value + ")";
        return this;
    }

    public UiSelector checked(boolean value){
        pointer += ".checked(" + value + ")";
        return this;
    }

    public UiSelector enabled(boolean value){
        pointer += ".enabled(" + value + ")";
        return this;
    }

    public UiSelector description(String value){
        pointer += ".description(\"" + value + "\")";
        return this;
    }

    public UiSelector descriptionContains(String value){
        pointer += ".descriptionContains(\"" + value + "\")";
        return this;
    }

    public UiSelector descriptionMatches(String regex){
        pointer += ".descriptionMatches(\"" + regex + "\")";
        return this;
    }

    public UiSelector xPath(String xPath){
        pointer = xPath;
        return this;
    }


    // This method is going to create Falcon UiObject
    public UiObject createiObject(){
        return new UiObject(pointer);
    }

}
