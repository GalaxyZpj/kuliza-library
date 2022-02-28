package com.kuliza.library.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.util.ReflectionUtils;

public class MapperUtils {

  private static boolean isEntityInstanceWithNullId(Object entity) throws NoSuchMethodException, SecurityException,
      IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    Long id = (Long) entity.getClass().getMethod("getId").invoke(entity);
    return id == null;
  }

  private static boolean isRawMappedEntityInstance(Object instance) throws NoSuchMethodException, SecurityException,
      IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    return instance.getClass().isAnnotationPresent(Entity.class) && isEntityInstanceWithNullId(instance);
  }

  public static void patchEntityAttributes(Object patchFromEntity, Object patchToEntity)
      throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalAccessException,
      IllegalArgumentException, InvocationTargetException {
    for (Field field : MapperUtils.getClassFields(new ArrayList<Field>(), patchToEntity.getClass())) {
      ReflectionUtils.makeAccessible(field);
      Object patchValue = ReflectionUtils.getField(field, patchFromEntity);
      if (patchValue != null && !isRawMappedEntityInstance(patchValue)) {
        MapperUtils.setTargetObjectFieldValue(field.getName(), patchToEntity, patchValue);
      }
    }
  }

  public static List<Field> getClassFields(List<Field> fields, Class<?> clazz) {
    fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
    Class<?> superclass = clazz.getSuperclass();
    if (superclass != null) {
      getClassFields(fields, superclass);
    }
    return fields;
  }

  // public static Field getClassField(String fieldName, Class<?> clazz) throws
  // Exception {
  // try {
  // return clazz.getDeclaredField(fieldName);
  // } catch (NoSuchFieldException | SecurityException e) {
  // Class<?> superclass = clazz.getSuperclass();
  // if (superclass == null)
  // throw e;
  // return getClassField(superclass, fieldName);
  // }
  // }

  public static Field getClassField(Class<?> clazz, String fieldName) {
    Field field = ReflectionUtils.findField(clazz, fieldName);
    if (field == null) {
      throw new IllegalStateException("Couldn't find field " + fieldName + " on target " + clazz);
    }
    return field;
  }

  public static String getMappedEntityFieldNameForIdField(String idFieldName) {
    return idFieldName.substring(0, idFieldName.length() - 2);
  }

  public static Object getMappedEntityObjectForIdField(String mappedEntityFieldName, Object id, Class<?> entityClass)
      throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
      NoSuchMethodException, SecurityException, NoSuchFieldException {
    Class<?> mappedEntityFieldClass = getClassField(entityClass, mappedEntityFieldName).getType();
    Object obj = mappedEntityFieldClass.getConstructor().newInstance();
    setTargetObjectFieldValue("id", obj, id);
    return obj;
  }

  public static void setTargetObjectFieldValue(String fieldName, Object target, Object value)
      throws NoSuchFieldException, SecurityException {
    Field field = getClassField(target.getClass(), fieldName);
    ReflectionUtils.makeAccessible(field);
    ReflectionUtils.setField(field, target, value);
  }
}
