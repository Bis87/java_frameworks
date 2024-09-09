//package utils;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import java.io.File;
//import java.nio.file.Paths;
//
//public class CustomTestListener implements ITestListener {
//
//    private static final Logger logger = LogManager.getLogger(CustomTestListener.class);
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        String testName = result.getMethod().getMethodName();
//        String logFileName = "logs/" + testName + ".log";
//        System.setProperty("testLogFile", Paths.get(logFileName).toString());
//
//        logger.info("Starting test: " + testName);
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        logger.info("Test Passed: " + result.getMethod().getMethodName());
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        logger.error("Test Failed: " + result.getMethod().getMethodName());
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        logger.warn("Test Skipped: " + result.getMethod().getMethodName());
//    }
//
//    @Override
//    public void onStart(ITestContext context) {
//        // Called before the test starts
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//        // Called after all the tests have been run
//    }
//}
