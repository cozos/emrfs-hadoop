package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class StandardTypeConverters$Vector
{
  static final ToList LIST = new ToList();
  
  abstract boolean is(Class<?> paramClass);
  
  static final class ToList
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
  
  static final ToMap MAP = new ToMap();
  
  static final class ToMap
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
  
  static final ToSet SET = new ToSet();
  
  static final class ToSet
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardTypeConverters.Vector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */