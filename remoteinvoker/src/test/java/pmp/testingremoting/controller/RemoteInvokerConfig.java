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
import pmp.testingremoting.service.ContactService;

/**
 * Created by pozitron on 21.10.2017.
 */
@Configuration
@ImportResource(locations = {
        "classpath:spring/webContext.xml",
})
public class RemoteInvokerConfig {

    @Bean
    public NonRemoteInvoker contactService() {
        NonRemoteInvoker invoker = new NonRemoteInvoker();
        invoker.setServiceUrl("http://localhost:8080/remote/ContactService");
        invoker.setServiceInterface(ContactService.class);
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:spring/serviceExporter.xml");
        invoker.setContext(context);

        return invoker;
    }
}
