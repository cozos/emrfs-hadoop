package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

class Base16Codec
  implements Codec
{
  private static final int OFFSET_OF_a = 87;
  private static final int OFFSET_OF_A = 55;
  private static final int MASK_4BITS = 15;
  private final byte[] alphabets;
  
  private static class LazyHolder
  {
    private static final byte[] DECODED = ;
    
    private static byte[] decodeTable()
    {
      byte[] dest = new byte[103];
      for (int i = 0; i <= 102; i++) {
        if ((i >= 48) && (i <= 57)) {
          dest[i] = ((byte)(i - 48));
        } else if ((i >= 65) && (i <= 70)) {
          dest[i] = ((byte)(i - 55));
        } else if ((i >= 97) && (i <= 102)) {
          dest[i] = ((byte)(i - 87));
        } else {
          dest[i] = -1;
        }
      }
      return dest;
    }
  }
  
  Base16Codec()
  {
    this(true);
  }
  
  Base16Codec(boolean upperCase)
  {
    alphabets = (upperCase ? CodecUtils.toBytesDirect("0123456789ABCDEF") : CodecUtils.toBytesDirect("0123456789abcdef"));
  }
  
  public byte[] encode(byte[] src)
  {
    byte[] dest = new byte[src.length * 2];
    
    int i = 0;
    for (int j = 0; i < src.length; i++)
    {
      byte p;
      dest[(j++)] = alphabets[((p = src[i]) >>> 4 & 0xF)];
      dest[(j++)] = alphabets[(p & 0xF)];
    }
    return dest;
  }
  
  public byte[] decode(byte[] src, int length)
  {
    if (length % 2 != 0) {
      throw new IllegalArgumentException("Input is expected to be encoded in multiple of 2 bytes but found: " + length);
    }
    byte[] dest = new byte[length / 2];
    
    int i = 0;
    for (int j = 0; j < dest.length; j++) {
      dest[j] = ((byte)(pos(src[(i++)]) << 4 | pos(src[(i++)])));
    }
    return dest;
  }
  
  protected int pos(byte in)
  {
    int pos = LazyHolder.DECODED[in];
    if (pos > -1) {
      return pos;
    }
    throw new IllegalArgumentException("Invalid base 16 character: '" + (char)in + "'");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Base16Codec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */