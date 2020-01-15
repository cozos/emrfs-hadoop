package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;

public class StdKeySerializer
  extends StdSerializer<Object>
{
  public StdKeySerializer()
  {
    super(Object.class);
  }
  
  public void serialize(Object value, JsonGenerator g, SerializerProvider provider)
    throws IOException
  {
    Class<?> cls = value.getClass();
    String str;
    String str;
    if (cls == String.class)
    {
      str = (String)value;
    }
    else
    {
      String str;
      if (cls.isEnum())
      {
        Enum<?> en = (Enum)value;
        String str;
        if (provider.isEnabled(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)) {
          str = en.toString();
        } else {
          str = en.name();
        }
      }
      else
      {
        if ((value instanceof Date))
        {
          provider.defaultSerializeDateKey((Date)value, g); return;
        }
        String str;
        if (cls == Class.class) {
          str = ((Class)value).getName();
        } else {
          str = value.toString();
        }
      }
    }
    g.writeFieldName(str);
  }
  
  public JsonNode getSchema(SerializerProvider provider, Type typeHint)
    throws JsonMappingException
  {
    return createSchemaNode("string");
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
    throws JsonMappingException
  {
    visitor.expectStringFormat(typeHint);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.StdKeySerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */