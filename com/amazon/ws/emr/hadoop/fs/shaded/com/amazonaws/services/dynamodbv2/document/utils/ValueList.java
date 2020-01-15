package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.utils;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.InternalUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ValueList
  extends FluentArrayList<Object>
{
  private static final long serialVersionUID = 1L;
  
  public ValueList(int initialCapacity)
  {
    super(initialCapacity);
  }
  
  public ValueList(Object... elements)
  {
    super(elements);
  }
  
  public ValueList() {}
  
  public ValueList(Collection<?> c)
  {
    super(c);
  }
  
  public ValueList appendAll(Object... elements)
  {
    super.appendAll(elements);
    return this;
  }
  
  public ValueList appendString(String val)
  {
    super.append(val);
    return this;
  }
  
  public ValueList appendNumber(BigDecimal val)
  {
    super.append(val);
    return this;
  }
  
  public ValueList appendNumber(Number val)
  {
    super.append(InternalUtils.toBigDecimal(val));
    return this;
  }
  
  public ValueList appendInt(int val)
  {
    return appendNumber(Integer.valueOf(val));
  }
  
  public ValueList appendLong(long val)
  {
    return appendNumber(Long.valueOf(val));
  }
  
  public ValueList appendBinary(byte[] val)
  {
    super.append(val);
    return this;
  }
  
  public ValueList appendStringSet(Set<String> val)
  {
    super.append(val);
    return this;
  }
  
  public ValueList appendStringSet(String... val)
  {
    super.append(new LinkedHashSet(Arrays.asList(val)));
    return this;
  }
  
  public ValueList appendNumberSet(Set<BigDecimal> val)
  {
    super.append(val);
    return this;
  }
  
  public ValueList appendNumberSet(BigDecimal... val)
  {
    super.append(new LinkedHashSet(Arrays.asList(val)));
    return this;
  }
  
  public ValueList appendNumberSet(Number... val)
  {
    super.append(InternalUtils.toBigDecimalSet(val));
    return this;
  }
  
  public ValueList appendBinarySet(Set<byte[]> val)
  {
    super.append(val);
    return this;
  }
  
  public ValueList appendBinarySet(byte[]... val)
  {
    super.append(new LinkedHashSet(Arrays.asList(val)));
    return this;
  }
  
  public ValueList appendList(List<?> val)
  {
    super.append(new ArrayList(val));
    return this;
  }
  
  public ValueList appendList(Object... vals)
  {
    super.append(new ArrayList(Arrays.asList(vals)));
    return this;
  }
  
  public ValueList appendMap(Map<String, ?> val)
  {
    super.append(val);
    return this;
  }
  
  public ValueList appendBoolean(boolean val)
  {
    super.append(Boolean.valueOf(val));
    return this;
  }
  
  public ValueList appendNull()
  {
    super.append(null);
    return this;
  }
  
  public ValueList append(Object val)
  {
    if (val == this) {
      throw new IllegalArgumentException("Self reference is not allowed");
    }
    super.append(val);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.utils.ValueList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */