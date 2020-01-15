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

public class IntNode
  extends NumericNode
{
  static final int MIN_CANONICAL = -1;
  static final int MAX_CANONICAL = 10;
  private static final IntNode[] CANONICALS;
  protected final int _value;
  
  static
  {
    int count = 12;
    CANONICALS = new IntNode[count];
    for (int i = 0; i < count; i++) {
      CANONICALS[i] = new IntNode(-1 + i);
    }
  }
  
  public IntNode(int v)
  {
    _value = v;
  }
  
  public static IntNode valueOf(int i)
  {
    if ((i > 10) || (i < -1)) {
      return new IntNode(i);
    }
    return CANONICALS[(i - -1)];
  }
  
  public JsonToken asToken()
  {
    return JsonToken.VALUE_NUMBER_INT;
  }
  
  public JsonParser.NumberType numberType()
  {
    return JsonParser.NumberType.INT;
  }
  
  public boolean isIntegralNumber()
  {
    return true;
  }
  
  public boolean isInt()
  {
    return true;
  }
  
  public boolean canConvertToInt()
  {
    return true;
  }
  
  public boolean canConvertToLong()
  {
    return true;
  }
  
  public Number numberValue()
  {
    return Integer.valueOf(_value);
  }
  
  public short shortValue()
  {
    return (short)_value;
  }
  
  public int intValue()
  {
    return _value;
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
    return BigInteger.valueOf(_value);
  }
  
  public String asText()
  {
    return NumberOutput.toString(_value);
  }
  
  public boolean asBoolean(boolean defaultValue)
  {
    return _value != 0;
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
    if ((o instanceof IntNode)) {
      return _value == _value;
    }
    return false;
  }
  
  public int hashCode()
  {
    return _value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.IntNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */