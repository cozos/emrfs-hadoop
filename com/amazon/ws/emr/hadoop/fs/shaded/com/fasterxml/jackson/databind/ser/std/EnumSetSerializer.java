package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;
import java.util.EnumSet;

public class EnumSetSerializer
  extends AsArraySerializerBase<EnumSet<? extends Enum<?>>>
{
  public EnumSetSerializer(JavaType elemType)
  {
    super(EnumSet.class, elemType, true, null, null);
  }
  
  @Deprecated
  public EnumSetSerializer(JavaType elemType, BeanProperty property)
  {
    this(elemType);
  }
  
  public EnumSetSerializer(EnumSetSerializer src, BeanProperty property, TypeSerializer vts, JsonSerializer<?> valueSerializer, Boolean unwrapSingle)
  {
    super(src, property, vts, valueSerializer, unwrapSingle);
  }
  
  public EnumSetSerializer _withValueTypeSerializer(TypeSerializer vts)
  {
    return this;
  }
  
  public EnumSetSerializer withResolved(BeanProperty property, TypeSerializer vts, JsonSerializer<?> elementSerializer, Boolean unwrapSingle)
  {
    return new EnumSetSerializer(this, property, vts, elementSerializer, unwrapSingle);
  }
  
  public boolean isEmpty(SerializerProvider prov, EnumSet<? extends Enum<?>> value)
  {
    return (value == null) || (value.isEmpty());
  }
  
  public boolean hasSingleElement(EnumSet<? extends Enum<?>> value)
  {
    return value.size() == 1;
  }
  
  public final void serialize(EnumSet<? extends Enum<?>> value, JsonGenerator gen, SerializerProvider provider)
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
  
  public void serializeContents(EnumSet<? extends Enum<?>> value, JsonGenerator gen, SerializerProvider provider)
    throws IOException
  {
    JsonSerializer<Object> enumSer = _elementSerializer;
    for (Enum<?> en : value)
    {
      if (enumSer == null) {
        enumSer = provider.findValueSerializer(en.getDeclaringClass(), _property);
      }
      enumSer.serialize(en, gen, provider);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.EnumSetSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */