package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.mutable;

public class MutableLong
  extends Number
  implements Comparable<MutableLong>, Mutable<Number>
{
  private static final long serialVersionUID = 62986528375L;
  private long value;
  
  public MutableLong() {}
  
  public MutableLong(long value)
  {
    this.value = value;
  }
  
  public MutableLong(Number value)
  {
    this.value = value.longValue();
  }
  
  public MutableLong(String value)
    throws NumberFormatException
  {
    this.value = Long.parseLong(value);
  }
  
  public Long getValue()
  {
    return Long.valueOf(value);
  }
  
  public void setValue(long value)
  {
    this.value = value;
  }
  
  public void setValue(Number value)
  {
    this.value = value.longValue();
  }
  
  public void increment()
  {
    value += 1L;
  }
  
  public void decrement()
  {
    value -= 1L;
  }
  
  public void add(long operand)
  {
    value += operand;
  }
  
  public void add(Number operand)
  {
    value += operand.longValue();
  }
  
  public void subtract(long operand)
  {
    value -= operand;
  }
  
  public void subtract(Number operand)
  {
    value -= operand.longValue();
  }
  
  public int intValue()
  {
    return (int)value;
  }
  
  public long longValue()
  {
    return value;
  }
  
  public float floatValue()
  {
    return (float)value;
  }
  
  public double doubleValue()
  {
    return value;
  }
  
  public Long toLong()
  {
    return Long.valueOf(longValue());
  }
  
  public boolean equals(Object obj)
  {
    if ((obj instanceof MutableLong)) {
      return value == ((MutableLong)obj).longValue();
    }
    return false;
  }
  
  public int hashCode()
  {
    return (int)(value ^ value >>> 32);
  }
  
  public int compareTo(MutableLong other)
  {
    long anotherVal = value;
    return value == anotherVal ? 0 : value < anotherVal ? -1 : 1;
  }
  
  public String toString()
  {
    return String.valueOf(value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.mutable.MutableLong
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */