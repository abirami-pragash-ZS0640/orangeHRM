package utils;

public class TestBase {
    public static String env = System.getProperty("qa", "uat");
    public static String browser = System.getProperty("firefox", "chrome");
    public static String suite = System.getProperty("@Regression", "@smoke");
}