package delivery.prj.common;


import delivery.prj.HistoryApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { HistoryApplication.class })
public class CucumberSpingConfiguration {
    
}
