package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonFormat.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.ContextualSerializer;
import java.io.IOException;

public abstract class ArraySerializerBase<T>
  extends ContainerSerializer<T>
  implements ContextualSerializer
{
  protected final BeanProperty _property;
  protected final Boolean _unwrapSingle;
  
  protected ArraySerializerBase(Class<T> cls)
  {
    super(cls);
    _property = null;
    _unwrapSingle = null;
  }
  
  @Deprecated
  protected ArraySerializerBase(Class<T> cls, BeanProperty property)
  {
    super(cls);
    _property = property;
    _unwrapSingle = null;
  }
  
  protected ArraySerializerBase(ArraySerializerBase<?> src)
  {
    super(_handledType, false);
    _property = _property;
    _unwrapSingle = _unwrapSingle;
  }
  
  protected ArraySerializerBase(ArraySerializerBase<?> src, BeanProperty property, Boolean unwrapSingle)
  {
    super(_handledType, false);
    _property = property;
    _unwrapSingle = unwrapSingle;
  }
  
  @Deprecated
  protected ArraySerializerBase(ArraySerializerBase<?> src, BeanProperty property)
  {
    super(_handledType, false);
    _property = property;
    _unwrapSingle = _unwrapSingle;
  }
  
  public abstract JsonSerializer<?> _withResolved(BeanProperty paramBeanProperty, Boolean paramBoolean);
  
  public JsonSerializer<?> createContextual(SerializerProvider provider, BeanProperty property)
    throws JsonMappingException
  {
    Boolean unwrapSingle = null;
    if (property != null)
    {
      AnnotationIntrospector intr = provider.getAnnotationIntrospector();
      JsonFormat.Value format = property.findFormatOverrides(intr);
      if (format != null)
      {
        unwrapSingle = format.getFeature(JsonFormat.Feature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
        if (unwrapSingle != _unwrapSingle) {
          return _withResolved(property, unwrapSingle);
        }
      }
    }
    return this;
  }
  
  public void serialize(T value, JsonGenerator gen, SerializerProvider provider)
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
    
    gen.setCurrentValue(value);
    serializeContents(value, gen, provider);
    gen.writeEndArray();
  }
  
  public final void serializeWithType(T value, JsonGenerator gen, SerializerProvider provider, TypeSerializer typeSer)
    throws IOException
  {
    typeSer.writeTypePrefixForArray(value, gen);
    
    gen.setCurrentValue(value);
    serializeContents(value, gen, provider);
    typeSer.writeTypeSuffixForArray(value, gen);
  }
  
  protected abstract void serializeContents(T paramT, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */