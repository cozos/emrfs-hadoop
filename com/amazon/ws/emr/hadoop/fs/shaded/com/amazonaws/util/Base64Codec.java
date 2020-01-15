package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

class Base64Codec
  implements Codec
{
  private static final int OFFSET_OF_a = 71;
  private static final int OFFSET_OF_0 = -4;
  private static final int OFFSET_OF_PLUS = -19;
  private static final int OFFSET_OF_SLASH = -16;
  private static final int MASK_2BITS = 3;
  private static final int MASK_4BITS = 15;
  private static final int MASK_6BITS = 63;
  private static final byte PAD = 61;
  private final byte[] alphabets;
  
  private static class LazyHolder
  {
    private static final byte[] DECODED = ;
    
    private static byte[] decodeTable()
    {
      byte[] dest = new byte[123];
      for (int i = 0; i <= 122; i++) {
        if ((i >= 65) && (i <= 90)) {
          dest[i] = ((byte)(i - 65));
        } else if ((i >= 48) && (i <= 57)) {
          dest[i] = ((byte)(i - -4));
        } else if (i == 43) {
          dest[i] = ((byte)(i - -19));
        } else if (i == 47) {
          dest[i] = ((byte)(i - -16));
        } else if ((i >= 97) && (i <= 122)) {
          dest[i] = ((byte)(i - 71));
        } else {
          dest[i] = -1;
        }
      }
      return dest;
    }
  }
  
  Base64Codec()
  {
    alphabets = CodecUtils.toBytesDirect("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
  }
  
  protected Base64Codec(byte[] alphabets)
  {
    this.alphabets = alphabets;
  }
  
  public byte[] encode(byte[] src)
  {
    int num3bytes = src.length / 3;
    int remainder = src.length % 3;
    if (remainder == 0)
    {
      byte[] dest = new byte[num3bytes * 4];
      
      int s = 0;
      for (int d = 0; s < src.length; d += 4)
      {
        encode3bytes(src, s, dest, d);s += 3;
      }
      return dest;
    }
    byte[] dest = new byte[(num3bytes + 1) * 4];
    int s = 0;
    for (int d = 0; s < src.length - remainder; d += 4)
    {
      encode3bytes(src, s, dest, d);s += 3;
    }
    switch (remainder)
    {
    case 1: 
      encode1byte(src, s, dest, d);
      break;
    case 2: 
      encode2bytes(src, s, dest, d);
      break;
    default: 
      throw new IllegalStateException();
    }
    return dest;
  }
  
  void encode3bytes(byte[] src, int s, byte[] dest, int d)
  {
    byte p;
    dest[(d++)] = alphabets[((p = src[(s++)]) >>> 2 & 0x3F)];
    dest[(d++)] = alphabets[((p & 0x3) << 4 | (p = src[(s++)]) >>> 4 & 0xF)];
    dest[(d++)] = alphabets[((p & 0xF) << 2 | (p = src[s]) >>> 6 & 0x3)];
    dest[d] = alphabets[(p & 0x3F)];
  }
  
  void encode2bytes(byte[] src, int s, byte[] dest, int d)
  {
    byte p;
    dest[(d++)] = alphabets[((p = src[(s++)]) >>> 2 & 0x3F)];
    dest[(d++)] = alphabets[((p & 0x3) << 4 | (p = src[s]) >>> 4 & 0xF)];
    dest[(d++)] = alphabets[((p & 0xF) << 2)];
    dest[d] = 61;
  }
  
  void encode1byte(byte[] src, int s, byte[] dest, int d)
  {
    byte p;
    dest[(d++)] = alphabets[((p = src[s]) >>> 2 & 0x3F)];
    dest[(d++)] = alphabets[((p & 0x3) << 4)];
    dest[(d++)] = 61;
    dest[d] = 61;
  }
  
  void decode4bytes(byte[] src, int s, byte[] dest, int d)
  {
    int p = 0;
    
    dest[(d++)] = 
    
      ((byte)(pos(src[(s++)]) << 2 | (p = pos(src[(s++)])) >>> 4 & 0x3));
    
    dest[(d++)] = 
    
      ((byte)((p & 0xF) << 4 | (p = pos(src[(s++)])) >>> 2 & 0xF));
    
    dest[d] = 
    
      ((byte)((p & 0x3) << 6 | pos(src[s])));
  }
  
  void decode1to3bytes(int n, byte[] src, int s, byte[] dest, int d)
  {
    int p = 0;
    
    dest[(d++)] = 
    
      ((byte)(pos(src[(s++)]) << 2 | (p = pos(src[(s++)])) >>> 4 & 0x3));
    if (n == 1)
    {
      CodecUtils.sanityCheckLastPos(p, 15);
      return;
    }
    dest[(d++)] = ((byte)((p & 0xF) << 4 | (p = pos(src[(s++)])) >>> 2 & 0xF));
    if (n == 2)
    {
      CodecUtils.sanityCheckLastPos(p, 3);
      return;
    }
    dest[d] = ((byte)((p & 0x3) << 6 | pos(src[s])));
  }
  
  public byte[] decode(byte[] src, int length)
  {
    if (length % 4 != 0) {
      throw new IllegalArgumentException("Input is expected to be encoded in multiple of 4 bytes but found: " + length);
    }
    int pads = 0;
    int last = length - 1;
    for (; (pads < 2) && (last > -1); pads++)
    {
      if (src[last] != 61) {
        break;
      }
      last--;
    }
    int fq;
    int fq;
    int fq;
    switch (pads)
    {
    case 0: 
      fq = 3;
      break;
    case 1: 
      fq = 2;
      break;
    case 2: 
      fq = 1;
      break;
    default: 
      throw new Error("Impossible");
    }
    int fq;
    byte[] dest = new byte[length / 4 * 3 - (3 - fq)];
    int s = 0;
    for (int d = 0; d < dest.length - fq % 3; d += 3)
    {
      decode4bytes(src, s, dest, d);s += 4;
    }
    if (fq < 3) {
      decode1to3bytes(fq, src, s, dest, d);
    }
    return dest;
  }
  
  protected int pos(byte in)
  {
    int pos = LazyHolder.DECODED[in];
    if (pos > -1) {
      return pos;
    }
    throw new IllegalArgumentException("Invalid base 64 character: '" + (char)in + "'");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Base64Codec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */