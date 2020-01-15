package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.ContainerSerializer;
import java.io.IOException;
import java.util.Iterator;

@JacksonStdImpl
public class IterableSerializer
  extends AsArraySerializerBase<Iterable<?>>
{
  public IterableSerializer(JavaType elemType, boolean staticTyping, TypeSerializer vts)
  {
    super(Iterable.class, elemType, staticTyping, vts, null);
  }
  
  public IterableSerializer(IterableSerializer src, BeanProperty property, TypeSerializer vts, JsonSerializer<?> valueSerializer, Boolean unwrapSingle)
  {
    super(src, property, vts, valueSerializer, unwrapSingle);
  }
  
  public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer vts)
  {
    return new IterableSerializer(this, _property, vts, _elementSerializer, _unwrapSingle);
  }
  
  public IterableSerializer withResolved(BeanProperty property, TypeSerializer vts, JsonSerializer<?> elementSerializer, Boolean unwrapSingle)
  {
    return new IterableSerializer(this, property, vts, elementSerializer, unwrapSingle);
  }
  
  public boolean isEmpty(SerializerProvider prov, Iterable<?> value)
  {
    return (value == null) || (!value.iterator().hasNext());
  }
  
  public boolean hasSingleElement(Iterable<?> value)
  {
    if (value != null)
    {
      Iterator<?> it = value.iterator();
      if (it.hasNext())
      {
        it.next();
        if (!it.hasNext()) {
          return true;
        }
      }
    }
    return false;
  }
  
  public final void serialize(Iterable<?> value, JsonGenerator gen, SerializerProvider provider)
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
  
  public void serializeContents(Iterable<?> value, JsonGenerator jgen, SerializerProvider provider)
    throws IOException
  {
    Iterator<?> it = value.iterator();
    if (it.hasNext())
    {
      TypeSerializer typeSer = _valueTypeSerializer;
      JsonSerializer<Object> prevSerializer = null;
      Class<?> prevClass = null;
      do
      {
        Object elem = it.next();
        if (elem == null)
        {
          provider.defaultSerializeNull(jgen);
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
            currSerializer.serialize(elem, jgen, provider);
          } else {
            currSerializer.serializeWithType(elem, jgen, provider, typeSer);
          }
        }
      } while (it.hasNext());
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.IterableSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */