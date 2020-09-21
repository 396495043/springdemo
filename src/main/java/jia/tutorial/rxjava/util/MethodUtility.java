package jia.tutorial.rxjava.util;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodUtility {

    public static void invokeRunnable(Class<?> type){

        try {
            Object target = type.getConstructors()[0].newInstance();
            Arrays.asList(type.getMethods()).stream()
                    .filter(MethodUtility::isRunnable)
                    .forEach(m -> invoke(m, target));
        }
        catch(Exception e) {
            System.out.println( " MethodUtility exception " + e);
          //  throw new RuntimeException();
        }
    }

    private static boolean isRunnable(Method m) {
        return m.getDeclaringClass() != Object.class
                && m.getReturnType() == void.class
                && m.getParameterCount() == 0;
    }

    private static void invoke(Method m, Object target){
        System.out.println("**************************");
        System.out.println("invoke method " + m.getName());

        try {
            m.invoke(target);
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}
