package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;
import java.lang.reflect.Type;

public abstract class StdScalarSerializer<T>
  extends StdSerializer<T>
{
  protected StdScalarSerializer(Class<T> t)
  {
    super(t);
  }
  
  protected StdScalarSerializer(Class<?> t, boolean dummy)
  {
    super(t);
  }
  
  public void serializeWithType(T value, JsonGenerator jgen, SerializerProvider provider, TypeSerializer typeSer)
    throws IOException
  {
    typeSer.writeTypePrefixForScalar(value, jgen);
    serialize(value, jgen, provider);
    typeSer.writeTypeSuffixForScalar(value, jgen);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.StdScalarSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */