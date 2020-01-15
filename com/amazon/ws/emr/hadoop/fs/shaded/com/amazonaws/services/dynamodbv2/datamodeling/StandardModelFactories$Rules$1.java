package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;

class StandardModelFactories$Rules$1
  extends DynamoDBTypeConverter.DelegateConverter<AttributeValue, T>
{
  StandardModelFactories$Rules$1(StandardModelFactories.Rules this$0, DynamoDBTypeConverter delegate)
  {
    super(delegate);
  }
  
  public final AttributeValue convert(T o)
  {
    return o == null ? new AttributeValue().withNULL(Boolean.valueOf(true)) : (AttributeValue)super.convert(o);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardModelFactories.Rules.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */