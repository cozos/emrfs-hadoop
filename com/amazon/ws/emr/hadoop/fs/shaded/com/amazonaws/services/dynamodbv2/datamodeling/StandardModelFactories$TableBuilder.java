package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.Map;

final class StandardModelFactories$TableBuilder<T>
  extends DynamoDBMapperTableModel.Builder<T>
{
  private StandardModelFactories$TableBuilder(Class<T> clazz, StandardBeanProperties.Beans<T> beans, StandardModelFactories.RuleFactory<Object> rules)
  {
    super(clazz, beans.properties());
    for (StandardBeanProperties.Bean<T, Object> bean : beans.map().values()) {
      try
      {
        with(new StandardModelFactories.FieldBuilder(clazz, bean, rules.getRule(bean.type()), null).build());
      }
      catch (RuntimeException e)
      {
        throw new DynamoDBMappingException(String.format("%s[%s] could not be mapped for type %s", new Object[] {clazz
        
          .getSimpleName(), bean.properties().attributeName(), bean.type() }), e);
      }
    }
  }
  
  private StandardModelFactories$TableBuilder(Class<T> clazz, StandardModelFactories.RuleFactory<Object> rules)
  {
    this(clazz, StandardBeanProperties.of(clazz), rules);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardModelFactories.TableBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */