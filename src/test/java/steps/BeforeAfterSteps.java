package steps;

import cucumber.api.cli.Main;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;

import org.apache.logging.log4j.core.appender.FileAppender;
import org.apache.logging.log4j.core.config.AppenderRef;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilderFactory;
import org.apache.logging.log4j.core.config.builder.api.RootLoggerComponentBuilder;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.w3c.dom.DOMConfiguration;
import util.Driver;
import java.io.File;
import java.time.LocalDateTime;
import java.util.Map;

public class BeforeAfterSteps {



   // public static Scenario scenario;

    @Before
    public void before(Scenario scenario) throws Exception {
        //BeforeAfterSteps.scenario = scenario;
        //System.out.println(scenario);
        Driver.startDriver();
        Driver.addAppender(scenario);

    }

    @After
    public void after(){
        Driver.getDriver().quit();
        ((org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false)).reconfigure();

    }




}
