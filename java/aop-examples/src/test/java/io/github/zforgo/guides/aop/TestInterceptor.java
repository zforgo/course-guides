package io.github.zforgo.guides.aop;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.api.extension.ReflectiveInvocationContext;

import java.lang.reflect.Method;

public class TestInterceptor implements InvocationInterceptor {
    @Override
    public void interceptTestMethod(Invocation<Void> invocation, ReflectiveInvocationContext<Method> invocationContext, ExtensionContext extensionContext) throws Throwable {
        System.out.printf("Calling: %s%n", invocationContext.getExecutable());
        try {
            invocation.proceed();
            System.out.printf("Finished successfully: %s%n", invocationContext.getExecutable());
        } catch (Exception e) {
            System.err.printf("Got a(n) [%s] exception (%s) during a method call: %s%n", e.getClass(), e.getMessage(), invocationContext.getExecutable());
            throw e;
        }

    }
}
