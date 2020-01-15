package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.StringUtils;

class DurationFormatUtils$Token
{
  private final Object value;
  private int count;
  
  static boolean containsTokenWithValue(Token[] tokens, Object value)
  {
    int sz = tokens.length;
    for (int i = 0; i < sz; i++) {
      if (tokens[i].getValue() == value) {
        return true;
      }
    }
    return false;
  }
  
  DurationFormatUtils$Token(Object value)
  {
    this.value = value;
    count = 1;
  }
  
  DurationFormatUtils$Token(Object value, int count)
  {
    this.value = value;
    this.count = count;
  }
  
  void increment()
  {
    count += 1;
  }
  
  int getCount()
  {
    return count;
  }
  
  Object getValue()
  {
    return value;
  }
  
  public boolean equals(Object obj2)
  {
    if ((obj2 instanceof Token))
    {
      Token tok2 = (Token)obj2;
      if (value.getClass() != value.getClass()) {
        return false;
      }
      if (count != count) {
        return false;
      }
      if ((value instanceof StringBuilder)) {
        return value.toString().equals(value.toString());
      }
      if ((value instanceof Number)) {
        return value.equals(value);
      }
      return value == value;
    }
    return false;
  }
  
  public int hashCode()
  {
    return value.hashCode();
  }
  
  public String toString()
  {
    return StringUtils.repeat(value.toString(), count);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.time.DurationFormatUtils.Token
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */