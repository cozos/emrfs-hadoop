package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.NumberType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonIntegerFormatVisitor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsonFormatVisitors.JsonNumberFormatVisitor;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;

@JacksonStdImpl
public class NumberSerializer
  extends StdScalarSerializer<Number>
{
  public static final NumberSerializer instance = new NumberSerializer(Number.class);
  protected final boolean _isInt;
  
  @Deprecated
  public NumberSerializer()
  {
    super(Number.class);
    _isInt = false;
  }
  
  public NumberSerializer(Class<? extends Number> rawType)
  {
    super(rawType, false);
    
    _isInt = (rawType == BigInteger.class);
  }
  
  public void serialize(Number value, JsonGenerator jgen, SerializerProvider provider)
    throws IOException
  {
    if ((value instanceof BigDecimal)) {
      jgen.writeNumber((BigDecimal)value);
    } else if ((value instanceof BigInteger)) {
      jgen.writeNumber((BigInteger)value);
    } else if ((value instanceof Integer)) {
      jgen.writeNumber(value.intValue());
    } else if ((value instanceof Long)) {
      jgen.writeNumber(value.longValue());
    } else if ((value instanceof Double)) {
      jgen.writeNumber(value.doubleValue());
    } else if ((value instanceof Float)) {
      jgen.writeNumber(value.floatValue());
    } else if (((value instanceof Byte)) || ((value instanceof Short))) {
      jgen.writeNumber(value.intValue());
    } else {
      jgen.writeNumber(value.toString());
    }
  }
  
  public JsonNode getSchema(SerializerProvider provider, Type typeHint)
  {
    return createSchemaNode(_isInt ? "integer" : "number", true);
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
    throws JsonMappingException
  {
    if (_isInt)
    {
      JsonIntegerFormatVisitor v2 = visitor.expectIntegerFormat(typeHint);
      if (v2 != null) {
        v2.numberType(JsonParser.NumberType.BIG_INTEGER);
      }
    }
    else
    {
      JsonNumberFormatVisitor v2 = visitor.expectNumberFormat(typeHint);
      if (v2 != null)
      {
        Class<?> h = handledType();
        if (h == BigDecimal.class) {
          v2.numberType(JsonParser.NumberType.BIG_DECIMAL);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.NumberSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */