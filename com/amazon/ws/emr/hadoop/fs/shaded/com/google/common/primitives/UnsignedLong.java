package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;
import java.math.BigInteger;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
public final class UnsignedLong
  extends Number
  implements Comparable<UnsignedLong>, Serializable
{
  private static final long UNSIGNED_MASK = Long.MAX_VALUE;
  public static final UnsignedLong ZERO = new UnsignedLong(0L);
  public static final UnsignedLong ONE = new UnsignedLong(1L);
  public static final UnsignedLong MAX_VALUE = new UnsignedLong(-1L);
  private final long value;
  
  private UnsignedLong(long value)
  {
    this.value = value;
  }
  
  public static UnsignedLong fromLongBits(long bits)
  {
    return new UnsignedLong(bits);
  }
  
  public static UnsignedLong valueOf(long value)
  {
    Preconditions.checkArgument(value >= 0L, "value (%s) is outside the range for an unsigned long value", new Object[] { Long.valueOf(value) });
    
    return fromLongBits(value);
  }
  
  public static UnsignedLong valueOf(BigInteger value)
  {
    Preconditions.checkNotNull(value);
    Preconditions.checkArgument((value.signum() >= 0) && (value.bitLength() <= 64), "value (%s) is outside the range for an unsigned long value", new Object[] { value });
    
    return fromLongBits(value.longValue());
  }
  
  public static UnsignedLong valueOf(String string)
  {
    return valueOf(string, 10);
  }
  
  public static UnsignedLong valueOf(String string, int radix)
  {
    return fromLongBits(UnsignedLongs.parseUnsignedLong(string, radix));
  }
  
  public UnsignedLong plus(UnsignedLong val)
  {
    return fromLongBits(value + checkNotNullvalue);
  }
  
  public UnsignedLong minus(UnsignedLong val)
  {
    return fromLongBits(value - checkNotNullvalue);
  }
  
  @CheckReturnValue
  public UnsignedLong times(UnsignedLong val)
  {
    return fromLongBits(value * checkNotNullvalue);
  }
  
  @CheckReturnValue
  public UnsignedLong dividedBy(UnsignedLong val)
  {
    return fromLongBits(UnsignedLongs.divide(value, checkNotNullvalue));
  }
  
  @CheckReturnValue
  public UnsignedLong mod(UnsignedLong val)
  {
    return fromLongBits(UnsignedLongs.remainder(value, checkNotNullvalue));
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
    float fValue = (float)(value & 0x7FFFFFFFFFFFFFFF);
    if (value < 0L) {
      fValue += 9.223372E18F;
    }
    return fValue;
  }
  
  public double doubleValue()
  {
    double dValue = value & 0x7FFFFFFFFFFFFFFF;
    if (value < 0L) {
      dValue += 9.223372036854776E18D;
    }
    return dValue;
  }
  
  public BigInteger bigIntegerValue()
  {
    BigInteger bigInt = BigInteger.valueOf(value & 0x7FFFFFFFFFFFFFFF);
    if (value < 0L) {
      bigInt = bigInt.setBit(63);
    }
    return bigInt;
  }
  
  public int compareTo(UnsignedLong o)
  {
    Preconditions.checkNotNull(o);
    return UnsignedLongs.compare(value, value);
  }
  
  public int hashCode()
  {
    return Longs.hashCode(value);
  }
  
  public boolean equals(@Nullable Object obj)
  {
    if ((obj instanceof UnsignedLong))
    {
      UnsignedLong other = (UnsignedLong)obj;
      return value == value;
    }
    return false;
  }
  
  public String toString()
  {
    return UnsignedLongs.toString(value);
  }
  
  public String toString(int radix)
  {
    return UnsignedLongs.toString(value, radix);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.UnsignedLong
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */