package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.NumberType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class DecimalNode
  extends NumericNode
{
  public static final DecimalNode ZERO = new DecimalNode(BigDecimal.ZERO);
  private static final BigDecimal MIN_INTEGER = BigDecimal.valueOf(-2147483648L);
  private static final BigDecimal MAX_INTEGER = BigDecimal.valueOf(2147483647L);
  private static final BigDecimal MIN_LONG = BigDecimal.valueOf(Long.MIN_VALUE);
  private static final BigDecimal MAX_LONG = BigDecimal.valueOf(Long.MAX_VALUE);
  protected final BigDecimal _value;
  
  public DecimalNode(BigDecimal v)
  {
    _value = v;
  }
  
  public static DecimalNode valueOf(BigDecimal d)
  {
    return new DecimalNode(d);
  }
  
  public JsonToken asToken()
  {
    return JsonToken.VALUE_NUMBER_FLOAT;
  }
  
  public JsonParser.NumberType numberType()
  {
    return JsonParser.NumberType.BIG_DECIMAL;
  }
  
  public boolean isFloatingPointNumber()
  {
    return true;
  }
  
  public boolean isBigDecimal()
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
    return _value.toBigInteger();
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
    return _value;
  }
  
  public String asText()
  {
    return _value.toString();
  }
  
  public final void serialize(JsonGenerator jgen, SerializerProvider provider)
    throws IOException, JsonProcessingException
  {
    jgen.writeNumber(_value);
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (o == null) {
      return false;
    }
    if ((o instanceof DecimalNode)) {
      return _value.compareTo(_value) == 0;
    }
    return false;
  }
  
  public int hashCode()
  {
    return Double.valueOf(doubleValue()).hashCode();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.DecimalNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */