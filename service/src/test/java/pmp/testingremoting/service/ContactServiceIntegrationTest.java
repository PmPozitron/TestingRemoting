package pmp.testingremoting.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pmp.testingremoting.model.Contact;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

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

    @Test
    public void thatData_isAccessibleLocally() {
        assertNotNull("service was not wired !", service);
        List<Contact> result = service.findAll();
        assertFalse("data was not received from H2 storage !", result.isEmpty());
    }


    @Configuration
    @ImportResource({
            "classpath*:spring/serviceContext.xml"
    })
    @ComponentScan(basePackages = {
            "pmp.testingremoting.service"
    })
    static class TestConfig {

    }
}
