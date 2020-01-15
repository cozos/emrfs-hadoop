package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

final class StandardTypeConverters$Vector$ToSet
  extends StandardTypeConverters.Vector
{
  <S, T> DynamoDBTypeConverter<List<S>, Collection<T>> join(final DynamoDBTypeConverter<S, T> target)
  {
    new DynamoDBTypeConverter()
    {
      public List<S> convert(Collection<T> o)
      {
        return StandardTypeConverters.Vector.LIST.convert(o, target);
      }
      
      public Collection<T> unconvert(List<S> o)
      {
        return StandardTypeConverters.Vector.SET.unconvert(o, target);
      }
    };
  }
  
  <S, T> Set<T> unconvert(Collection<S> o, DynamoDBTypeConverter<S, T> scalar)
  {
    Set<T> vector = new LinkedHashSet();
    for (S s : o) {
      if (!vector.add(scalar.unconvert(s))) {
        throw new DynamoDBMappingException("duplicate value (" + s + ")");
      }
    }
    return vector;
  }
  
  boolean is(Class<?> type)
  {
    return Set.class.isAssignableFrom(type);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.Vector.ToSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */