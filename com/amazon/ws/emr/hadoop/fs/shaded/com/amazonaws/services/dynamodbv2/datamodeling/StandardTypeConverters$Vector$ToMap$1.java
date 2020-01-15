package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.Map;

class StandardTypeConverters$Vector$ToMap$1
  implements DynamoDBTypeConverter<Map<K, S>, Map<K, T>>
{
  StandardTypeConverters$Vector$ToMap$1(StandardTypeConverters.Vector.ToMap this$0, DynamoDBTypeConverter paramDynamoDBTypeConverter) {}
  
  public final Map<K, S> convert(Map<K, T> o)
  {
    return StandardTypeConverters.Vector.MAP.convert(o, val$scalar);
  }
  
  public final Map<K, T> unconvert(Map<K, S> o)
  {
    return StandardTypeConverters.Vector.MAP.unconvert(o, val$scalar);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.Vector.ToMap.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */