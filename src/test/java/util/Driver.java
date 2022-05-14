package util;


import cucumber.api.cli.Main;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.FileAppender;
import org.apache.logging.log4j.core.config.AppenderRef;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;

public class Driver {

    private static WebDriver driver;
    private static Actions actions;
    public static Logger log = LogManager.getLogger(Main.class.getName());

    public static void startDriver(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chrome/chromedriver.exe");
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public static void addAppender(Scenario scenario){
        String dateTime = LocalDateTime.now().toString();
        String dt = dateTime.replaceAll(":","_");
        String sc = scenario.getName().replaceAll("\\s","_");
        String path ="C:\\Users\\Никита\\IdeaProjects\\Loging\\src\\test\\java\\ScenariosLogging\\"+sc;
        File scenarioFolder = new File(path);
        scenarioFolder.mkdir();

        final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        final Configuration config = ctx.getConfiguration();
        final Layout layout = PatternLayout.createDefaultLayout(config);
        Appender appender = FileAppender.createAppender(path+"\\"+sc+"_"+dt+".log", "false", "false", "File", "true",
                "false", "true", "4000", layout, null, "false", null, config);
        appender.start();
        config.addAppender(appender);
        AppenderRef ref = AppenderRef.createAppenderRef("File", null, null);
        AppenderRef[] refs = new AppenderRef[] {ref};
        LoggerConfig loggerConfig = config.getLoggerConfig("cucumber.api.cli.Main");
        loggerConfig.addAppender(appender, null, null);
        ctx.updateLoggers();
    }
    public static Actions getActions(){
        if(actions==null){
            throw new DriverNotInitialisedExeption("Actions is not initialised!");
        }
        return actions;
    }
    public static WebDriver getDriver(){
        if(driver==null){
            throw new DriverNotInitialisedExeption("WebDriver is not initialised!");
        }
        return driver;
    }

    }

