package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import java.io.IOException;
import java.lang.reflect.Type;

@JacksonStdImpl
public final class StringSerializer
  extends NonTypedScalarSerializerBase<Object>
{
  private static final long serialVersionUID = 1L;
  
  public StringSerializer()
  {
    super(String.class, false);
  }
  
  @Deprecated
  public boolean isEmpty(Object value)
  {
    String str = (String)value;
    return (str == null) || (str.length() == 0);
  }
  
  public boolean isEmpty(SerializerProvider prov, Object value)
  {
    String str = (String)value;
    return (str == null) || (str.length() == 0);
  }
  
  public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider)
    throws IOException
  {
    jgen.writeString((String)value);
  }
  
  public JsonNode getSchema(SerializerProvider provider, Type typeHint)
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.StringSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */