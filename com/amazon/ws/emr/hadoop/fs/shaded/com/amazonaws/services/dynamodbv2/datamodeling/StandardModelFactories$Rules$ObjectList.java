package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.List;

class StandardModelFactories$Rules$ObjectList
  extends StandardModelFactories.AbstractRule<List<AttributeValue>, List<T>>
{
  private StandardModelFactories$Rules$ObjectList(StandardModelFactories.Rules paramRules, boolean supported)
  {
    super(DynamoDBMapperFieldModel.DynamoDBAttributeType.L, supported);
  }
  
  public boolean isAssignableFrom(ConvertibleType<?> type)
  {
    return (super.isAssignableFrom(type)) && (type.param(0) != null) && (type.is(StandardTypeConverters.Vector.LIST));
  }
  
  public DynamoDBTypeConverter<AttributeValue, List<T>> newConverter(ConvertibleType<List<T>> type)
  {
    return joinAll(new DynamoDBTypeConverter[] { StandardTypeConverters.Vector.LIST.join(StandardModelFactories.Rules.access$2700(this$0, type.param(0))), type.typeConverter() });
  }
  
  public List<AttributeValue> get(AttributeValue value)
  {
    return value.getL();
  }
  
  public void set(AttributeValue value, List<AttributeValue> o)
  {
    value.setL(o);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardModelFactories.Rules.ObjectList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */