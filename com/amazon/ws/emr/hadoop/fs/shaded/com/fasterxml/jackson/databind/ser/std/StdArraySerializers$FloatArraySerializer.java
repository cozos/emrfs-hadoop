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
public class StdArraySerializers$FloatArraySerializer
  extends StdArraySerializers.TypedPrimitiveArraySerializer<float[]>
{
  private static final JavaType VALUE_TYPE = TypeFactory.defaultInstance().uncheckedSimpleType(Float.TYPE);
  
  public StdArraySerializers$FloatArraySerializer()
  {
    super(float[].class);
  }
  
  public StdArraySerializers$FloatArraySerializer(FloatArraySerializer src, BeanProperty prop, TypeSerializer vts, Boolean unwrapSingle)
  {
    super(src, prop, vts, unwrapSingle);
  }
  
  public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer vts)
  {
    return new FloatArraySerializer(this, _property, vts, _unwrapSingle);
  }
  
  public JsonSerializer<?> _withResolved(BeanProperty prop, Boolean unwrapSingle)
  {
    return new FloatArraySerializer(this, prop, _valueTypeSerializer, unwrapSingle);
  }
  
  public JavaType getContentType()
  {
    return VALUE_TYPE;
  }
  
  public JsonSerializer<?> getContentSerializer()
  {
    return null;
  }
  
  public boolean isEmpty(SerializerProvider prov, float[] value)
  {
    return (value == null) || (value.length == 0);
  }
  
  public boolean hasSingleElement(float[] value)
  {
    return value.length == 1;
  }
  
  public final void serialize(float[] value, JsonGenerator gen, SerializerProvider provider)
    throws IOException
  {
    int len = value.length;
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
  
  public void serializeContents(float[] value, JsonGenerator gen, SerializerProvider provider)
    throws IOException, JsonGenerationException
  {
    if (_valueTypeSerializer != null)
    {
      int i = 0;
      for (int len = value.length; i < len; i++)
      {
        _valueTypeSerializer.writeTypePrefixForScalar(null, gen, Float.TYPE);
        gen.writeNumber(value[i]);
        _valueTypeSerializer.writeTypeSuffixForScalar(null, gen);
      }
      return;
    }
    int i = 0;
    for (int len = value.length; i < len; i++) {
      gen.writeNumber(value[i]);
    }
  }
  
  public JsonNode getSchema(SerializerProvider provider, Type typeHint)
  {
    return createSchemaNode("array", true).set("items", createSchemaNode("number"));
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */