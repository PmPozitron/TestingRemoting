package pmp.testingremoting.controller.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.GenericXmlApplicationContext;
import pmp.testingremoting.service.ContactService;
import pmp.testingremoting.service.OpenedHttpServiceExporter;

/**
 * Created by pozitron on 21.10.2017.
 */
@Configuration
@ImportResource(locations = {
        "classpath:spring/webContext.xml"
})
public class RemoteInvokerConfig {

    private ApplicationContext context;

//    @Autowired
//    private BusinessServiceConfig businessConfig;



//    @Bean
    public OpenedHttpServiceExporter contactExporter() {
        OpenedHttpServiceExporter exporter = new OpenedHttpServiceExporter();
        if (context == null) {
            context = new GenericXmlApplicationContext("classpath:spring/serviceExporter.xml");
        }
        exporter.setService(context.getBean(ContactService.class));
        exporter.setServiceInterface(pmp.testingremoting.service.ContactService.class);

        return exporter;
    }
}
