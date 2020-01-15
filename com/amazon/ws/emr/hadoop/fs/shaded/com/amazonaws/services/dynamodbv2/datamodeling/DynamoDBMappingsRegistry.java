package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Deprecated
@SdkInternalApi
final class DynamoDBMappingsRegistry
{
  private static final DynamoDBMappingsRegistry INSTANCE = new DynamoDBMappingsRegistry();
  
  static final DynamoDBMappingsRegistry instance()
  {
    return INSTANCE;
  }
  
  private final ConcurrentMap<Class<?>, Mappings> mappings = new ConcurrentHashMap();
  
  final Mappings mappingsOf(Class<?> clazz)
  {
    if (!mappings.containsKey(clazz)) {
      mappings.putIfAbsent(clazz, new Mappings(clazz, null));
    }
    return (Mappings)mappings.get(clazz);
  }
  
  static final class Mappings
  {
    private final Map<String, DynamoDBMappingsRegistry.Mapping> byNames = new HashMap();
    
    private Mappings(Class<?> clazz)
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
  
  static final class Mapping
  {
    private final StandardBeanProperties.Bean<Object, Object> bean;
    
    private Mapping(StandardBeanProperties.Bean<Object, Object> bean)
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMappingsRegistry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */