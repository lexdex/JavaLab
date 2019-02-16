package util;

import annotation.Description;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

public class ReflectionHelper {

    public static String[] getFieldAnnotationValues(Object object, String fieldName) {
        StringBuilder sb = new StringBuilder();


        Description annotation = getFieldByName(object, fieldName)
                .orElseThrow(NoSuchElementException::new)
                .getAnnotation(Description.class);
        if (annotation != null)
            sb.append(annotation.text())
                    .append("\n");

        return sb.toString().split("\n");
    }

    public static void invokeMethod(Object object, String methodName) {
        Method method = null;
        try {
            method = object.getClass().getDeclaredMethod(methodName);
            Object obj = method.invoke(object);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void invokeMethod(Object object, String methodName, Object param) {
        Class<?> parameters = param.getClass();

        if (PrimitiveType.isWiderPrimitive(param)) {
            parameters = PrimitiveType.getPrimitive(param.getClass());
        }

        try {
                Method method = object.getClass().getDeclaredMethod(methodName, parameters);
                Object obj = method.invoke(object,param);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public static void setFieldValue(Object object, String fieldName, Object value) {
        Field field = null;
        try {
            field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(object, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    private static Optional<Field> getFieldByName(Object object, String fieldName) {
        Field field = null;
        try {
            field = object.getClass().getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(field);
    }

    public static String[] findAnnotatedFieldNames(Object object, Class<? extends Annotation> ann) {
        StringBuilder sb = new StringBuilder();
        Class<?> objectClass = object.getClass();
        for (Field field : findFields(objectClass, ann)) {
            sb.append(field.getName()).append(" ");
        }
        return sb.toString().split(" ");
    }

    public static Set<Field> findFields(Class<?> clazz, Class<? extends Annotation> ann) {
        Set<Field> set = new HashSet<>();
        Class<?> c = clazz;
        while (c != null) {
            for (Field field : c.getDeclaredFields()) {
                if (field.isAnnotationPresent(ann)) {
                    set.add(field);
                }
            }
            c = c.getSuperclass();
        }
        return set;
    }

}
