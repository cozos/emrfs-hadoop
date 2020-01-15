package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase;
import java.io.IOException;
import java.util.Collection;

@JacksonStdImpl
public class StringCollectionSerializer
  extends StaticListSerializerBase<Collection<String>>
{
  public static final StringCollectionSerializer instance = new StringCollectionSerializer();
  
  protected StringCollectionSerializer()
  {
    super(Collection.class);
  }
  
  protected StringCollectionSerializer(StringCollectionSerializer src, JsonSerializer<?> ser, Boolean unwrapSingle)
  {
    super(src, ser, unwrapSingle);
  }
  
  public JsonSerializer<?> _withResolved(BeanProperty prop, JsonSerializer<?> ser, Boolean unwrapSingle)
  {
    return new StringCollectionSerializer(this, ser, unwrapSingle);
  }
  
  protected JsonNode contentSchema()
  {
    return createSchemaNode("string", true);
  }
  
  protected void acceptContentVisitor(JsonArrayFormatVisitor visitor)
    throws JsonMappingException
  {
    visitor.itemsFormat(JsonFormatTypes.STRING);
  }
  
  public void serialize(Collection<String> value, JsonGenerator gen, SerializerProvider provider)
    throws IOException
  {
    int len = value.size();
    if ((len == 1) && (
      ((_unwrapSingle == null) && (provider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED))) || (_unwrapSingle == Boolean.TRUE)))
    {
      _serializeUnwrapped(value, gen, provider);
      return;
    }
    gen.writeStartArray(len);
    if (_serializer == null) {
      serializeContents(value, gen, provider);
    } else {
      serializeUsingCustom(value, gen, provider);
    }
    gen.writeEndArray();
  }
  
  private final void _serializeUnwrapped(Collection<String> value, JsonGenerator gen, SerializerProvider provider)
    throws IOException
  {
    if (_serializer == null) {
      serializeContents(value, gen, provider);
    } else {
      serializeUsingCustom(value, gen, provider);
    }
  }
  
  public void serializeWithType(Collection<String> value, JsonGenerator jgen, SerializerProvider provider, TypeSerializer typeSer)
    throws IOException, JsonGenerationException
  {
    typeSer.writeTypePrefixForArray(value, jgen);
    if (_serializer == null) {
      serializeContents(value, jgen, provider);
    } else {
      serializeUsingCustom(value, jgen, provider);
    }
    typeSer.writeTypeSuffixForArray(value, jgen);
  }
  
  private final void serializeContents(Collection<String> value, JsonGenerator jgen, SerializerProvider provider)
    throws IOException, JsonGenerationException
  {
    if (_serializer != null)
    {
      serializeUsingCustom(value, jgen, provider);
      return;
    }
    int i = 0;
    for (String str : value) {
      try
      {
        if (str == null) {
          provider.defaultSerializeNull(jgen);
        } else {
          jgen.writeString(str);
        }
        i++;
      }
      catch (Exception e)
      {
        wrapAndThrow(provider, e, value, i);
      }
    }
  }
  
  private void serializeUsingCustom(Collection<String> value, JsonGenerator jgen, SerializerProvider provider)
    throws IOException, JsonGenerationException
  {
    JsonSerializer<String> ser = _serializer;
    int i = 0;
    for (String str : value) {
      try
      {
        if (str == null) {
          provider.defaultSerializeNull(jgen);
        } else {
          ser.serialize(str, jgen, provider);
        }
      }
      catch (Exception e)
      {
        wrapAndThrow(provider, e, value, i);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.StringCollectionSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */