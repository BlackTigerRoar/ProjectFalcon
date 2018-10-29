package FalconAPI.interfaces;

/**
 * Created by ShenYuSun.
 *  Interface is like an abstract representation of something right.
 *  Here we have bird app, and then we can implement a lot of interfaces such as package ID, clear data, etc.
 */
public interface Application {

    String packageId();
    String activityID();
    void clearData();
    Object open();
    void swipeToBottom();
    void takeScreenShot();
    String randomEmail();


}
