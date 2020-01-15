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
import java.util.Iterator;

@JacksonStdImpl
public class IteratorSerializer
  extends AsArraySerializerBase<Iterator<?>>
{
  public IteratorSerializer(JavaType elemType, boolean staticTyping, TypeSerializer vts)
  {
    super(Iterator.class, elemType, staticTyping, vts, null);
  }
  
  public IteratorSerializer(IteratorSerializer src, BeanProperty property, TypeSerializer vts, JsonSerializer<?> valueSerializer, Boolean unwrapSingle)
  {
    super(src, property, vts, valueSerializer, unwrapSingle);
  }
  
  public boolean isEmpty(SerializerProvider prov, Iterator<?> value)
  {
    return (value == null) || (!value.hasNext());
  }
  
  public boolean hasSingleElement(Iterator<?> value)
  {
    return false;
  }
  
  public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer vts)
  {
    return new IteratorSerializer(this, _property, vts, _elementSerializer, _unwrapSingle);
  }
  
  public IteratorSerializer withResolved(BeanProperty property, TypeSerializer vts, JsonSerializer<?> elementSerializer, Boolean unwrapSingle)
  {
    return new IteratorSerializer(this, property, vts, elementSerializer, unwrapSingle);
  }
  
  public final void serialize(Iterator<?> value, JsonGenerator gen, SerializerProvider provider)
    throws IOException
  {
    if (((_unwrapSingle == null) && (provider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED))) || (_unwrapSingle == Boolean.TRUE)) {
      if (hasSingleElement(value))
      {
        serializeContents(value, gen, provider);
        return;
      }
    }
    gen.writeStartArray();
    serializeContents(value, gen, provider);
    gen.writeEndArray();
  }
  
  public void serializeContents(Iterator<?> value, JsonGenerator gen, SerializerProvider provider)
    throws IOException
  {
    if (value.hasNext())
    {
      TypeSerializer typeSer = _valueTypeSerializer;
      JsonSerializer<Object> prevSerializer = null;
      Class<?> prevClass = null;
      do
      {
        Object elem = value.next();
        if (elem == null)
        {
          provider.defaultSerializeNull(gen);
        }
        else
        {
          JsonSerializer<Object> currSerializer = _elementSerializer;
          if (currSerializer == null)
          {
            Class<?> cc = elem.getClass();
            if (cc == prevClass)
            {
              currSerializer = prevSerializer;
            }
            else
            {
              currSerializer = provider.findValueSerializer(cc, _property);
              prevSerializer = currSerializer;
              prevClass = cc;
            }
          }
          if (typeSer == null) {
            currSerializer.serialize(elem, gen, provider);
          } else {
            currSerializer.serializeWithType(elem, gen, provider, typeSer);
          }
        }
      } while (value.hasNext());
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.IteratorSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */