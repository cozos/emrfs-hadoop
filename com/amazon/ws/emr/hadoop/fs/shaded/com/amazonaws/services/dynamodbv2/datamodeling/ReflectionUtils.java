package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Deprecated
class ReflectionUtils
{
  static String getFieldNameByGetter(Method getter, boolean forceCamelCase)
  {
    String getterName = getter.getName();
    
    String fieldNameWithUpperCamelCase = "";
    if (getterName.startsWith("get")) {
      fieldNameWithUpperCamelCase = getterName.substring("get".length());
    } else if (getterName.startsWith("is")) {
      fieldNameWithUpperCamelCase = getterName.substring("is".length());
    }
    if (fieldNameWithUpperCamelCase.length() == 0) {
      throw new DynamoDBMappingException("Getter must begin with 'get' or 'is', and the field name must contain at least one character.");
    }
    if (forceCamelCase) {
      return StringUtils.lowerCase(fieldNameWithUpperCamelCase.substring(0, 1)) + fieldNameWithUpperCamelCase.substring(1);
    }
    return fieldNameWithUpperCamelCase;
  }
  
  static Field getClassFieldByName(Class<?> clazz, String fieldName)
  {
    try
    {
      return clazz.getDeclaredField(fieldName);
    }
    catch (SecurityException e)
    {
      throw new DynamoDBMappingException("Denied access to the [" + fieldName + "] field in class [" + clazz + "].", e);
    }
    catch (NoSuchFieldException e) {}
    return null;
  }
  
  static <T extends Annotation> T getAnnotationFromGetterOrField(Method getter, Class<T> annotationClass)
  {
    T onGetter = getter.getAnnotation(annotationClass);
    if (onGetter != null) {
      return onGetter;
    }
    String fieldName = getFieldNameByGetter(getter, true);
    
    Field field = getClassFieldByName(getter.getDeclaringClass(), fieldName);
    T onField = null;
    if (field != null) {
      onField = field.getAnnotation(annotationClass);
    }
    return onField;
  }
  
  static <T extends Annotation> boolean getterOrFieldHasAnnotation(Method getter, Class<T> annotationClass)
  {
    return getAnnotationFromGetterOrField(getter, annotationClass) != null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ReflectionUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */