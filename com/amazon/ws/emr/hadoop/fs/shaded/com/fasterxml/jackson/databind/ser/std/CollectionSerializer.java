package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public class CollectionSerializer
  extends AsArraySerializerBase<Collection<?>>
{
  private static final long serialVersionUID = 1L;
  
  public CollectionSerializer(JavaType elemType, boolean staticTyping, TypeSerializer vts, JsonSerializer<Object> valueSerializer)
  {
    super(Collection.class, elemType, staticTyping, vts, valueSerializer);
  }
  
  @Deprecated
  public CollectionSerializer(JavaType elemType, boolean staticTyping, TypeSerializer vts, BeanProperty property, JsonSerializer<Object> valueSerializer)
  {
    this(elemType, staticTyping, vts, valueSerializer);
  }
  
  public CollectionSerializer(CollectionSerializer src, BeanProperty property, TypeSerializer vts, JsonSerializer<?> valueSerializer, Boolean unwrapSingle)
  {
    super(src, property, vts, valueSerializer, unwrapSingle);
  }
  
  public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer vts)
  {
    return new CollectionSerializer(this, _property, vts, _elementSerializer, _unwrapSingle);
  }
  
  public CollectionSerializer withResolved(BeanProperty property, TypeSerializer vts, JsonSerializer<?> elementSerializer, Boolean unwrapSingle)
  {
    return new CollectionSerializer(this, property, vts, elementSerializer, unwrapSingle);
  }
  
  public boolean isEmpty(SerializerProvider prov, Collection<?> value)
  {
    return (value == null) || (value.isEmpty());
  }
  
  public boolean hasSingleElement(Collection<?> value)
  {
    Iterator<?> it = value.iterator();
    if (!it.hasNext()) {
      return false;
    }
    it.next();
    return !it.hasNext();
  }
  
  public final void serialize(Collection<?> value, JsonGenerator jgen, SerializerProvider provider)
    throws IOException
  {
    int len = value.size();
    if ((len == 1) && (
      ((_unwrapSingle == null) && (provider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED))) || (_unwrapSingle == Boolean.TRUE)))
    {
      serializeContents(value, jgen, provider);
      return;
    }
    jgen.writeStartArray(len);
    serializeContents(value, jgen, provider);
    jgen.writeEndArray();
  }
  
  public void serializeContents(Collection<?> value, JsonGenerator jgen, SerializerProvider provider)
    throws IOException
  {
    if (_elementSerializer != null)
    {
      serializeContentsUsing(value, jgen, provider, _elementSerializer);
      return;
    }
    Iterator<?> it = value.iterator();
    if (!it.hasNext()) {
      return;
    }
    PropertySerializerMap serializers = _dynamicSerializers;
    TypeSerializer typeSer = _valueTypeSerializer;
    
    int i = 0;
    try
    {
      do
      {
        Object elem = it.next();
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
          if (typeSer == null) {
            serializer.serialize(elem, jgen, provider);
          } else {
            serializer.serializeWithType(elem, jgen, provider, typeSer);
          }
        }
        i++;
      } while (it.hasNext());
    }
    catch (Exception e)
    {
      wrapAndThrow(provider, e, value, i);
    }
  }
  
  public void serializeContentsUsing(Collection<?> value, JsonGenerator jgen, SerializerProvider provider, JsonSerializer<Object> ser)
    throws IOException, JsonGenerationException
  {
    Iterator<?> it = value.iterator();
    if (it.hasNext())
    {
      TypeSerializer typeSer = _valueTypeSerializer;
      int i = 0;
      do
      {
        Object elem = it.next();
        try
        {
          if (elem == null) {
            provider.defaultSerializeNull(jgen);
          } else if (typeSer == null) {
            ser.serialize(elem, jgen, provider);
          } else {
            ser.serializeWithType(elem, jgen, provider, typeSer);
          }
          i++;
        }
        catch (Exception e)
        {
          wrapAndThrow(provider, e, value, i);
        }
      } while (it.hasNext());
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.CollectionSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */