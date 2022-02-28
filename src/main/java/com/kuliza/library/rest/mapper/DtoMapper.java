package com.kuliza.library.rest.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToOne;

import com.kuliza.library.entities.abstracts.AbstractEntity;
import com.kuliza.library.rest.dto.abstracts.AbstractGetDto;
import com.kuliza.library.utils.MapperUtils;

import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

@Component
public class DtoMapper<EntityType> {

  public void mapDtoToEntity(Object dto, EntityType entity)
      throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException,
      InstantiationException, InvocationTargetException, NoSuchMethodException {
    List<Field> fields = MapperUtils.getClassFields(new ArrayList<Field>(), dto.getClass());
    for (Field field : fields) {
      ReflectionUtils.makeAccessible(field);
      Object fieldValue = ReflectionUtils.getField(field, dto);
      String fieldName = field.getName();
      if (fieldName.endsWith("Id")) {
        String mappedEntityFieldName = MapperUtils.getMappedEntityFieldNameForIdField(fieldName);
        Object mappedEntityObject = MapperUtils.getMappedEntityObjectForIdField(mappedEntityFieldName, fieldValue,
            entity.getClass());
        MapperUtils.setTargetObjectFieldValue(mappedEntityFieldName, entity, mappedEntityObject);
      } else {
        MapperUtils.setTargetObjectFieldValue(fieldName, entity, fieldValue);
      }
    }
  }

  public void mapEntityToDto(EntityType entity, AbstractGetDto dto, boolean min)
      throws SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
    List<Field> fields = MapperUtils.getClassFields(new ArrayList<Field>(), entity.getClass());
    for (Field field : fields) {
      ReflectionUtils.makeAccessible(field);
      String fieldName;
      Object fieldValue;
      if (min && field.isAnnotationPresent(ManyToOne.class)) {
        fieldName = field.getName() + "Id";
        AbstractEntity mappedEntity = (AbstractEntity) ReflectionUtils.getField(field, entity);
        fieldValue = mappedEntity.getId();
      } else {
        fieldName = field.getName();
        fieldValue = ReflectionUtils.getField(field, entity);
      }
      MapperUtils.setTargetObjectFieldValue(fieldName, dto, fieldValue);
    }
  }

  public void mapEntityToDto(EntityType entity, AbstractGetDto dto)
      throws SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
    mapEntityToDto(entity, dto, true);
  }

}
