package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import java.util.Collection;

class StandardModelFactories$Rules$ObjectStringSet
  extends StandardModelFactories.Rules<T>.StringScalarSet
{
  private StandardModelFactories$Rules$ObjectStringSet(StandardModelFactories.Rules paramRules, boolean supported)
  {
    super(paramRules, supported, null);
  }
  
  public boolean isAssignableFrom(ConvertibleType<?> type)
  {
    return (type.attributeType() == null) && (supported) && (type.is(StandardTypeConverters.Vector.SET));
  }
  
  public DynamoDBTypeConverter<AttributeValue, Collection<T>> newConverter(ConvertibleType<Collection<T>> type)
  {
    StandardModelFactories.access$2500().warn("Marshaling a set of non-String objects to a DynamoDB StringSet. You won't be able to read these objects back out of DynamoDB unless you REALLY know what you're doing: it's probably a bug. If you DO know what you're doing feelfree to ignore this warning, but consider using a custom marshaler for this instead.");
    
    return joinAll(new DynamoDBTypeConverter[] { StandardTypeConverters.Vector.SET.join(StandardModelFactories.Rules.access$2600(this$0).getConverter(String.class, StandardTypeConverters.Scalar.DEFAULT.type())), type.typeConverter() });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardModelFactories.Rules.ObjectStringSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */