package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.Collection;
import java.util.List;

class StandardTypeConverters$Vector$ToSet$1
  implements DynamoDBTypeConverter<List<S>, Collection<T>>
{
  StandardTypeConverters$Vector$ToSet$1(StandardTypeConverters.Vector.ToSet this$0, DynamoDBTypeConverter paramDynamoDBTypeConverter) {}
  
  public List<S> convert(Collection<T> o)
  {
    return StandardTypeConverters.Vector.LIST.convert(o, val$target);
  }
  
  public Collection<T> unconvert(List<S> o)
  {
    return StandardTypeConverters.Vector.SET.unconvert(o, val$target);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.Vector.ToSet.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */