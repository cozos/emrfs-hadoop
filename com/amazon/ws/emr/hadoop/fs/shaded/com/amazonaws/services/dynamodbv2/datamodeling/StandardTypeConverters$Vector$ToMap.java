package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

final class StandardTypeConverters$Vector$ToMap
  extends StandardTypeConverters.Vector
{
  <K, S, T> DynamoDBTypeConverter<Map<K, S>, Map<K, T>> join(final DynamoDBTypeConverter<S, T> scalar)
  {
    new DynamoDBTypeConverter()
    {
      public final Map<K, S> convert(Map<K, T> o)
      {
        return StandardTypeConverters.Vector.MAP.convert(o, scalar);
      }
      
      public final Map<K, T> unconvert(Map<K, S> o)
      {
        return StandardTypeConverters.Vector.MAP.unconvert(o, scalar);
      }
    };
  }
  
  <K, S, T> Map<K, S> convert(Map<K, T> o, DynamoDBTypeConverter<S, T> scalar)
  {
    Map<K, S> vector = new LinkedHashMap();
    for (Map.Entry<K, T> t : o.entrySet()) {
      vector.put(t.getKey(), scalar.convert(t.getValue()));
    }
    return vector;
  }
  
  <K, S, T> Map<K, T> unconvert(Map<K, S> o, DynamoDBTypeConverter<S, T> scalar)
  {
    Map<K, T> vector = new LinkedHashMap();
    for (Map.Entry<K, S> s : o.entrySet()) {
      vector.put(s.getKey(), scalar.unconvert(s.getValue()));
    }
    return vector;
  }
  
  boolean is(Class<?> type)
  {
    return Map.class.isAssignableFrom(type);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.Vector.ToMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */