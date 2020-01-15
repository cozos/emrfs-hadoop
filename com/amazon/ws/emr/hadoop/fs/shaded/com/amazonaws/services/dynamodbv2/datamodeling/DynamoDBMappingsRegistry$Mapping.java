package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.lang.reflect.Method;

final class DynamoDBMappingsRegistry$Mapping
{
  private final StandardBeanProperties.Bean<Object, Object> bean;
  
  private DynamoDBMappingsRegistry$Mapping(StandardBeanProperties.Bean<Object, Object> bean)
  {
    this.bean = bean;
  }
  
  final Method getter()
  {
    return bean.type().getter();
  }
  
  final boolean isPrimaryKey()
  {
    return bean.properties().keyType() != null;
  }
  
  final boolean isVersion()
  {
    return bean.properties().versioned();
  }
  
  final String getAttributeName()
  {
    return bean.properties().attributeName();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMappingsRegistry.Mapping
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */