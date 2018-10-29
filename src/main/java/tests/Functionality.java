package tests;

import FalconAPI.android.Android;
import FalconAPI.apps.bird.Bird;
import FalconCore.FalconLogger;
import FalconCore.captains.TestCaptain;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.xpath.operations.And;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;

/**
 * Created by ShenYuSun
 */
public class Functionality extends TestCaptain{
    private static Bird bird = Android.app.bird;

//todo To to for future
    public void before(){
        testInfo.suite("Functionality");
    }







}
