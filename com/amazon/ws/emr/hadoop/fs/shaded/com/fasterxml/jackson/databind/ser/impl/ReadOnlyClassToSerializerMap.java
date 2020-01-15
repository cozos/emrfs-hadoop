package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.TypeKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class ReadOnlyClassToSerializerMap
{
  private final Bucket[] _buckets;
  private final int _size;
  private final int _mask;
  
  public ReadOnlyClassToSerializerMap(Map<TypeKey, JsonSerializer<Object>> serializers)
  {
    int size = findSize(serializers.size());
    _size = size;
    _mask = (size - 1);
    Bucket[] buckets = new Bucket[size];
    for (Map.Entry<TypeKey, JsonSerializer<Object>> entry : serializers.entrySet())
    {
      TypeKey key = (TypeKey)entry.getKey();
      int index = key.hashCode() & _mask;
      buckets[index] = new Bucket(buckets[index], key, (JsonSerializer)entry.getValue());
    }
    _buckets = buckets;
  }
  
  private static final int findSize(int size)
  {
    int needed = size <= 64 ? size + size : size + (size >> 2);
    int result = 8;
    while (result < needed) {
      result += result;
    }
    return result;
  }
  
  public static ReadOnlyClassToSerializerMap from(HashMap<TypeKey, JsonSerializer<Object>> src)
  {
    return new ReadOnlyClassToSerializerMap(src);
  }
  
  public int size()
  {
    return _size;
  }
  
  public JsonSerializer<Object> typedValueSerializer(JavaType type)
  {
    Bucket bucket = _buckets[(TypeKey.typedHash(type) & _mask)];
    if (bucket == null) {
      return null;
    }
    if (bucket.matchesTyped(type)) {
      return value;
    }
    while ((bucket = next) != null) {
      if (bucket.matchesTyped(type)) {
        return value;
      }
    }
    return null;
  }
  
  public JsonSerializer<Object> typedValueSerializer(Class<?> type)
  {
    Bucket bucket = _buckets[(TypeKey.typedHash(type) & _mask)];
    if (bucket == null) {
      return null;
    }
    if (bucket.matchesTyped(type)) {
      return value;
    }
    while ((bucket = next) != null) {
      if (bucket.matchesTyped(type)) {
        return value;
      }
    }
    return null;
  }
  
  public JsonSerializer<Object> untypedValueSerializer(JavaType type)
  {
    Bucket bucket = _buckets[(TypeKey.untypedHash(type) & _mask)];
    if (bucket == null) {
      return null;
    }
    if (bucket.matchesUntyped(type)) {
      return value;
    }
    while ((bucket = next) != null) {
      if (bucket.matchesUntyped(type)) {
        return value;
      }
    }
    return null;
  }
  
  public JsonSerializer<Object> untypedValueSerializer(Class<?> type)
  {
    Bucket bucket = _buckets[(TypeKey.untypedHash(type) & _mask)];
    if (bucket == null) {
      return null;
    }
    if (bucket.matchesUntyped(type)) {
      return value;
    }
    while ((bucket = next) != null) {
      if (bucket.matchesUntyped(type)) {
        return value;
      }
    }
    return null;
  }
  
  private static final class Bucket
  {
    public final JsonSerializer<Object> value;
    public final Bucket next;
    protected final Class<?> _class;
    protected final JavaType _type;
    protected final boolean _isTyped;
    
    public Bucket(Bucket next, TypeKey key, JsonSerializer<Object> value)
    {
      this.next = next;
      this.value = value;
      _isTyped = key.isTyped();
      _class = key.getRawType();
      _type = key.getType();
    }
    
    public boolean matchesTyped(Class<?> key)
    {
      return (_class == key) && (_isTyped);
    }
    
    public boolean matchesUntyped(Class<?> key)
    {
      return (_class == key) && (!_isTyped);
    }
    
    public boolean matchesTyped(JavaType key)
    {
      return (_isTyped) && (key.equals(_type));
    }
    
    public boolean matchesUntyped(JavaType key)
    {
      return (!_isTyped) && (key.equals(_type));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.ReadOnlyClassToSerializerMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */