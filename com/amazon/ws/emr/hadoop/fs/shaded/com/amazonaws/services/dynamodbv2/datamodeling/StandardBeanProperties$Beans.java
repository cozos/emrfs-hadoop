package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.Collections;
import java.util.Map;

final class StandardBeanProperties$Beans<T>
{
  private final DynamoDBMapperTableModel.Properties<T> properties;
  private final Map<String, StandardBeanProperties.Bean<T, Object>> map;
  
  private StandardBeanProperties$Beans(StandardAnnotationMaps.TableMap<T> annotations, Map<String, StandardBeanProperties.Bean<T, Object>> map)
  {
    properties = new DynamoDBMapperTableModel.Properties.Immutable(annotations);
    this.map = Collections.unmodifiableMap(map);
  }
  
  final DynamoDBMapperTableModel.Properties<T> properties()
  {
    return properties;
  }
  
  final Map<String, StandardBeanProperties.Bean<T, Object>> map()
  {
    return map;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardBeanProperties.Beans
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */