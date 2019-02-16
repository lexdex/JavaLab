package util;

public class PrimitiveType {

    public static boolean isWiderPrimitive(Object object) {
        if (object == null) {
            return false;
        }
        Class clazz = object.getClass();
        if (clazz == Boolean.class || clazz == Character.class ||
                clazz == Byte.class || clazz == Short.class ||
                clazz == Integer.class || clazz == Long.class ||
                clazz == Float.class || clazz == Double.class ||
                clazz == String.class || clazz == Void.class) {
            return true;
        }
        return false;
    }

    public static <T> Class<T> getPrimitive(Class<T> wrapper){
        Class<T> clazz = null;
        try {
            clazz =  (Class<T>)wrapper.getDeclaredField("TYPE").get(null);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return clazz;
    }
}
