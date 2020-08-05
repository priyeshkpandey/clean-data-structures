package clean.project.gui.interceptor;

import clean.project.gui.contract.Actor;
import clean.project.gui.factory.GUIFactoryBuilder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ActorHandler implements InvocationHandler {
    private static final String RESULT_FILE_NAME = "gui_stats.csv";
    private static final String ELIGIBLE_ACTIONS = "open,enter,click,submit,find,robot,jsClick,jsChange,clear,keyboard,close";
    private static final Map<String, AtomicInteger> methodCounts = new HashMap<>();
    private static final GUIFactoryBuilder guiFactoryBuilder = new GUIFactoryBuilder();
    private Actor actor;
    public ActorHandler(final Actor actor) {
        this.actor = actor;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        final Object returnObj = method.invoke(this.actor, args);
        long elapsed = System.currentTimeMillis() - start;
        System.out.println("Execution time for the action " + method.getName() + " is " + elapsed + " millis.");
        return returnObj;
    }


}
