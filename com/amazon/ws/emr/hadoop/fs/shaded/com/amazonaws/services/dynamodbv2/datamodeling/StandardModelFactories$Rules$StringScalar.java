package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;

class StandardModelFactories$Rules$StringScalar
  extends StandardModelFactories.AbstractRule<String, T>
{
  private StandardModelFactories$Rules$StringScalar(StandardModelFactories.Rules paramRules, boolean supported)
  {
    super(DynamoDBMapperFieldModel.DynamoDBAttributeType.S, supported);
  }
  
  public boolean isAssignableFrom(ConvertibleType<?> type)
  {
    return (super.isAssignableFrom(type)) && ((type.attributeType() != null) || (type.is(ScalarAttributeType.S)));
  }
  
  public DynamoDBTypeConverter<AttributeValue, T> newConverter(ConvertibleType<T> type)
  {
    return joinAll(new DynamoDBTypeConverter[] { StandardModelFactories.Rules.access$2400(this$0, String.class, type), type.typeConverter() });
  }
  
  public String get(AttributeValue value)
  {
    return value.getS();
  }
  
  public void set(AttributeValue value, String o)
  {
    value.setS(o);
  }
  
  public AttributeValue convert(String o)
  {
    return o.length() == 0 ? null : super.convert(o);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardModelFactories.Rules.StringScalar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */