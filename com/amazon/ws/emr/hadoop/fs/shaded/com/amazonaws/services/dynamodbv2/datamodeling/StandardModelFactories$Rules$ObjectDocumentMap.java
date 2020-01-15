package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.Map;

class StandardModelFactories$Rules$ObjectDocumentMap
  extends StandardModelFactories.AbstractRule<Map<String, AttributeValue>, T>
{
  private final DynamoDBMapperModelFactory models;
  private final DynamoDBMapperConfig config;
  
  private StandardModelFactories$Rules$ObjectDocumentMap(StandardModelFactories.Rules paramRules, boolean supported, DynamoDBMapperModelFactory models, DynamoDBMapperConfig config)
  {
    super(DynamoDBMapperFieldModel.DynamoDBAttributeType.M, supported);
    this.models = models;
    this.config = config;
  }
  
  public boolean isAssignableFrom(ConvertibleType<?> type)
  {
    return (type.attributeType() == getAttributeType()) && (supported) && (!type.is(StandardTypeConverters.Vector.MAP));
  }
  
  public DynamoDBTypeConverter<AttributeValue, T> newConverter(final ConvertibleType<T> type)
  {
    joinAll(new DynamoDBTypeConverter[] { new DynamoDBTypeConverter()
    {
      public final Map<String, AttributeValue> convert(T o)
      {
        return models.getTableFactory(config).getTable(type.targetType()).convert(o);
      }
      
      public final T unconvert(Map<String, AttributeValue> o)
      {
        return (T)models.getTableFactory(config).getTable(type.targetType()).unconvert(o);
      }
    }, type.typeConverter() });
  }
  
  public Map<String, AttributeValue> get(AttributeValue value)
  {
    return value.getM();
  }
  
  public void set(AttributeValue value, Map<String, AttributeValue> o)
  {
    value.setM(o);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardModelFactories.Rules.ObjectDocumentMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */