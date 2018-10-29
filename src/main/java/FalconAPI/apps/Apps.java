package FalconAPI.apps;

import FalconAPI.apps.bird.Bird;

/**
 * Created by ShenYuSun
 *  This Apps is going to hold all the apps that we are going to test. Here we only have "bird".
 *  This is for scale purpose
 */

public class Apps {
    // After this, we need to modify Android class to reference this.
    // Android class is the central class for referencing.
    public Bird bird = new Bird();
}
