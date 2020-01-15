package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import java.util.Arrays;

public abstract class PropertySerializerMap
{
  protected final boolean _resetWhenFull;
  
  protected PropertySerializerMap(boolean resetWhenFull)
  {
    _resetWhenFull = resetWhenFull;
  }
  
  protected PropertySerializerMap(PropertySerializerMap base)
  {
    _resetWhenFull = _resetWhenFull;
  }
  
  public abstract JsonSerializer<Object> serializerFor(Class<?> paramClass);
  
  public final SerializerAndMapResult findAndAddPrimarySerializer(Class<?> type, SerializerProvider provider, BeanProperty property)
    throws JsonMappingException
  {
    JsonSerializer<Object> serializer = provider.findPrimaryPropertySerializer(type, property);
    return new SerializerAndMapResult(serializer, newWith(type, serializer));
  }
  
  public final SerializerAndMapResult findAndAddPrimarySerializer(JavaType type, SerializerProvider provider, BeanProperty property)
    throws JsonMappingException
  {
    JsonSerializer<Object> serializer = provider.findPrimaryPropertySerializer(type, property);
    return new SerializerAndMapResult(serializer, newWith(type.getRawClass(), serializer));
  }
  
  public final SerializerAndMapResult findAndAddSecondarySerializer(Class<?> type, SerializerProvider provider, BeanProperty property)
    throws JsonMappingException
  {
    JsonSerializer<Object> serializer = provider.findValueSerializer(type, property);
    return new SerializerAndMapResult(serializer, newWith(type, serializer));
  }
  
  public final SerializerAndMapResult findAndAddSecondarySerializer(JavaType type, SerializerProvider provider, BeanProperty property)
    throws JsonMappingException
  {
    JsonSerializer<Object> serializer = provider.findValueSerializer(type, property);
    return new SerializerAndMapResult(serializer, newWith(type.getRawClass(), serializer));
  }
  
  public final SerializerAndMapResult findAndAddRootValueSerializer(Class<?> type, SerializerProvider provider)
    throws JsonMappingException
  {
    JsonSerializer<Object> serializer = provider.findTypedValueSerializer(type, false, null);
    return new SerializerAndMapResult(serializer, newWith(type, serializer));
  }
  
  public final SerializerAndMapResult findAndAddRootValueSerializer(JavaType type, SerializerProvider provider)
    throws JsonMappingException
  {
    JsonSerializer<Object> serializer = provider.findTypedValueSerializer(type, false, null);
    return new SerializerAndMapResult(serializer, newWith(type.getRawClass(), serializer));
  }
  
  public final SerializerAndMapResult findAndAddKeySerializer(Class<?> type, SerializerProvider provider, BeanProperty property)
    throws JsonMappingException
  {
    JsonSerializer<Object> serializer = provider.findKeySerializer(type, property);
    return new SerializerAndMapResult(serializer, newWith(type, serializer));
  }
  
  public final SerializerAndMapResult addSerializer(Class<?> type, JsonSerializer<Object> serializer)
  {
    return new SerializerAndMapResult(serializer, newWith(type, serializer));
  }
  
  public final SerializerAndMapResult addSerializer(JavaType type, JsonSerializer<Object> serializer)
  {
    return new SerializerAndMapResult(serializer, newWith(type.getRawClass(), serializer));
  }
  
  public abstract PropertySerializerMap newWith(Class<?> paramClass, JsonSerializer<Object> paramJsonSerializer);
  
  @Deprecated
  public static PropertySerializerMap emptyMap()
  {
    return emptyForProperties();
  }
  
  public static PropertySerializerMap emptyForProperties()
  {
    return Empty.FOR_PROPERTIES;
  }
  
  public static PropertySerializerMap emptyForRootValues()
  {
    return Empty.FOR_ROOT_VALUES;
  }
  
  public static final class SerializerAndMapResult
  {
    public final JsonSerializer<Object> serializer;
    public final PropertySerializerMap map;
    
    public SerializerAndMapResult(JsonSerializer<Object> serializer, PropertySerializerMap map)
    {
      this.serializer = serializer;
      this.map = map;
    }
  }
  
  private static final class TypeAndSerializer
  {
    public final Class<?> type;
    public final JsonSerializer<Object> serializer;
    
    public TypeAndSerializer(Class<?> type, JsonSerializer<Object> serializer)
    {
      this.type = type;
      this.serializer = serializer;
    }
  }
  
  private static final class Empty
    extends PropertySerializerMap
  {
    public static final Empty FOR_PROPERTIES = new Empty(false);
    public static final Empty FOR_ROOT_VALUES = new Empty(true);
    
    protected Empty(boolean resetWhenFull)
    {
      super();
    }
    
    public JsonSerializer<Object> serializerFor(Class<?> type)
    {
      return null;
    }
    
    public PropertySerializerMap newWith(Class<?> type, JsonSerializer<Object> serializer)
    {
      return new PropertySerializerMap.Single(this, type, serializer);
    }
  }
  
  private static final class Single
    extends PropertySerializerMap
  {
    private final Class<?> _type;
    private final JsonSerializer<Object> _serializer;
    
    public Single(PropertySerializerMap base, Class<?> type, JsonSerializer<Object> serializer)
    {
      super();
      _type = type;
      _serializer = serializer;
    }
    
    public JsonSerializer<Object> serializerFor(Class<?> type)
    {
      if (type == _type) {
        return _serializer;
      }
      return null;
    }
    
    public PropertySerializerMap newWith(Class<?> type, JsonSerializer<Object> serializer)
    {
      return new PropertySerializerMap.Double(this, _type, _serializer, type, serializer);
    }
  }
  
  private static final class Double
    extends PropertySerializerMap
  {
    private final Class<?> _type1;
    private final Class<?> _type2;
    private final JsonSerializer<Object> _serializer1;
    private final JsonSerializer<Object> _serializer2;
    
    public Double(PropertySerializerMap base, Class<?> type1, JsonSerializer<Object> serializer1, Class<?> type2, JsonSerializer<Object> serializer2)
    {
      super();
      _type1 = type1;
      _serializer1 = serializer1;
      _type2 = type2;
      _serializer2 = serializer2;
    }
    
    public JsonSerializer<Object> serializerFor(Class<?> type)
    {
      if (type == _type1) {
        return _serializer1;
      }
      if (type == _type2) {
        return _serializer2;
      }
      return null;
    }
    
    public PropertySerializerMap newWith(Class<?> type, JsonSerializer<Object> serializer)
    {
      PropertySerializerMap.TypeAndSerializer[] ts = new PropertySerializerMap.TypeAndSerializer[3];
      ts[0] = new PropertySerializerMap.TypeAndSerializer(_type1, _serializer1);
      ts[1] = new PropertySerializerMap.TypeAndSerializer(_type2, _serializer2);
      ts[2] = new PropertySerializerMap.TypeAndSerializer(type, serializer);
      return new PropertySerializerMap.Multi(this, ts);
    }
  }
  
  private static final class Multi
    extends PropertySerializerMap
  {
    private static final int MAX_ENTRIES = 8;
    private final PropertySerializerMap.TypeAndSerializer[] _entries;
    
    public Multi(PropertySerializerMap base, PropertySerializerMap.TypeAndSerializer[] entries)
    {
      super();
      _entries = entries;
    }
    
    public JsonSerializer<Object> serializerFor(Class<?> type)
    {
      int i = 0;
      for (int len = _entries.length; i < len; i++)
      {
        PropertySerializerMap.TypeAndSerializer entry = _entries[i];
        if (type == type) {
          return serializer;
        }
      }
      return null;
    }
    
    public PropertySerializerMap newWith(Class<?> type, JsonSerializer<Object> serializer)
    {
      int len = _entries.length;
      if (len == 8)
      {
        if (_resetWhenFull) {
          return new PropertySerializerMap.Single(this, type, serializer);
        }
        return this;
      }
      PropertySerializerMap.TypeAndSerializer[] entries = (PropertySerializerMap.TypeAndSerializer[])Arrays.copyOf(_entries, len + 1);
      entries[len] = new PropertySerializerMap.TypeAndSerializer(type, serializer);
      return new Multi(this, entries);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */