package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.ReferenceType;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceSerializer
  extends StdSerializer<AtomicReference<?>>
{
  private static final long serialVersionUID = 1L;
  
  @Deprecated
  public AtomicReferenceSerializer()
  {
    super(AtomicReference.class, false);
  }
  
  public AtomicReferenceSerializer(ReferenceType type)
  {
    super(type);
  }
  
  public boolean isEmpty(SerializerProvider provider, AtomicReference<?> value)
  {
    return (value == null) || (value.get() == null);
  }
  
  public void serialize(AtomicReference<?> value, JsonGenerator jgen, SerializerProvider provider)
    throws IOException, JsonGenerationException
  {
    provider.defaultSerializeValue(value.get(), jgen);
  }
  
  public JsonNode getSchema(SerializerProvider provider, Type typeHint)
  {
    return createSchemaNode("any", true);
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
    throws JsonMappingException
  {
    visitor.expectAnyFormat(typeHint);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.AtomicReferenceSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */