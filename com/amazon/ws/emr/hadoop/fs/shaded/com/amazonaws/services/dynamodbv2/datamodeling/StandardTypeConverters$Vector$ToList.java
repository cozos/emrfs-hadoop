package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

final class StandardTypeConverters$Vector$ToList
  extends StandardTypeConverters.Vector
{
  <S, T> DynamoDBTypeConverter<List<S>, List<T>> join(final DynamoDBTypeConverter<S, T> scalar)
  {
    new DynamoDBTypeConverter()
    {
      public final List<S> convert(List<T> o)
      {
        return StandardTypeConverters.Vector.LIST.convert(o, scalar);
      }
      
      public final List<T> unconvert(List<S> o)
      {
        return StandardTypeConverters.Vector.LIST.unconvert(o, scalar);
      }
    };
  }
  
  <S, T> List<S> convert(Collection<T> o, DynamoDBTypeConverter<S, T> scalar)
  {
    List<S> vector = new ArrayList(o.size());
    for (T t : o) {
      vector.add(scalar.convert(t));
    }
    return vector;
  }
  
  <S, T> List<T> unconvert(Collection<S> o, DynamoDBTypeConverter<S, T> scalar)
  {
    List<T> vector = new ArrayList(o.size());
    for (S s : o) {
      vector.add(scalar.unconvert(s));
    }
    return vector;
  }
  
  boolean is(Class<?> type)
  {
    return List.class.isAssignableFrom(type);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.Vector.ToList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */