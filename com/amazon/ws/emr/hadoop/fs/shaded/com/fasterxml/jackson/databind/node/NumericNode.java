package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.NumberType;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class NumericNode
  extends ValueNode
{
  public final JsonNodeType getNodeType()
  {
    return JsonNodeType.NUMBER;
  }
  
  public abstract JsonParser.NumberType numberType();
  
  public abstract Number numberValue();
  
  public abstract int intValue();
  
  public abstract long longValue();
  
  public abstract double doubleValue();
  
  public abstract BigDecimal decimalValue();
  
  public abstract BigInteger bigIntegerValue();
  
  public abstract boolean canConvertToInt();
  
  public abstract boolean canConvertToLong();
  
  public abstract String asText();
  
  public final int asInt()
  {
    return intValue();
  }
  
  public final int asInt(int defaultValue)
  {
    return intValue();
  }
  
  public final long asLong()
  {
    return longValue();
  }
  
  public final long asLong(long defaultValue)
  {
    return longValue();
  }
  
  public final double asDouble()
  {
    return doubleValue();
  }
  
  public final double asDouble(double defaultValue)
  {
    return doubleValue();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.NumericNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */