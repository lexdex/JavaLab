package util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassInfo {

    public static void printInfo(Object object) {
        Class<?> objectClass = object.getClass();
        System.out.print("Class: ");
        System.out.println(objectClass.getName());

        System.out.println("Constructors: ");
        for (Constructor constructor : objectClass.getConstructors()) {
            System.out.println(constructor.getName());
        }

        System.out.println("Fields: ");
        for (Field field : objectClass.getDeclaredFields()) {
            System.out.println(field.getType().getSimpleName() + " " + field.getName());
        }

        System.out.println("Methods: ");
        for (Method method : objectClass.getDeclaredMethods()) {
            System.out.println(method.getReturnType().getSimpleName() + " " + method.getName());
        }

    }
}
