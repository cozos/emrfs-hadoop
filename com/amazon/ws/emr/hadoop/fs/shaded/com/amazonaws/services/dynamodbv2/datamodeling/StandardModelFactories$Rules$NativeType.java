package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;

class StandardModelFactories$Rules$NativeType
  extends StandardModelFactories.AbstractRule<AttributeValue, T>
{
  private StandardModelFactories$Rules$NativeType(StandardModelFactories.Rules paramRules, boolean supported)
  {
    super(DynamoDBMapperFieldModel.DynamoDBAttributeType.NULL, supported);
  }
  
  public boolean isAssignableFrom(ConvertibleType<?> type)
  {
    return (supported) && (type.is(AttributeValue.class));
  }
  
  public DynamoDBTypeConverter<AttributeValue, T> newConverter(ConvertibleType<T> type)
  {
    return joinAll(new DynamoDBTypeConverter[] { type.typeConverter() });
  }
  
  public AttributeValue get(AttributeValue o)
  {
    return o;
  }
  
  public void set(AttributeValue value, AttributeValue o)
  {
    value.withS(o.getS()).withN(o.getN()).withB(o.getB()).withSS(o.getSS()).withNS(o.getNS()).withBS(o.getBS()).withBOOL(o.getBOOL()).withL(o.getL()).withM(o.getM()).withNULL(o.getNULL());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardModelFactories.Rules.NativeType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */