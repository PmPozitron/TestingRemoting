package pmp.testingremoting.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import pmp.testingremoting.service.ContactService;

/**
 * Created by pozitron on 21.10.2017.
 */
@Configuration
@ImportResource(locations = {
        "classpath:spring/webContext.xml"
})
public class RemoteInvokerConfig {

    private ApplicationContext context;

    @Bean
    public NonRemoteInvoker contactService() {
        NonRemoteInvoker invoker = new NonRemoteInvoker();
        invoker.setServiceUrl("http://localhost:8080/remote/ContactService");
        invoker.setServiceInterface(ContactService.class);

        if (context == null) {
            context = new GenericXmlApplicationContext("classpath:spring/serviceExporter.xml", "classpath:openedServiceExporter.xml");
        }

//        invoker.setContext(context);
        invoker.setExporter(contactExporter());

        return invoker;
    }

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
