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
public final class BooleanSerializer
  extends NonTypedScalarSerializerBase<Boolean>
{
  private static final long serialVersionUID = 1L;
  protected final boolean _forPrimitive;
  
  public BooleanSerializer(boolean forPrimitive)
  {
    super(Boolean.class);
    _forPrimitive = forPrimitive;
  }
  
  public void serialize(Boolean value, JsonGenerator jgen, SerializerProvider provider)
    throws IOException
  {
    jgen.writeBoolean(value.booleanValue());
  }
  
  public JsonNode getSchema(SerializerProvider provider, Type typeHint)
  {
    return createSchemaNode("boolean", !_forPrimitive);
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
    throws JsonMappingException
  {
    if (visitor != null) {
      visitor.expectBooleanFormat(typeHint);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.BooleanSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */