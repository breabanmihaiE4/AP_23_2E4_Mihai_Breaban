package org.example;

import java.io.File;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Test {}
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Please provide the path to the .class file as an argument.");
            return;
        }

        String classFilePath = args[0];

        File file = new File(classFilePath);
        URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{file.toURI().toURL()});
        String className = file.getName().replace(".class", "");
        Class<?> clazz = classLoader.loadClass(className);

        Package classPackage = clazz.getPackage();
        String packageName = classPackage != null ? classPackage.getName() : "";

        System.out.println("Class: " + clazz.getName());
        System.out.println("Package: " + packageName);

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method: " + method.getName());
        }

        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class) && method.getParameterCount() == 0 && method.getReturnType() == void.class) {
                method.invoke(null);
            }
        }
    }
}
