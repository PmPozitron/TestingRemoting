package pmp.testingremoting.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.GenericXmlApplicationContext;
import pmp.testingremoting.service.ContactService;
import pmp.testingremoting.service.OpenedHttpServiceExporter;

import javax.annotation.PostConstruct;

/**
 * Created by pozitron on 21.10.2017.
 */
@Configuration
@ImportResource(locations = {
        "classpath:spring/serviceExporter.xml",
})
public class BusinessServiceConfig {

}
