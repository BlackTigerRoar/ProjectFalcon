package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by ShenYuSun, This class controls which tests suite that we are going to run.
 * It is going to run Navigation and Functionality class.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Navigation.class,
        Functionality.class
})

public class TestController {
}
