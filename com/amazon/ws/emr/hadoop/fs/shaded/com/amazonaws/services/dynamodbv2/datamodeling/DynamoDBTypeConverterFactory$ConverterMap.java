package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class DynamoDBTypeConverterFactory$ConverterMap
  extends LinkedHashMap<DynamoDBTypeConverterFactory.Key<?, ?>, DynamoDBTypeConverter<?, ?>>
{
  private static final long serialVersionUID = -1L;
  
  public <S, T> void put(Class<S> sourceType, Class<T> targetType, DynamoDBTypeConverter<? extends S, ? extends T> converter)
  {
    put(DynamoDBTypeConverterFactory.Key.of(sourceType, targetType), converter);
  }
  
  public <S, T> DynamoDBTypeConverter<S, T> get(Class<S> sourceType, Class<T> targetType)
  {
    for (Map.Entry<DynamoDBTypeConverterFactory.Key<?, ?>, DynamoDBTypeConverter<?, ?>> entry : entrySet()) {
      if (((DynamoDBTypeConverterFactory.Key)entry.getKey()).isAssignableFrom(sourceType, targetType)) {
        return (DynamoDBTypeConverter)entry.getValue();
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverterFactory.ConverterMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */