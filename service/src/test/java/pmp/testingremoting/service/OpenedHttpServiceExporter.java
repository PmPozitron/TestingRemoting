package pmp.testingremoting.service;

import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.remoting.support.RemoteInvocation;
import org.springframework.remoting.support.RemoteInvocationResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by pozitron on 12.11.2017.
 */
public class OpenedHttpServiceExporter extends HttpInvokerServiceExporter {

    @Override
    public RemoteInvocation readRemoteInvocation(HttpServletRequest request) throws IOException, ClassNotFoundException {
        return super.readRemoteInvocation(request);
    }

    @Override
    public RemoteInvocation readRemoteInvocation(HttpServletRequest request, InputStream is) throws IOException, ClassNotFoundException {
        return super.readRemoteInvocation(request, is);
    }

    @Override
    public void writeRemoteInvocationResult(HttpServletRequest request, HttpServletResponse response, RemoteInvocationResult result) throws IOException {
        super.writeRemoteInvocationResult(request, response, result);
    }

    @Override
    public void writeRemoteInvocationResult(HttpServletRequest request, HttpServletResponse response, RemoteInvocationResult result, OutputStream os) throws IOException {
        super.writeRemoteInvocationResult(request, response, result, os);
    }

    @Override
    public Object invoke(RemoteInvocation invocation, Object targetObject) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return super.invoke(invocation, targetObject);
    }

    @Override
    public RemoteInvocationResult invokeAndCreateResult(RemoteInvocation invocation, Object targetObject) {
        return super.invokeAndCreateResult(invocation, targetObject);
    }


}
