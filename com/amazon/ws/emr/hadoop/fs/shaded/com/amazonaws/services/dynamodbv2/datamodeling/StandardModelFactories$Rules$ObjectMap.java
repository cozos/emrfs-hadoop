package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.Map;

class StandardModelFactories$Rules$ObjectMap
  extends StandardModelFactories.AbstractRule<Map<String, AttributeValue>, Map<String, T>>
{
  private StandardModelFactories$Rules$ObjectMap(StandardModelFactories.Rules paramRules, boolean supported)
  {
    super(DynamoDBMapperFieldModel.DynamoDBAttributeType.M, supported);
  }
  
  public boolean isAssignableFrom(ConvertibleType<?> type)
  {
    return (super.isAssignableFrom(type)) && (type.param(1) != null) && (type.is(StandardTypeConverters.Vector.MAP)) && (type.param(0).is(StandardTypeConverters.Scalar.STRING));
  }
  
  public DynamoDBTypeConverter<AttributeValue, Map<String, T>> newConverter(ConvertibleType<Map<String, T>> type)
  {
    return joinAll(new DynamoDBTypeConverter[] {StandardTypeConverters.Vector.MAP
      .join(StandardModelFactories.Rules.access$2700(this$0, type.param(1))), type
      .typeConverter() });
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardModelFactories.Rules.ObjectMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */