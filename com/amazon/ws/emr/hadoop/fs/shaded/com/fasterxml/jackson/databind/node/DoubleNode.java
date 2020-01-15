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

public class DoubleNode
  extends NumericNode
{
  protected final double _value;
  
  public DoubleNode(double v)
  {
    _value = v;
  }
  
  public static DoubleNode valueOf(double v)
  {
    return new DoubleNode(v);
  }
  
  public JsonToken asToken()
  {
    return JsonToken.VALUE_NUMBER_FLOAT;
  }
  
  public JsonParser.NumberType numberType()
  {
    return JsonParser.NumberType.DOUBLE;
  }
  
  public boolean isFloatingPointNumber()
  {
    return true;
  }
  
  public boolean isDouble()
  {
    return true;
  }
  
  public boolean canConvertToInt()
  {
    return (_value >= -2.147483648E9D) && (_value <= 2.147483647E9D);
  }
  
  public boolean canConvertToLong()
  {
    return (_value >= -9.223372036854776E18D) && (_value <= 9.223372036854776E18D);
  }
  
  public Number numberValue()
  {
    return Double.valueOf(_value);
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
    return decimalValue().toBigInteger();
  }
  
  public String asText()
  {
    return NumberOutput.toString(_value);
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
    if ((o instanceof DoubleNode))
    {
      double otherValue = _value;
      return Double.compare(_value, otherValue) == 0;
    }
    return false;
  }
  
  public int hashCode()
  {
    long l = Double.doubleToLongBits(_value);
    return (int)l ^ (int)(l >> 32);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.DoubleNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */