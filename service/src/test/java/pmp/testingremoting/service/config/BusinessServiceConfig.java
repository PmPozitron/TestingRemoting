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
@Import(BusinessServiceConfig.Config.class)
public class BusinessServiceConfig {

    @Autowired
    private ContactService service;

//    @Autowired
    private OpenedHttpServiceExporter exporter;

//    @PostConstruct
    public void finetuneExporter () {
        exporter.setService(service);
    }


    @Configuration
    @ImportResource(locations = {
//            "classpath:spring/serviceExporter.xml",
            "classpath:openedServiceExporter.xml",
    })
    static class Config {
//        @Bean
        public OpenedHttpServiceExporter contactExporter() {
            OpenedHttpServiceExporter exporter = new OpenedHttpServiceExporter();
            exporter.setServiceInterface(pmp.testingremoting.service.ContactService.class);

            return exporter;
        }

    }

}
