package pmp.testingremoting.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pmp.testingremoting.dao.ContactRepository;
import pmp.testingremoting.model.Contact;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Pozitron on 18.09.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        ContactServiceIntegrationTest.TestConfig.class,
})
public class ContactServiceIntegrationTest {

    @Resource(name = ContactServiceImpl.QUALIFIER)
    private ContactService service;

    @Resource
    private HttpInvokerServiceExporter contactExporter;

    @Test
    public void thatData_isAccessibleLocally() {
        assertNotNull("service was not wired !", service);
        List<Contact> result = service.findAll();
        assertFalse("data was not received from H2 storage !", result.isEmpty());
        StringBuilder sb = new StringBuilder();
        result.forEach(sb::append);
        System.out.println(sb);
    }

    @Test
    public void thatData_isAccessibleViaExporter() {
        assertNotNull("exporter was not wired !", contactExporter);
        List<Contact> result = ((ContactService)contactExporter.getService()).findAll();
        assertFalse("data was not received from exporter!", result.isEmpty());
        StringBuilder sb = new StringBuilder();
        result.forEach(sb::append);
        System.out.println(sb);
    }

    @Configuration
    @ImportResource({
            "classpath:spring/serviceExporter.xml",
//            "classpath:openedServiceExporter.xml"
    })
    @ComponentScan(basePackages = {
            "pmp.testingremoting.service"
    })
    static class TestConfig {

    }
}
