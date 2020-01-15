package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.ObjectNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.IOException;
import java.lang.reflect.Type;

@JacksonStdImpl
public class StdArraySerializers$LongArraySerializer
  extends StdArraySerializers.TypedPrimitiveArraySerializer<long[]>
{
  private static final JavaType VALUE_TYPE = TypeFactory.defaultInstance().uncheckedSimpleType(Long.TYPE);
  
  public StdArraySerializers$LongArraySerializer()
  {
    super(long[].class);
  }
  
  public StdArraySerializers$LongArraySerializer(LongArraySerializer src, BeanProperty prop, TypeSerializer vts, Boolean unwrapSingle)
  {
    super(src, prop, vts, unwrapSingle);
  }
  
  public JsonSerializer<?> _withResolved(BeanProperty prop, Boolean unwrapSingle)
  {
    return new LongArraySerializer(this, prop, _valueTypeSerializer, unwrapSingle);
  }
  
  public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer vts)
  {
    return new LongArraySerializer(this, _property, vts, _unwrapSingle);
  }
  
  public JavaType getContentType()
  {
    return VALUE_TYPE;
  }
  
  public JsonSerializer<?> getContentSerializer()
  {
    return null;
  }
  
  public boolean isEmpty(SerializerProvider prov, long[] value)
  {
    return (value == null) || (value.length == 0);
  }
  
  public boolean hasSingleElement(long[] value)
  {
    return value.length == 1;
  }
  
  public final void serialize(long[] value, JsonGenerator jgen, SerializerProvider provider)
    throws IOException
  {
    int len = value.length;
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
  
  public void serializeContents(long[] value, JsonGenerator jgen, SerializerProvider provider)
    throws IOException
  {
    if (_valueTypeSerializer != null)
    {
      int i = 0;
      for (int len = value.length; i < len; i++)
      {
        _valueTypeSerializer.writeTypePrefixForScalar(null, jgen, Long.TYPE);
        jgen.writeNumber(value[i]);
        _valueTypeSerializer.writeTypeSuffixForScalar(null, jgen);
      }
      return;
    }
    int i = 0;
    for (int len = value.length; i < len; i++) {
      jgen.writeNumber(value[i]);
    }
  }
  
  public JsonNode getSchema(SerializerProvider provider, Type typeHint)
  {
    return createSchemaNode("array", true).set("items", createSchemaNode("number", true));
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
    throws JsonMappingException
  {
    if (visitor != null)
    {
      JsonArrayFormatVisitor v2 = visitor.expectArrayFormat(typeHint);
      if (v2 != null) {
        v2.itemsFormat(JsonFormatTypes.NUMBER);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.StdArraySerializers.LongArraySerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */