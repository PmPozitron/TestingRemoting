package pmp.testingremoting;

import org.springframework.context.support.GenericXmlApplicationContext;
import pmp.testingremoting.model.Contact;
import pmp.testingremoting.service.ContactService;

import java.util.List;

/**
 * Created by Pozitron on 18.09.2016.
 */
public class TestDrive {

    public static final String CONTEXT_CONFIG_LOCATION = "classpath:spring/remoteInvokerContext.xml";

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load(CONTEXT_CONFIG_LOCATION);
        context.refresh();

        ContactService service = (ContactService)context.getBean("serviceInvoker");
        List<Contact> result = service.findAll();
        StringBuilder sb = new StringBuilder();
        result.forEach(sb::append);
        System.out.println(sb);
    }
}
