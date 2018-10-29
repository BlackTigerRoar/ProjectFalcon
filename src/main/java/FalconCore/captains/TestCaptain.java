package FalconCore.captains;

import FalconCore.FalconLogger;
import FalconCore.Retry;
import FalconCore.TestInfo;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;


/**
 * Created by ShenYuSun
 * This TestCaption, we have JUnit rules to deal with test pass or fail.
 * Also do the method before and after test. keep "DRY".
 */

public class TestCaptain {

    public static TestInfo testInfo = new TestInfo();

    // Rule for handling how many time of testing we need.
    @Rule
    public Retry retry = new Retry(3);

    // Reset all the value in TestInfo so we get new data.
    @Before
    public void before(){
        testInfo.resetAllValues();
    }

     //TODO: We need to set up a database to store all the reocrd if we need.
     //Rule to handle pass or fail test cases in to Database
    @Rule
    public TestRule testWatcher = new TestWatcher() {

         @Override
         protected void failed(Throwable e, org.junit.runner.Description description) {
             FalconLogger.log.info("********* Test Failed *********");
             TestInfo.printOutResults();


         }


         @Override
         protected void succeeded(org.junit.runner.Description description) {
             FalconLogger.log.info("********* Test Passed *********");
             TestInfo.printOutResults();


         }
     };
}
