package utility1;

import org.apache.log4j.Logger;

public class Log
{
    // Initialize Log4j logs
	 private static Logger logger = Logger.getLogger(Log.class.getName());
	
	 
	 // This is to print log for the beginning of the test case, as we usually
    // run so many test cases as a test suite

    public static void startTestSuite(String sTestSuiteName)
    {
        logger.info("");
        logger.info("****************************************************************************************");
        logger.info("         " + sTestSuiteName + "      ");
        logger.info("****************************************************************************************");
        logger.info("");
    }

    public static void startTestCase(String sTestCaseName, String sTestCaseDesc)
    {
        logger.info("");
        logger.info("----------------------------------------------------------------------------------------");
        logger.info("Test case name:   " + sTestCaseName);
        logger.info("Test case desc:   " + sTestCaseDesc);
        logger.info("");
    }

    // This is to print log for the ending of the test case
    public static void endTestCase(String sTestCaseName, String sResult)
    {

        logger.info("         " + sTestCaseName + ": " + sResult + "             ");
        logger.info("----------------------------------------------------------------------------------------");
    }

    public static void endTestSuite(String sTestSuiteName, String sResult)
    {
        logger.info("****************************************************************************************");
        logger.info("         " + sTestSuiteName + ": " + sResult + "             ");
        logger.info("****************************************************************************************");
        logger.info("");
        logger.info("");
    }

    // Need to create these methods, so that they can be called
    public static void info(String message)
    {
        logger.info(message);
        
    }

    public static void warn(String message)
    {
        logger.warn(message);
    }

    public static void error(String message)
    {
        logger.error(message);
    }

    public static void fatal(String message)
    {
        logger.fatal(message);
    }

    public static void debug(String message)
    {
        logger.debug(message);
    }
}