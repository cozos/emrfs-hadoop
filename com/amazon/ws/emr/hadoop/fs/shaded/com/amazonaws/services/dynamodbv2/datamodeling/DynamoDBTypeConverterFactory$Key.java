package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.AbstractMap.SimpleImmutableEntry;

final class DynamoDBTypeConverterFactory$Key<S, T>
  extends AbstractMap.SimpleImmutableEntry<Class<S>, Class<T>>
{
  private static final long serialVersionUID = -1L;
  
  private DynamoDBTypeConverterFactory$Key(Class<S> sourceType, Class<T> targetType)
  {
    super(sourceType, targetType);
  }
  
  public boolean isAssignableFrom(Class<?> sourceType, Class<?> targetType)
  {
    return (((Class)getKey()).isAssignableFrom(sourceType)) && (((Class)getValue()).isAssignableFrom(targetType));
  }
  
  public static <S, T> Key<S, T> of(Class<S> sourceType, Class<T> targetType)
  {
    return new Key(sourceType, targetType);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverterFactory.Key
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */