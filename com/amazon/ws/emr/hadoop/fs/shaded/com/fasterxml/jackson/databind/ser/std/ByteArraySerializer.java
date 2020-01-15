package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationConfig;
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
public class ByteArraySerializer
  extends StdSerializer<byte[]>
{
  private static final long serialVersionUID = 1L;
  
  public ByteArraySerializer()
  {
    super(byte[].class);
  }
  
  public boolean isEmpty(SerializerProvider prov, byte[] value)
  {
    return (value == null) || (value.length == 0);
  }
  
  public void serialize(byte[] value, JsonGenerator jgen, SerializerProvider provider)
    throws IOException
  {
    jgen.writeBinary(provider.getConfig().getBase64Variant(), value, 0, value.length);
  }
  
  public void serializeWithType(byte[] value, JsonGenerator jgen, SerializerProvider provider, TypeSerializer typeSer)
    throws IOException
  {
    typeSer.writeTypePrefixForScalar(value, jgen);
    jgen.writeBinary(provider.getConfig().getBase64Variant(), value, 0, value.length);
    
    typeSer.writeTypeSuffixForScalar(value, jgen);
  }
  
  public JsonNode getSchema(SerializerProvider provider, Type typeHint)
  {
    ObjectNode o = createSchemaNode("array", true);
    ObjectNode itemSchema = createSchemaNode("string");
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.ByteArraySerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */