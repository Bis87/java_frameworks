package APITests;

import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class BaseTest {
    static Logger log = LogManager.getLogger(BaseTest.class.getName());
//
//    private PrintStream originalOut;
//    private ByteArrayOutputStream baos;
//
//    @BeforeMethod(alwaysRun = true)
//    public void setUp() {
//        // Capture stdout before test
//        log.info("FROM BASE TEST BEFORE METHOD");
//        originalOut = System.out;
//        baos = new ByteArrayOutputStream();
//        PrintStream newOut = new PrintStream(baos);
//        System.setOut(newOut);
//    }
//
//    @AfterMethod(alwaysRun = true)
//    public void tearDown() {
//        log.info("FROM BASE TEST BEFORE METHOD");
//        // Restore the original stdout after the test
//        System.setOut(originalOut);
//
//        // Capture the console output and add it to Allure report as an attachment
//        Allure.addAttachment("Console Output", baos.toString());
//    }

}
