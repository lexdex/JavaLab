package com.company.transformer;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.company.model.annotation.Column;
import com.company.model.annotation.Table;

public class Transformer<T> {

  private final Class<T> clazz;

  public Transformer(Class<T> clazz) {
    this.clazz = clazz;
  }

  public Object fromResultSetToEntity(ResultSet rs)
      throws SQLException {
    //create new object
    Object entity = null;
    try {
      entity = clazz.getConstructor().newInstance();
      if (clazz.isAnnotationPresent(Table.class)) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
          // if field is annotated with @Column
          if (field.isAnnotationPresent(Column.class)) {
            Column column = (Column) field.getAnnotation(Column.class);
            String name = column.name();
            int length = column.length();
            field.setAccessible(true);
            Class fieldType = field.getType();
            if (fieldType == String.class) {
              field.set(entity, rs.getString(name));
            } else if (fieldType == Integer.class) {
              field.set(entity, rs.getInt(name));
            } else if (fieldType == Date.class) {
              field.set(entity, rs.getDate(name));
            }
          }
        }
      }
    } catch (InstantiationException | IllegalAccessException |
        InvocationTargetException | NoSuchMethodException ignored) {
    }
    return entity;
  }
}
