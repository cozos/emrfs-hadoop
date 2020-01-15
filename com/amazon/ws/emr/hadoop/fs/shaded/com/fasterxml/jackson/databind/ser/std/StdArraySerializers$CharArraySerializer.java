package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.lang.reflect.Type;

@JacksonStdImpl
public class StdArraySerializers$CharArraySerializer
  extends StdSerializer<char[]>
{
  public StdArraySerializers$CharArraySerializer()
  {
    super(char[].class);
  }
  
  public boolean isEmpty(SerializerProvider prov, char[] value)
  {
    return (value == null) || (value.length == 0);
  }
  
  public void serialize(char[] value, JsonGenerator jgen, SerializerProvider provider)
    throws IOException, JsonGenerationException
  {
    if (provider.isEnabled(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS))
    {
      jgen.writeStartArray(value.length);
      _writeArrayContents(jgen, value);
      jgen.writeEndArray();
    }
    else
    {
      jgen.writeString(value, 0, value.length);
    }
  }
  
  public void serializeWithType(char[] value, JsonGenerator jgen, SerializerProvider provider, TypeSerializer typeSer)
    throws IOException, JsonGenerationException
  {
    if (provider.isEnabled(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS))
    {
      typeSer.writeTypePrefixForArray(value, jgen);
      _writeArrayContents(jgen, value);
      typeSer.writeTypeSuffixForArray(value, jgen);
    }
    else
    {
      typeSer.writeTypePrefixForScalar(value, jgen);
      jgen.writeString(value, 0, value.length);
      typeSer.writeTypeSuffixForScalar(value, jgen);
    }
  }
  
  private final void _writeArrayContents(JsonGenerator jgen, char[] value)
    throws IOException, JsonGenerationException
  {
    int i = 0;
    for (int len = value.length; i < len; i++) {
      jgen.writeString(value, i, 1);
    }
  }
  
  public JsonNode getSchema(SerializerProvider provider, Type typeHint)
  {
    ObjectNode o = createSchemaNode("array", true);
    ObjectNode itemSchema = createSchemaNode("string");
    itemSchema.put("type", "string");
    return o.set("items", itemSchema);
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
    throws JsonMappingException
  {
    if (visitor != null)
    {
      JsonArrayFormatVisitor v2 = visitor.expectArrayFormat(typeHint);
      if (v2 != null) {
        v2.itemsFormat(JsonFormatTypes.STRING);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.StdArraySerializers.CharArraySerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */