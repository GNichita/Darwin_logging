package steps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.*;
import util.Driver;


public class BeforeAfterSteps {

    @Before
    public void before(Scenario scenario){
        Driver.startDriver();
        Driver.addAppender(scenario);
    }

    @After
    public void after(){
        Driver.getDriver().quit();
        ((org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false)).reconfigure();

    }




}
