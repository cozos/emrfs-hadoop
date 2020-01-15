package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io;

public final class NumberOutput
{
  private static final char NC = '\000';
  private static int MILLION = 1000000;
  private static int BILLION = 1000000000;
  private static long TEN_BILLION_L = 10000000000L;
  private static long THOUSAND_L = 1000L;
  private static long MIN_INT_AS_LONG = -2147483648L;
  private static long MAX_INT_AS_LONG = 2147483647L;
  static final String SMALLEST_LONG = String.valueOf(Long.MIN_VALUE);
  static final char[] LEAD_3 = new char['ྠ'];
  static final char[] FULL_3 = new char['ྠ'];
  static final byte[] FULL_TRIPLETS_B;
  
  static
  {
    int ix = 0;
    for (int i1 = 0; i1 < 10; i1++)
    {
      char f1 = (char)(48 + i1);
      char l1 = i1 == 0 ? '\000' : f1;
      for (int i2 = 0; i2 < 10; i2++)
      {
        char f2 = (char)(48 + i2);
        char l2 = (i1 == 0) && (i2 == 0) ? '\000' : f2;
        for (int i3 = 0; i3 < 10; i3++)
        {
          char f3 = (char)(48 + i3);
          LEAD_3[ix] = l1;
          LEAD_3[(ix + 1)] = l2;
          LEAD_3[(ix + 2)] = f3;
          FULL_3[ix] = f1;
          FULL_3[(ix + 1)] = f2;
          FULL_3[(ix + 2)] = f3;
          ix += 4;
        }
      }
    }
    FULL_TRIPLETS_B = new byte['ྠ'];
    for (int i = 0; i < 4000; i++) {
      FULL_TRIPLETS_B[i] = ((byte)FULL_3[i]);
    }
  }
  
  static final String[] sSmallIntStrs = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
  static final String[] sSmallIntStrs2 = { "-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10" };
  
  public static int outputInt(int v, char[] b, int off)
  {
    if (v < 0)
    {
      if (v == Integer.MIN_VALUE) {
        return outputLong(v, b, off);
      }
      b[(off++)] = '-';
      v = -v;
    }
    if (v < MILLION)
    {
      if (v < 1000)
      {
        if (v < 10) {
          b[(off++)] = ((char)(48 + v));
        } else {
          off = leading3(v, b, off);
        }
      }
      else
      {
        int thousands = v / 1000;
        v -= thousands * 1000;
        off = leading3(thousands, b, off);
        off = full3(v, b, off);
      }
      return off;
    }
    boolean hasBillions = v >= BILLION;
    if (hasBillions)
    {
      v -= BILLION;
      if (v >= BILLION)
      {
        v -= BILLION;
        b[(off++)] = '2';
      }
      else
      {
        b[(off++)] = '1';
      }
    }
    int newValue = v / 1000;
    int ones = v - newValue * 1000;
    v = newValue;
    newValue /= 1000;
    int thousands = v - newValue * 1000;
    if (hasBillions) {
      off = full3(newValue, b, off);
    } else {
      off = leading3(newValue, b, off);
    }
    off = full3(thousands, b, off);
    off = full3(ones, b, off);
    return off;
  }
  
  public static int outputInt(int v, byte[] b, int off)
  {
    if (v < 0)
    {
      if (v == Integer.MIN_VALUE) {
        return outputLong(v, b, off);
      }
      b[(off++)] = 45;
      v = -v;
    }
    if (v < MILLION)
    {
      if (v < 1000)
      {
        if (v < 10) {
          b[(off++)] = ((byte)(48 + v));
        } else {
          off = leading3(v, b, off);
        }
      }
      else
      {
        int thousands = v / 1000;
        v -= thousands * 1000;
        off = leading3(thousands, b, off);
        off = full3(v, b, off);
      }
      return off;
    }
    boolean hasB = v >= BILLION;
    if (hasB)
    {
      v -= BILLION;
      if (v >= BILLION)
      {
        v -= BILLION;
        b[(off++)] = 50;
      }
      else
      {
        b[(off++)] = 49;
      }
    }
    int newValue = v / 1000;
    int ones = v - newValue * 1000;
    v = newValue;
    newValue /= 1000;
    int thousands = v - newValue * 1000;
    if (hasB) {
      off = full3(newValue, b, off);
    } else {
      off = leading3(newValue, b, off);
    }
    off = full3(thousands, b, off);
    off = full3(ones, b, off);
    return off;
  }
  
  public static int outputLong(long v, char[] b, int off)
  {
    if (v < 0L)
    {
      if (v > MIN_INT_AS_LONG) {
        return outputInt((int)v, b, off);
      }
      if (v == Long.MIN_VALUE)
      {
        int len = SMALLEST_LONG.length();
        SMALLEST_LONG.getChars(0, len, b, off);
        return off + len;
      }
      b[(off++)] = '-';
      v = -v;
    }
    else if (v <= MAX_INT_AS_LONG)
    {
      return outputInt((int)v, b, off);
    }
    int origOffset = off;
    off += calcLongStrLength(v);
    int ptr = off;
    while (v > MAX_INT_AS_LONG)
    {
      ptr -= 3;
      long newValue = v / THOUSAND_L;
      int triplet = (int)(v - newValue * THOUSAND_L);
      full3(triplet, b, ptr);
      v = newValue;
    }
    int ivalue = (int)v;
    while (ivalue >= 1000)
    {
      ptr -= 3;
      int newValue = ivalue / 1000;
      int triplet = ivalue - newValue * 1000;
      full3(triplet, b, ptr);
      ivalue = newValue;
    }
    leading3(ivalue, b, origOffset);
    
    return off;
  }
  
  public static int outputLong(long v, byte[] b, int off)
  {
    if (v < 0L)
    {
      if (v > MIN_INT_AS_LONG) {
        return outputInt((int)v, b, off);
      }
      if (v == Long.MIN_VALUE)
      {
        int len = SMALLEST_LONG.length();
        for (int i = 0; i < len; i++) {
          b[(off++)] = ((byte)SMALLEST_LONG.charAt(i));
        }
        return off;
      }
      b[(off++)] = 45;
      v = -v;
    }
    else if (v <= MAX_INT_AS_LONG)
    {
      return outputInt((int)v, b, off);
    }
    int origOff = off;
    off += calcLongStrLength(v);
    int ptr = off;
    while (v > MAX_INT_AS_LONG)
    {
      ptr -= 3;
      long newV = v / THOUSAND_L;
      int t = (int)(v - newV * THOUSAND_L);
      full3(t, b, ptr);
      v = newV;
    }
    int ivalue = (int)v;
    while (ivalue >= 1000)
    {
      ptr -= 3;
      int newV = ivalue / 1000;
      int t = ivalue - newV * 1000;
      full3(t, b, ptr);
      ivalue = newV;
    }
    leading3(ivalue, b, origOff);
    return off;
  }
  
  public static String toString(int v)
  {
    if (v < sSmallIntStrs.length)
    {
      if (v >= 0) {
        return sSmallIntStrs[v];
      }
      int v2 = -v - 1;
      if (v2 < sSmallIntStrs2.length) {
        return sSmallIntStrs2[v2];
      }
    }
    return Integer.toString(v);
  }
  
  public static String toString(long v)
  {
    if ((v <= 2147483647L) && (v >= -2147483648L)) {
      return toString((int)v);
    }
    return Long.toString(v);
  }
  
  public static String toString(double v)
  {
    return Double.toString(v);
  }
  
  public static String toString(float v)
  {
    return Float.toString(v);
  }
  
  private static int leading3(int t, char[] b, int off)
  {
    int digitOffset = t << 2;
    char c = LEAD_3[(digitOffset++)];
    if (c != 0) {
      b[(off++)] = c;
    }
    c = LEAD_3[(digitOffset++)];
    if (c != 0) {
      b[(off++)] = c;
    }
    b[(off++)] = LEAD_3[digitOffset];
    return off;
  }
  
  private static int leading3(int t, byte[] b, int off)
  {
    int digitOffset = t << 2;
    char c = LEAD_3[(digitOffset++)];
    if (c != 0) {
      b[(off++)] = ((byte)c);
    }
    c = LEAD_3[(digitOffset++)];
    if (c != 0) {
      b[(off++)] = ((byte)c);
    }
    b[(off++)] = ((byte)LEAD_3[digitOffset]);
    return off;
  }
  
  private static int full3(int t, char[] b, int off)
  {
    int digitOffset = t << 2;
    b[(off++)] = FULL_3[(digitOffset++)];
    b[(off++)] = FULL_3[(digitOffset++)];
    b[(off++)] = FULL_3[digitOffset];
    return off;
  }
  
  private static int full3(int t, byte[] b, int off)
  {
    int digitOffset = t << 2;
    b[(off++)] = FULL_TRIPLETS_B[(digitOffset++)];
    b[(off++)] = FULL_TRIPLETS_B[(digitOffset++)];
    b[(off++)] = FULL_TRIPLETS_B[digitOffset];
    return off;
  }
  
  private static int calcLongStrLength(long v)
  {
    int len = 10;
    long cmp = TEN_BILLION_L;
    while ((v >= cmp) && 
      (len != 19))
    {
      len++;
      cmp = (cmp << 3) + (cmp << 1);
    }
    return len;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.NumberOutput
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */