package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.lang.reflect.Method;

final class StandardBeanProperties$Bean<T, V>
{
  private final DynamoDBMapperFieldModel.Properties<V> properties;
  private final ConvertibleType<V> type;
  private final DynamoDBMapperFieldModel.Reflect<T, V> reflect;
  
  private StandardBeanProperties$Bean(StandardAnnotationMaps.FieldMap<V> annotations, DynamoDBMapperFieldModel.Reflect<T, V> reflect, Method getter)
  {
    properties = new DynamoDBMapperFieldModel.Properties.Immutable(annotations);
    type = ConvertibleType.of(getter, annotations);
    this.reflect = reflect;
  }
  
  final DynamoDBMapperFieldModel.Properties<V> properties()
  {
    return properties;
  }
  
  final ConvertibleType<V> type()
  {
    return type;
  }
  
  final DynamoDBMapperFieldModel.Reflect<T, V> reflect()
  {
    return reflect;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardBeanProperties.Bean
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */