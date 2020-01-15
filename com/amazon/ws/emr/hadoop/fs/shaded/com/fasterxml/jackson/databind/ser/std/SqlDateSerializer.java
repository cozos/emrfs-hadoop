package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Date;
import java.text.DateFormat;

@JacksonStdImpl
public class SqlDateSerializer
  extends DateTimeSerializerBase<Date>
{
  public SqlDateSerializer()
  {
    this(Boolean.FALSE);
  }
  
  protected SqlDateSerializer(Boolean useTimestamp)
  {
    super(Date.class, useTimestamp, null);
  }
  
  public SqlDateSerializer withFormat(Boolean timestamp, DateFormat customFormat)
  {
    return new SqlDateSerializer(timestamp);
  }
  
  protected long _timestamp(Date value)
  {
    return value == null ? 0L : value.getTime();
  }
  
  public void serialize(Date value, JsonGenerator gen, SerializerProvider provider)
    throws IOException, JsonGenerationException
  {
    if (_asTimestamp(provider)) {
      gen.writeNumber(_timestamp(value));
    } else {
      gen.writeString(value.toString());
    }
  }
  
  public JsonNode getSchema(SerializerProvider provider, Type typeHint)
  {
    return createSchemaNode("string", true);
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
    throws JsonMappingException
  {
    _acceptJsonFormatVisitor(visitor, typeHint, _useTimestamp.booleanValue());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.SqlDateSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */