package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonStringFormatVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Time;

@JacksonStdImpl
public class SqlTimeSerializer
  extends StdScalarSerializer<Time>
{
  public SqlTimeSerializer()
  {
    super(Time.class);
  }
  
  public void serialize(Time value, JsonGenerator g, SerializerProvider provider)
    throws IOException
  {
    g.writeString(value.toString());
  }
  
  public JsonNode getSchema(SerializerProvider provider, Type typeHint)
  {
    return createSchemaNode("string", true);
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
    throws JsonMappingException
  {
    JsonStringFormatVisitor v2 = visitor == null ? null : visitor.expectStringFormat(typeHint);
    if (v2 != null) {
      v2.format(JsonValueFormat.DATE_TIME);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.SqlTimeSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */