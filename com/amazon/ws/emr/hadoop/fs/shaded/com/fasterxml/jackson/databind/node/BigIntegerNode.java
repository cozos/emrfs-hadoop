package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.NumberType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class BigIntegerNode
  extends NumericNode
{
  private static final BigInteger MIN_INTEGER = BigInteger.valueOf(-2147483648L);
  private static final BigInteger MAX_INTEGER = BigInteger.valueOf(2147483647L);
  private static final BigInteger MIN_LONG = BigInteger.valueOf(Long.MIN_VALUE);
  private static final BigInteger MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);
  protected final BigInteger _value;
  
  public BigIntegerNode(BigInteger v)
  {
    _value = v;
  }
  
  public static BigIntegerNode valueOf(BigInteger v)
  {
    return new BigIntegerNode(v);
  }
  
  public JsonToken asToken()
  {
    return JsonToken.VALUE_NUMBER_INT;
  }
  
  public JsonParser.NumberType numberType()
  {
    return JsonParser.NumberType.BIG_INTEGER;
  }
  
  public boolean isIntegralNumber()
  {
    return true;
  }
  
  public boolean isBigInteger()
  {
    return true;
  }
  
  public boolean canConvertToInt()
  {
    return (_value.compareTo(MIN_INTEGER) >= 0) && (_value.compareTo(MAX_INTEGER) <= 0);
  }
  
  public boolean canConvertToLong()
  {
    return (_value.compareTo(MIN_LONG) >= 0) && (_value.compareTo(MAX_LONG) <= 0);
  }
  
  public Number numberValue()
  {
    return _value;
  }
  
  public short shortValue()
  {
    return _value.shortValue();
  }
  
  public int intValue()
  {
    return _value.intValue();
  }
  
  public long longValue()
  {
    return _value.longValue();
  }
  
  public BigInteger bigIntegerValue()
  {
    return _value;
  }
  
  public float floatValue()
  {
    return _value.floatValue();
  }
  
  public double doubleValue()
  {
    return _value.doubleValue();
  }
  
  public BigDecimal decimalValue()
  {
    return new BigDecimal(_value);
  }
  
  public String asText()
  {
    return _value.toString();
  }
  
  public boolean asBoolean(boolean defaultValue)
  {
    return !BigInteger.ZERO.equals(_value);
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
    if (!(o instanceof BigIntegerNode)) {
      return false;
    }
    return _value.equals(_value);
  }
  
  public int hashCode()
  {
    return _value.hashCode();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.BigIntegerNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */