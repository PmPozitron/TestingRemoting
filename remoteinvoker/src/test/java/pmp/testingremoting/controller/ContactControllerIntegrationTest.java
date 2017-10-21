package pmp.testingremoting.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import pmp.testingremoting.service.ContactService;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Pozitron on 18.09.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        ContactControllerIntegrationTest.TestConfig.class,
})
@WebAppConfiguration
public class ContactControllerIntegrationTest {

    @Autowired
    private ContactController controller;


//    @Autowired
    private HttpInvokerServiceExporter exporter;

    @Autowired
    private ApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void initMockMvc() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void thatData_isAccessibleRemotely() throws Exception {
        assertNotNull("Contact controller was not wired !", controller);

        ResultActions ra = mockMvc.perform(get(ContactController.MAPPING));
        ra.andExpect(status().isOk());
    }

    @Configuration
    @ImportResource(locations = {
//            "classpath*:spring/remoteInvokerContext.xml",
            "classpath*:spring/webContext.xml",
            "classpath*:spring/serviceExporter.xml"
    })
    static class TestConfig {



    }

    static class NonRemoteInvoker extends HttpInvokerProxyFactoryBean {
        private ApplicationContext context;

        public void setContext(ApplicationContext context) {
            this.context = context;
        }

        @Override
        public Object getObject() {
            return context.getBean(getObjectType());
        }
    }
}
