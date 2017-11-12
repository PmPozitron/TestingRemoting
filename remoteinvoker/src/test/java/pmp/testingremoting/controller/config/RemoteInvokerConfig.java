package pmp.testingremoting.controller.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by pozitron on 21.10.2017.
 */
@Configuration
@ImportResource(locations = {
        "classpath:spring/webContext.xml",
        "classpath:spring/remoteInvokerContext.xml"
})
public class RemoteInvokerConfig {

}
