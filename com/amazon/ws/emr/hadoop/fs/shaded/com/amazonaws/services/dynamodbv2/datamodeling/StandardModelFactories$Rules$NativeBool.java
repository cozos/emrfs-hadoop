package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;

class StandardModelFactories$Rules$NativeBool
  extends StandardModelFactories.AbstractRule<Boolean, T>
{
  private StandardModelFactories$Rules$NativeBool(StandardModelFactories.Rules paramRules, boolean supported)
  {
    super(DynamoDBMapperFieldModel.DynamoDBAttributeType.BOOL, supported);
  }
  
  public boolean isAssignableFrom(ConvertibleType<?> type)
  {
    return (super.isAssignableFrom(type)) && (type.is(StandardTypeConverters.Scalar.BOOLEAN));
  }
  
  public DynamoDBTypeConverter<AttributeValue, T> newConverter(ConvertibleType<T> type)
  {
    return joinAll(new DynamoDBTypeConverter[] { StandardModelFactories.Rules.access$2400(this$0, Boolean.class, type), type.typeConverter() });
  }
  
  public Boolean get(AttributeValue o)
  {
    return o.getBOOL();
  }
  
  public void set(AttributeValue o, Boolean value)
  {
    o.setBOOL(value);
  }
  
  public Boolean unconvert(AttributeValue o)
  {
    if ((o.getBOOL() == null) && (o.getN() != null)) {
      return (Boolean)StandardTypeConverters.Scalar.BOOLEAN.convert(o.getN());
    }
    return (Boolean)super.unconvert(o);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardModelFactories.Rules.NativeBool
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */