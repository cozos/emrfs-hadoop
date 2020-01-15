package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.mutable;

public class MutableInt
  extends Number
  implements Comparable<MutableInt>, Mutable<Number>
{
  private static final long serialVersionUID = 512176391864L;
  private int value;
  
  public MutableInt() {}
  
  public MutableInt(int value)
  {
    this.value = value;
  }
  
  public MutableInt(Number value)
  {
    this.value = value.intValue();
  }
  
  public MutableInt(String value)
    throws NumberFormatException
  {
    this.value = Integer.parseInt(value);
  }
  
  public Integer getValue()
  {
    return Integer.valueOf(value);
  }
  
  public void setValue(int value)
  {
    this.value = value;
  }
  
  public void setValue(Number value)
  {
    this.value = value.intValue();
  }
  
  public void increment()
  {
    value += 1;
  }
  
  public void decrement()
  {
    value -= 1;
  }
  
  public void add(int operand)
  {
    value += operand;
  }
  
  public void add(Number operand)
  {
    value += operand.intValue();
  }
  
  public void subtract(int operand)
  {
    value -= operand;
  }
  
  public void subtract(Number operand)
  {
    value -= operand.intValue();
  }
  
  public int intValue()
  {
    return value;
  }
  
  public long longValue()
  {
    return value;
  }
  
  public float floatValue()
  {
    return value;
  }
  
  public double doubleValue()
  {
    return value;
  }
  
  public Integer toInteger()
  {
    return Integer.valueOf(intValue());
  }
  
  public boolean equals(Object obj)
  {
    if ((obj instanceof MutableInt)) {
      return value == ((MutableInt)obj).intValue();
    }
    return false;
  }
  
  public int hashCode()
  {
    return value;
  }
  
  public int compareTo(MutableInt other)
  {
    int anotherVal = value;
    return value == anotherVal ? 0 : value < anotherVal ? -1 : 1;
  }
  
  public String toString()
  {
    return String.valueOf(value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.mutable.MutableInt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */