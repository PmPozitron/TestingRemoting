package pmp.testingremoting.controller;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ReflectiveMethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.remoting.support.RemoteInvocation;
import org.springframework.remoting.support.RemoteInvocationResult;
import org.springframework.web.util.NestedServletException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by pozitron on 21.10.2017.
 */
public class NonRemoteInvoker extends HttpInvokerProxyFactoryBean {
//    private ApplicationContext context;

//    public void setContext(ApplicationContext context) {
//        this.context = context;
//    }

//    @Autowired
    private OpenedHttpServiceExporter exporter;

    public void setExporter(OpenedHttpServiceExporter exporter) {
        this.exporter = exporter;
    }

//    @Override
//    public Object getObject() {
//        return context.getBean(getObjectType());
//        return exporter.getService();
//    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        return exporter.invoke(createRemoteInvocation(methodInvocation), exporter.getService());
    }
}