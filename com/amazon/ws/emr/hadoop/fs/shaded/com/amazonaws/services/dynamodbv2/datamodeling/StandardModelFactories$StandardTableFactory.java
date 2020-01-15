package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class StandardModelFactories$StandardTableFactory
  implements DynamoDBMapperModelFactory.TableFactory
{
  private final ConcurrentMap<Class<?>, DynamoDBMapperTableModel<?>> cache;
  private final StandardModelFactories.RuleFactory<Object> rules;
  
  private StandardModelFactories$StandardTableFactory(StandardModelFactories.RuleFactory<Object> rules)
  {
    cache = new ConcurrentHashMap();
    this.rules = rules;
  }
  
  public <T> DynamoDBMapperTableModel<T> getTable(Class<T> clazz)
  {
    if (!cache.containsKey(clazz)) {
      cache.putIfAbsent(clazz, new StandardModelFactories.TableBuilder(clazz, rules, null).build());
    }
    return (DynamoDBMapperTableModel)cache.get(clazz);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardModelFactories.StandardTableFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */