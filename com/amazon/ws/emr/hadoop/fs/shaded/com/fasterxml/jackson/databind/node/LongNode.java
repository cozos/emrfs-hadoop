package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.NumberType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.NumberOutput;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class LongNode
  extends NumericNode
{
  protected final long _value;
  
  public LongNode(long v)
  {
    _value = v;
  }
  
  public static LongNode valueOf(long l)
  {
    return new LongNode(l);
  }
  
  public JsonToken asToken()
  {
    return JsonToken.VALUE_NUMBER_INT;
  }
  
  public JsonParser.NumberType numberType()
  {
    return JsonParser.NumberType.LONG;
  }
  
  public boolean isIntegralNumber()
  {
    return true;
  }
  
  public boolean isLong()
  {
    return true;
  }
  
  public boolean canConvertToInt()
  {
    return (_value >= -2147483648L) && (_value <= 2147483647L);
  }
  
  public boolean canConvertToLong()
  {
    return true;
  }
  
  public Number numberValue()
  {
    return Long.valueOf(_value);
  }
  
  public short shortValue()
  {
    return (short)(int)_value;
  }
  
  public int intValue()
  {
    return (int)_value;
  }
  
  public long longValue()
  {
    return _value;
  }
  
  public float floatValue()
  {
    return (float)_value;
  }
  
  public double doubleValue()
  {
    return _value;
  }
  
  public BigDecimal decimalValue()
  {
    return BigDecimal.valueOf(_value);
  }
  
  public BigInteger bigIntegerValue()
  {
    return BigInteger.valueOf(_value);
  }
  
  public String asText()
  {
    return NumberOutput.toString(_value);
  }
  
  public boolean asBoolean(boolean defaultValue)
  {
    return _value != 0L;
  }
  
  public final void serialize(JsonGenerator jg, SerializerProvider provider)
    throws IOException, JsonProcessingException
  {
    jg.writeNumber(_value);
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (o == null) {
      return false;
    }
    if ((o instanceof LongNode)) {
      return _value == _value;
    }
    return false;
  }
  
  public int hashCode()
  {
    return (int)_value ^ (int)(_value >> 32);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.LongNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */