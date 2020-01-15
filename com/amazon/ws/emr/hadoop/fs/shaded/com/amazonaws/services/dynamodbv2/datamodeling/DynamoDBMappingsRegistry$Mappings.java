package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

final class DynamoDBMappingsRegistry$Mappings
{
  private final Map<String, DynamoDBMappingsRegistry.Mapping> byNames = new HashMap();
  
  private DynamoDBMappingsRegistry$Mappings(Class<?> clazz)
  {
    for (Map.Entry<String, StandardBeanProperties.Bean<Object, Object>> bean : StandardBeanProperties.of(clazz).map().entrySet())
    {
      DynamoDBMappingsRegistry.Mapping mapping = new DynamoDBMappingsRegistry.Mapping((StandardBeanProperties.Bean)bean.getValue(), null);
      byNames.put(mapping.getAttributeName(), mapping);
    }
  }
  
  final Collection<DynamoDBMappingsRegistry.Mapping> getMappings()
  {
    return byNames.values();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMappingsRegistry.Mappings
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */