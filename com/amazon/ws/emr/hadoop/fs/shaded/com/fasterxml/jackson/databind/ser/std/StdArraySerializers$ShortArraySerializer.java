package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerationException;
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
public class StdArraySerializers$ShortArraySerializer
  extends StdArraySerializers.TypedPrimitiveArraySerializer<short[]>
{
  private static final JavaType VALUE_TYPE = TypeFactory.defaultInstance().uncheckedSimpleType(Short.TYPE);
  
  public StdArraySerializers$ShortArraySerializer()
  {
    super(short[].class);
  }
  
  public StdArraySerializers$ShortArraySerializer(ShortArraySerializer src, BeanProperty prop, TypeSerializer vts, Boolean unwrapSingle)
  {
    super(src, prop, vts, unwrapSingle);
  }
  
  public JsonSerializer<?> _withResolved(BeanProperty prop, Boolean unwrapSingle)
  {
    return new ShortArraySerializer(this, prop, _valueTypeSerializer, unwrapSingle);
  }
  
  public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer vts)
  {
    return new ShortArraySerializer(this, _property, vts, _unwrapSingle);
  }
  
  public JavaType getContentType()
  {
    return VALUE_TYPE;
  }
  
  public JsonSerializer<?> getContentSerializer()
  {
    return null;
  }
  
  public boolean isEmpty(SerializerProvider prov, short[] value)
  {
    return (value == null) || (value.length == 0);
  }
  
  public boolean hasSingleElement(short[] value)
  {
    return value.length == 1;
  }
  
  public final void serialize(short[] value, JsonGenerator jgen, SerializerProvider provider)
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
  
  public void serializeContents(short[] value, JsonGenerator jgen, SerializerProvider provider)
    throws IOException, JsonGenerationException
  {
    if (_valueTypeSerializer != null)
    {
      int i = 0;
      for (int len = value.length; i < len; i++)
      {
        _valueTypeSerializer.writeTypePrefixForScalar(null, jgen, Short.TYPE);
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
    ObjectNode o = createSchemaNode("array", true);
    return o.set("items", createSchemaNode("integer"));
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
    throws JsonMappingException
  {
    if (visitor != null)
    {
      JsonArrayFormatVisitor v2 = visitor.expectArrayFormat(typeHint);
      if (v2 != null) {
        v2.itemsFormat(JsonFormatTypes.INTEGER);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.StdArraySerializers.ShortArraySerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */