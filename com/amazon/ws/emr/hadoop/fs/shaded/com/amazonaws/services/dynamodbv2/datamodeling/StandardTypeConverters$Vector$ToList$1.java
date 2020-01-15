package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.List;

class StandardTypeConverters$Vector$ToList$1
  implements DynamoDBTypeConverter<List<S>, List<T>>
{
  StandardTypeConverters$Vector$ToList$1(StandardTypeConverters.Vector.ToList this$0, DynamoDBTypeConverter paramDynamoDBTypeConverter) {}
  
  public final List<S> convert(List<T> o)
  {
    return StandardTypeConverters.Vector.LIST.convert(o, val$scalar);
  }
  
  public final List<T> unconvert(List<S> o)
  {
    return StandardTypeConverters.Vector.LIST.unconvert(o, val$scalar);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.Vector.ToList.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */