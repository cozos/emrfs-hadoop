package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.NumberType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class FloatNode
  extends NumericNode
{
  protected final float _value;
  
  public FloatNode(float v)
  {
    _value = v;
  }
  
  public static FloatNode valueOf(float v)
  {
    return new FloatNode(v);
  }
  
  public JsonToken asToken()
  {
    return JsonToken.VALUE_NUMBER_FLOAT;
  }
  
  public JsonParser.NumberType numberType()
  {
    return JsonParser.NumberType.FLOAT;
  }
  
  public boolean isFloatingPointNumber()
  {
    return true;
  }
  
  public boolean isFloat()
  {
    return true;
  }
  
  public boolean canConvertToInt()
  {
    return (_value >= -2.14748365E9F) && (_value <= 2.14748365E9F);
  }
  
  public boolean canConvertToLong()
  {
    return (_value >= -9.223372E18F) && (_value <= 9.223372E18F);
  }
  
  public Number numberValue()
  {
    return Float.valueOf(_value);
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
    return _value;
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
    return Float.toString(_value);
  }
  
  public final void serialize(JsonGenerator jg, SerializerProvider provider)
    throws IOException
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
    if ((o instanceof FloatNode))
    {
      float otherValue = _value;
      return Float.compare(_value, otherValue) == 0;
    }
    return false;
  }
  
  public int hashCode()
  {
    return Float.floatToIntBits(_value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.FloatNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */