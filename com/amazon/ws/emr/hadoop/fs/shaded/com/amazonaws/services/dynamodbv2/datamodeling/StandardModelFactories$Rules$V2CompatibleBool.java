package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;

class StandardModelFactories$Rules$V2CompatibleBool
  extends StandardModelFactories.AbstractRule<String, T>
{
  private StandardModelFactories$Rules$V2CompatibleBool(StandardModelFactories.Rules paramRules, boolean supported)
  {
    super(DynamoDBMapperFieldModel.DynamoDBAttributeType.N, supported);
  }
  
  public boolean isAssignableFrom(ConvertibleType<?> type)
  {
    return (super.isAssignableFrom(type)) && (type.is(StandardTypeConverters.Scalar.BOOLEAN));
  }
  
  public DynamoDBTypeConverter<AttributeValue, T> newConverter(ConvertibleType<T> type)
  {
    return joinAll(new DynamoDBTypeConverter[] { StandardModelFactories.Rules.access$2400(this$0, String.class, type), type.typeConverter() });
  }
  
  public String get(AttributeValue o)
  {
    if (o.getBOOL() != null) {
      return o.getBOOL().booleanValue() ? "1" : "0";
    }
    return o.getN();
  }
  
  public void set(AttributeValue o, String value)
  {
    o.setN(value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardModelFactories.Rules.V2CompatibleBool
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */