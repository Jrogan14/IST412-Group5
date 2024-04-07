package src.Controller;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.logging.Logger;

public class LoggerProxy implements InvocationHandler {
    private Object target;
    private static Logger LOGGER = Logger.getLogger(LoggerProxy.class.getName());

    public LoggerProxy(Object target) {
        this.target = Objects.requireNonNull(target);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.nanoTime();
        Object result = method.invoke(target, args);
        long execTime = System.nanoTime() - start;

        LOGGER.info(
                "The execution of " + target.getClass().getSimpleName() + "." + method.getName() + " took " + execTime + "ns.");
        return result;
    }

}
