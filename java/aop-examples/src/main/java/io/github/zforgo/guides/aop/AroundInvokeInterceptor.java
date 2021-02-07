package io.github.zforgo.guides.aop;

import org.jboss.logging.Logger;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Logged
@Interceptor
@Priority(2021)
public class AroundInvokeInterceptor {
    @Inject
    Logger logger;

    @AroundInvoke
    public Object intercept(InvocationContext ctx) throws Exception {
        logger.debug(String.format("Calling: %s", ctx.getMethod()));
        try {
            var result = ctx.proceed();
            logger.debug(String.format("Finished successfully: %s", ctx.getMethod()));
            return result;
        } catch (Exception e) {
            logger.error(String.format("Got a(n) [%s] exception (%s) during a method call: %s", e.getClass(), e.getMessage(), ctx.getMethod()));
            throw e;
        }
    }
}
