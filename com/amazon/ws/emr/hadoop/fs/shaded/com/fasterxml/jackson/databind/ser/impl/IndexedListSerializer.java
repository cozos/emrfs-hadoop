package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase;
import java.io.IOException;
import java.util.List;

@JacksonStdImpl
public final class IndexedListSerializer
  extends AsArraySerializerBase<List<?>>
{
  private static final long serialVersionUID = 1L;
  
  public IndexedListSerializer(JavaType elemType, boolean staticTyping, TypeSerializer vts, JsonSerializer<Object> valueSerializer)
  {
    super(List.class, elemType, staticTyping, vts, valueSerializer);
  }
  
  public IndexedListSerializer(IndexedListSerializer src, BeanProperty property, TypeSerializer vts, JsonSerializer<?> valueSerializer, Boolean unwrapSingle)
  {
    super(src, property, vts, valueSerializer, unwrapSingle);
  }
  
  public IndexedListSerializer withResolved(BeanProperty property, TypeSerializer vts, JsonSerializer<?> elementSerializer, Boolean unwrapSingle)
  {
    return new IndexedListSerializer(this, property, vts, elementSerializer, unwrapSingle);
  }
  
  public boolean isEmpty(SerializerProvider prov, List<?> value)
  {
    return (value == null) || (value.isEmpty());
  }
  
  public boolean hasSingleElement(List<?> value)
  {
    return value.size() == 1;
  }
  
  public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer vts)
  {
    return new IndexedListSerializer(this, _property, vts, _elementSerializer, _unwrapSingle);
  }
  
  public final void serialize(List<?> value, JsonGenerator gen, SerializerProvider provider)
    throws IOException
  {
    int len = value.size();
    if ((len == 1) && (
      ((_unwrapSingle == null) && (provider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED))) || (_unwrapSingle == Boolean.TRUE)))
    {
      serializeContents(value, gen, provider);
      return;
    }
    gen.writeStartArray(len);
    serializeContents(value, gen, provider);
    gen.writeEndArray();
  }
  
  public void serializeContents(List<?> value, JsonGenerator jgen, SerializerProvider provider)
    throws IOException
  {
    if (_elementSerializer != null)
    {
      serializeContentsUsing(value, jgen, provider, _elementSerializer);
      return;
    }
    if (_valueTypeSerializer != null)
    {
      serializeTypedContents(value, jgen, provider);
      return;
    }
    int len = value.size();
    if (len == 0) {
      return;
    }
    int i = 0;
    try
    {
      PropertySerializerMap serializers = _dynamicSerializers;
      for (; i < len; i++)
      {
        Object elem = value.get(i);
        if (elem == null)
        {
          provider.defaultSerializeNull(jgen);
        }
        else
        {
          Class<?> cc = elem.getClass();
          JsonSerializer<Object> serializer = serializers.serializerFor(cc);
          if (serializer == null)
          {
            if (_elementType.hasGenericTypes()) {
              serializer = _findAndAddDynamic(serializers, provider.constructSpecializedType(_elementType, cc), provider);
            } else {
              serializer = _findAndAddDynamic(serializers, cc, provider);
            }
            serializers = _dynamicSerializers;
          }
          serializer.serialize(elem, jgen, provider);
        }
      }
    }
    catch (Exception e)
    {
      wrapAndThrow(provider, e, value, i);
    }
  }
  
  public void serializeContentsUsing(List<?> value, JsonGenerator jgen, SerializerProvider provider, JsonSerializer<Object> ser)
    throws IOException
  {
    int len = value.size();
    if (len == 0) {
      return;
    }
    TypeSerializer typeSer = _valueTypeSerializer;
    for (int i = 0; i < len; i++)
    {
      Object elem = value.get(i);
      try
      {
        if (elem == null) {
          provider.defaultSerializeNull(jgen);
        } else if (typeSer == null) {
          ser.serialize(elem, jgen, provider);
        } else {
          ser.serializeWithType(elem, jgen, provider, typeSer);
        }
      }
      catch (Exception e)
      {
        wrapAndThrow(provider, e, value, i);
      }
    }
  }
  
  public void serializeTypedContents(List<?> value, JsonGenerator jgen, SerializerProvider provider)
    throws IOException
  {
    int len = value.size();
    if (len == 0) {
      return;
    }
    int i = 0;
    try
    {
      TypeSerializer typeSer = _valueTypeSerializer;
      PropertySerializerMap serializers = _dynamicSerializers;
      for (; i < len; i++)
      {
        Object elem = value.get(i);
        if (elem == null)
        {
          provider.defaultSerializeNull(jgen);
        }
        else
        {
          Class<?> cc = elem.getClass();
          JsonSerializer<Object> serializer = serializers.serializerFor(cc);
          if (serializer == null)
          {
            if (_elementType.hasGenericTypes()) {
              serializer = _findAndAddDynamic(serializers, provider.constructSpecializedType(_elementType, cc), provider);
            } else {
              serializer = _findAndAddDynamic(serializers, cc, provider);
            }
            serializers = _dynamicSerializers;
          }
          serializer.serializeWithType(elem, jgen, provider, typeSer);
        }
      }
    }
    catch (Exception e)
    {
      wrapAndThrow(provider, e, value, i);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.IndexedListSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */