package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.math;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.math.BigInteger;
import javax.annotation.Nullable;

@GwtCompatible
final class MathPreconditions
{
  static int checkPositive(@Nullable String role, int x)
  {
    if (x <= 0)
    {
      String str = String.valueOf(String.valueOf(role));int i = x;throw new IllegalArgumentException(26 + str.length() + str + " (" + i + ") must be > 0");
    }
    return x;
  }
  
  static long checkPositive(@Nullable String role, long x)
  {
    if (x <= 0L)
    {
      String str = String.valueOf(String.valueOf(role));long l = x;throw new IllegalArgumentException(35 + str.length() + str + " (" + l + ") must be > 0");
    }
    return x;
  }
  
  static BigInteger checkPositive(@Nullable String role, BigInteger x)
  {
    if (x.signum() <= 0)
    {
      String str1 = String.valueOf(String.valueOf(role));String str2 = String.valueOf(String.valueOf(x));throw new IllegalArgumentException(15 + str1.length() + str2.length() + str1 + " (" + str2 + ") must be > 0");
    }
    return x;
  }
  
  static int checkNonNegative(@Nullable String role, int x)
  {
    if (x < 0)
    {
      String str = String.valueOf(String.valueOf(role));int i = x;throw new IllegalArgumentException(27 + str.length() + str + " (" + i + ") must be >= 0");
    }
    return x;
  }
  
  static long checkNonNegative(@Nullable String role, long x)
  {
    if (x < 0L)
    {
      String str = String.valueOf(String.valueOf(role));long l = x;throw new IllegalArgumentException(36 + str.length() + str + " (" + l + ") must be >= 0");
    }
    return x;
  }
  
  static BigInteger checkNonNegative(@Nullable String role, BigInteger x)
  {
    if (x.signum() < 0)
    {
      String str1 = String.valueOf(String.valueOf(role));String str2 = String.valueOf(String.valueOf(x));throw new IllegalArgumentException(16 + str1.length() + str2.length() + str1 + " (" + str2 + ") must be >= 0");
    }
    return x;
  }
  
  static double checkNonNegative(@Nullable String role, double x)
  {
    if (x < 0.0D)
    {
      String str = String.valueOf(String.valueOf(role));double d = x;throw new IllegalArgumentException(40 + str.length() + str + " (" + d + ") must be >= 0");
    }
    return x;
  }
  
  static void checkRoundingUnnecessary(boolean condition)
  {
    if (!condition) {
      throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
    }
  }
  
  static void checkInRange(boolean condition)
  {
    if (!condition) {
      throw new ArithmeticException("not in range");
    }
  }
  
  static void checkNoOverflow(boolean condition)
  {
    if (!condition) {
      throw new ArithmeticException("overflow");
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.math.MathPreconditions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */