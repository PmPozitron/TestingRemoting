package pmp.testingremoting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

/**
 * Created by pozitron on 21.10.2017.
 */
public class NonRemoteInvoker extends HttpInvokerProxyFactoryBean {
    private ApplicationContext context;

    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public Object getObject() {
        return context.getBean(getObjectType());
    }
}
