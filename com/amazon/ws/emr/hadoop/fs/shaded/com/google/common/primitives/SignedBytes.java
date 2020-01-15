package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Comparator;

@GwtCompatible
public final class SignedBytes
{
  public static final byte MAX_POWER_OF_TWO = 64;
  
  public static byte checkedCast(long value)
  {
    byte result = (byte)(int)value;
    if (result != value)
    {
      long l = value;throw new IllegalArgumentException(34 + "Out of range: " + l);
    }
    return result;
  }
  
  public static byte saturatedCast(long value)
  {
    if (value > 127L) {
      return Byte.MAX_VALUE;
    }
    if (value < -128L) {
      return Byte.MIN_VALUE;
    }
    return (byte)(int)value;
  }
  
  public static int compare(byte a, byte b)
  {
    return a - b;
  }
  
  public static byte min(byte... array)
  {
    Preconditions.checkArgument(array.length > 0);
    byte min = array[0];
    for (int i = 1; i < array.length; i++) {
      if (array[i] < min) {
        min = array[i];
      }
    }
    return min;
  }
  
  public static byte max(byte... array)
  {
    Preconditions.checkArgument(array.length > 0);
    byte max = array[0];
    for (int i = 1; i < array.length; i++) {
      if (array[i] > max) {
        max = array[i];
      }
    }
    return max;
  }
  
  public static String join(String separator, byte... array)
  {
    Preconditions.checkNotNull(separator);
    if (array.length == 0) {
      return "";
    }
    StringBuilder builder = new StringBuilder(array.length * 5);
    builder.append(array[0]);
    for (int i = 1; i < array.length; i++) {
      builder.append(separator).append(array[i]);
    }
    return builder.toString();
  }
  
  public static Comparator<byte[]> lexicographicalComparator()
  {
    return LexicographicalComparator.INSTANCE;
  }
  
  private static enum LexicographicalComparator
    implements Comparator<byte[]>
  {
    INSTANCE;
    
    private LexicographicalComparator() {}
    
    public int compare(byte[] left, byte[] right)
    {
      int minLength = Math.min(left.length, right.length);
      for (int i = 0; i < minLength; i++)
      {
        int result = SignedBytes.compare(left[i], right[i]);
        if (result != 0) {
          return result;
        }
      }
      return left.length - right.length;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.SignedBytes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */