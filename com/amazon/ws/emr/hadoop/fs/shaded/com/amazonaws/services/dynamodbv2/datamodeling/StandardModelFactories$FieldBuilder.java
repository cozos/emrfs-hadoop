package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

final class StandardModelFactories$FieldBuilder<T, V>
  extends DynamoDBMapperFieldModel.Builder<T, V>
{
  private StandardModelFactories$FieldBuilder(Class<T> clazz, StandardBeanProperties.Bean<T, V> bean, StandardModelFactories.Rule<V> rule)
  {
    super(clazz, bean.properties());
    if (bean.type().attributeType() != null) {
      with(bean.type().attributeType());
    } else {
      with(rule.getAttributeType());
    }
    with(rule.newConverter(bean.type()));
    with(bean.reflect());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardModelFactories.FieldBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */