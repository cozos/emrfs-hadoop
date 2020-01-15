package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import java.util.Collection;
import java.util.List;

class StandardModelFactories$Rules$StringScalarSet
  extends StandardModelFactories.AbstractRule<List<String>, Collection<T>>
{
  private StandardModelFactories$Rules$StringScalarSet(StandardModelFactories.Rules paramRules, boolean supported)
  {
    super(DynamoDBMapperFieldModel.DynamoDBAttributeType.SS, supported);
  }
  
  public boolean isAssignableFrom(ConvertibleType<?> type)
  {
    return (super.isAssignableFrom(type)) && ((type.attributeType() != null) || (type.is(ScalarAttributeType.S, StandardTypeConverters.Vector.SET)));
  }
  
  public DynamoDBTypeConverter<AttributeValue, Collection<T>> newConverter(ConvertibleType<Collection<T>> type)
  {
    return joinAll(new DynamoDBTypeConverter[] { StandardTypeConverters.Vector.SET.join(StandardModelFactories.Rules.access$2400(this$0, String.class, type.param(0))), type.typeConverter() });
  }
  
  public List<String> get(AttributeValue value)
  {
    return value.getSS();
  }
  
  public void set(AttributeValue value, List<String> o)
  {
    value.setSS(o);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardModelFactories.Rules.StringScalarSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */