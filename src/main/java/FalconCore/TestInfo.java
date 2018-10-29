package FalconCore;

/**
 * Created by ShenYuSun - This class is for Test Metadata
 */
public class TestInfo {
   private static String TIMESTEAMP, SUITE, ID, NAME, NOTES, EXPECTED, ACTUAL, VERSION;

   // Create a method to set above value.
   public TestInfo timestamp(String value){
       TIMESTEAMP = value;

       return this;
   }

    public TestInfo suite(String value){
        SUITE = value;

        return this;
    }

    public TestInfo id(String value){
        ID = value;

        return this;
    }

    public TestInfo name(String value){
        NAME = value;

        return this;
    }

    public TestInfo notes(String value){
        NOTES = value;

        return this;
    }

    public TestInfo expected(String value){
        EXPECTED = value;

        return this;
    }

    public TestInfo actual(String value){
        ACTUAL = value;

        return this;
    }

    public TestInfo version(String value){
        VERSION = value;

        return this;
    }

    public static String timestamp(){
        return TIMESTEAMP;
    }

    public static String suite(){
        return SUITE;
    }

    public static String id(){
        return ID;
    }

    public static String name(){
        return NAME;
    }

    public static String notes(){
        return NOTES;
    }

    public static String expected(){
        return EXPECTED;
    }

    public static String actual(){
        return ACTUAL;
    }

    public static String version(){
        return VERSION;
    }

    public void resetAllValues(){
        TIMESTEAMP = null;
        SUITE = null;
        ID = null;
        NAME = null;
        NOTES = null;
        EXPECTED = null;
        ACTUAL = null;
        VERSION = null;
    }

    // // TODO: This should be replace with XML report.
    // Print out results.
    public static void printOutResults(){
        FalconLogger.log.info("Test ID: " + id());
        FalconLogger.log.info("Test Suite: " + suite());
        FalconLogger.log.info("Test Name: " + name());
    }

}
