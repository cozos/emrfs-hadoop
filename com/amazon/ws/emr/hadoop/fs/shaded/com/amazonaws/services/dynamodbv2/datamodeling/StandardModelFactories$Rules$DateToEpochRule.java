package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import java.util.Calendar;
import java.util.Date;

class StandardModelFactories$Rules$DateToEpochRule
  extends StandardModelFactories.AbstractRule<Long, T>
{
  private StandardModelFactories$Rules$DateToEpochRule(StandardModelFactories.Rules paramRules, boolean supported)
  {
    super(DynamoDBMapperFieldModel.DynamoDBAttributeType.N, supported);
  }
  
  public boolean isAssignableFrom(ConvertibleType<?> type)
  {
    return ((type.is(Date.class)) || (type.is(Calendar.class)) || (type.is(DateTime.class))) && 
      (super.isAssignableFrom(type)) && ((type.attributeType() != null) || (type.is(ScalarAttributeType.N)));
  }
  
  public DynamoDBTypeConverter<AttributeValue, T> newConverter(ConvertibleType<T> type)
  {
    return joinAll(new DynamoDBTypeConverter[] { StandardModelFactories.Rules.access$2400(this$0, Long.class, type), type.typeConverter() });
  }
  
  public Long get(AttributeValue value)
  {
    return Long.valueOf(value.getN());
  }
  
  public void set(AttributeValue value, Long o)
  {
    value.setN(String.valueOf(o));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardModelFactories.Rules.DateToEpochRule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */