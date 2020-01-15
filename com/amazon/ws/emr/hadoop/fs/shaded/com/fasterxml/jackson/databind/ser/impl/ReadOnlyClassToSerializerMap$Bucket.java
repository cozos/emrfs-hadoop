package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.TypeKey;

final class ReadOnlyClassToSerializerMap$Bucket
{
  public final JsonSerializer<Object> value;
  public final Bucket next;
  protected final Class<?> _class;
  protected final JavaType _type;
  protected final boolean _isTyped;
  
  public ReadOnlyClassToSerializerMap$Bucket(Bucket next, TypeKey key, JsonSerializer<Object> value)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.ReadOnlyClassToSerializerMap.Bucket
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */