package pmp.testingremoting.controller;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import pmp.testingremoting.service.OpenedHttpServiceExporter;

/**
 * Created by pozitron on 21.10.2017.
 */
public class NonRemoteInvoker extends HttpInvokerProxyFactoryBean {

    @Autowired
    private OpenedHttpServiceExporter exporter;

    public void setExporter(OpenedHttpServiceExporter exporter) {
        this.exporter = exporter;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        return exporter.invoke(createRemoteInvocation(methodInvocation), exporter.getService());
    }
}