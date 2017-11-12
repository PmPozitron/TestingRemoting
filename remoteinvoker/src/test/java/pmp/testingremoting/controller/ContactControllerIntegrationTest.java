package pmp.testingremoting.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Pozitron on 18.09.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
        @ContextConfiguration(classes = {
                ContactControllerIntegrationTest.TunedBusinessConfig.class
        }),
        @ContextConfiguration(classes = {
                ContactControllerIntegrationTest.TunedRemoteInvokerConfig.class
        })
})
public class ContactControllerIntegrationTest {

    @Autowired
    private ContactController controller;

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
            "classpath:openedServiceExporter.xml"
    })
    static class TunedBusinessConfig {

    }


    @Configuration
    @ImportResource(locations = {
//            "classpath:spring/webContext.xml",
            "classpath:nonRemoteInvokerContext.xml",
    })
    static class TunedRemoteInvokerConfig {

    }
}
