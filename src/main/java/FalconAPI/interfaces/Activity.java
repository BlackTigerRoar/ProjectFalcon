package FalconAPI.interfaces;

/**
 * Created by ShenYuSun.
 *  Interface is like an abstract representation of something right.
 *  Here we have bird app, and then we can implement a lot of interfaces such as get package ID, clear data, etc.
 */
public interface Activity {
//todo More stuff to do be in the future.
    Object waitToLoad();
    boolean invalidEmailMessage();

    //todo Need to use Sikuli to do image serach for Bird Icons.
//        try{
//            Finder f = new Finder("./Bird_UI_Viewer/BirdEyeView.png");
//            f.find("./Bird_UI_Viewer/BirdsOnScreen.png");
//
//            while(f.hasNext()){
//
//                System.out.print("Found Birds on the Rider screen");
//                Match m = f.next();
//                f.destroy();
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        }

}
