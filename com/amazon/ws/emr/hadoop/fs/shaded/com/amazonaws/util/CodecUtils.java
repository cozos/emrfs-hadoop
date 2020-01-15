package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

public enum CodecUtils
{
  private CodecUtils() {}
  
  static int sanitize(String singleOctets, byte[] dest)
  {
    int capacity = dest.length;
    char[] src = singleOctets.toCharArray();
    int limit = 0;
    for (int i = 0; i < capacity; i++)
    {
      char c = src[i];
      if ((c != '\r') && (c != '\n') && (c != ' '))
      {
        if (c > '') {
          throw new IllegalArgumentException("Invalid character found at position " + i + " for " + singleOctets);
        }
        dest[(limit++)] = ((byte)c);
      }
    }
    return limit;
  }
  
  public static byte[] toBytesDirect(String singleOctets)
  {
    char[] src = singleOctets.toCharArray();
    byte[] dest = new byte[src.length];
    for (int i = 0; i < dest.length; i++)
    {
      char c = src[i];
      if (c > '') {
        throw new IllegalArgumentException("Invalid character found at position " + i + " for " + singleOctets);
      }
      dest[i] = ((byte)c);
    }
    return dest;
  }
  
  public static String toStringDirect(byte[] bytes)
  {
    char[] dest = new char[bytes.length];
    int i = 0;
    for (byte b : bytes) {
      dest[(i++)] = ((char)b);
    }
    return new String(dest);
  }
  
  static void sanityCheckLastPos(int pos, int mask)
  {
    if ((pos & mask) != 0) {
      throw new IllegalArgumentException("Invalid last non-pad character detected");
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.CodecUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */