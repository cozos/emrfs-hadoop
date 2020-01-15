package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;
import java.lang.reflect.Type;

@JacksonStdImpl
public class ToStringSerializer
  extends StdSerializer<Object>
{
  public static final ToStringSerializer instance = new ToStringSerializer();
  
  public ToStringSerializer()
  {
    super(Object.class);
  }
  
  public ToStringSerializer(Class<?> handledType)
  {
    super(handledType, false);
  }
  
  @Deprecated
  public boolean isEmpty(Object value)
  {
    return isEmpty(null, value);
  }
  
  public boolean isEmpty(SerializerProvider prov, Object value)
  {
    if (value == null) {
      return true;
    }
    String str = value.toString();
    return str.isEmpty();
  }
  
  public void serialize(Object value, JsonGenerator gen, SerializerProvider provider)
    throws IOException
  {
    gen.writeString(value.toString());
  }
  
  public void serializeWithType(Object value, JsonGenerator gen, SerializerProvider provider, TypeSerializer typeSer)
    throws IOException
  {
    typeSer.writeTypePrefixForScalar(value, gen);
    serialize(value, gen, provider);
    typeSer.writeTypeSuffixForScalar(value, gen);
  }
  
  public JsonNode getSchema(SerializerProvider provider, Type typeHint)
    throws JsonMappingException
  {
    return createSchemaNode("string", true);
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
    throws JsonMappingException
  {
    if (visitor != null) {
      visitor.expectStringFormat(typeHint);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.ToStringSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */