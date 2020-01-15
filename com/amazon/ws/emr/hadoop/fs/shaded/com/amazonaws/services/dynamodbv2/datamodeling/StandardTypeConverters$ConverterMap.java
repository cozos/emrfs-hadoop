package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

class StandardTypeConverters$ConverterMap
  extends LinkedHashMap<Class<?>, StandardTypeConverters.Converter<?, ?>>
{
  private static final long serialVersionUID = -1L;
  private final Class<?> referenceType;
  private final Class<?> primitiveType;
  
  private StandardTypeConverters$ConverterMap(Class<?> referenceType, Class<?> primitiveType)
  {
    this.referenceType = referenceType;
    this.primitiveType = primitiveType;
  }
  
  private <S, T> ConverterMap with(Class<T> targetType, StandardTypeConverters.Converter<S, T> converter)
  {
    put(targetType, converter);
    return this;
  }
  
  private boolean isAssignableFrom(Class<?> type)
  {
    return type.isPrimitive() ? false : primitiveType == type ? true : referenceType.isAssignableFrom(type);
  }
  
  private <S, T> StandardTypeConverters.Converter<S, T> getConverter(Class<T> targetType)
  {
    for (Map.Entry<Class<?>, StandardTypeConverters.Converter<?, ?>> entry : entrySet()) {
      if (((Class)entry.getKey()).isAssignableFrom(targetType)) {
        return (StandardTypeConverters.Converter)entry.getValue();
      }
    }
    if (isAssignableFrom(targetType)) {
      return StandardTypeConverters.ToObject.access$5000();
    }
    throw new DynamoDBMappingException("type [" + targetType + "] is not supported; no conversion from " + referenceType);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.ConverterMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */