package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import java.io.Serializable;

@Immutable
class BasicNameValuePair
  implements NameValuePair, Cloneable, Serializable
{
  private static final long serialVersionUID = 1L;
  public static final int HASH_SEED = 17;
  public static final int HASH_OFFSET = 37;
  private final String name;
  private final String value;
  
  BasicNameValuePair(String name, String value)
  {
    if (name == null) {
      throw new IllegalArgumentException("Name must not be null");
    }
    this.name = name;
    this.value = value;
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getValue()
  {
    return value;
  }
  
  public String toString()
  {
    if (value == null) {
      return name;
    }
    int len = name.length() + 1 + value.length();
    StringBuilder buffer = new StringBuilder(len);
    buffer.append(name);
    buffer.append("=");
    buffer.append(value);
    return buffer.toString();
  }
  
  public boolean equals(Object object)
  {
    if (this == object) {
      return true;
    }
    if ((object instanceof NameValuePair))
    {
      BasicNameValuePair that = (BasicNameValuePair)object;
      return (name.equals(name)) && 
        (equals(value, value));
    }
    return false;
  }
  
  private static boolean equals(Object obj1, Object obj2)
  {
    return obj1 == null ? false : obj2 == null ? true : obj1.equals(obj2);
  }
  
  public int hashCode()
  {
    int hash = 17;
    hash = hashCode(hash, name);
    hash = hashCode(hash, value);
    return hash;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
  
  private static int hashCode(int seed, Object obj)
  {
    return hashCode(seed, obj != null ? obj.hashCode() : 0);
  }
  
  private static int hashCode(int seed, int hashcode)
  {
    return seed * 37 + hashcode;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.BasicNameValuePair
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */