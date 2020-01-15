package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

abstract class AbstractBase32Codec
  implements Codec
{
  private static final int MASK_2BITS = 3;
  private static final int MASK_3BITS = 7;
  private static final int MASK_4BITS = 15;
  private static final int MASK_5BITS = 31;
  private static final byte PAD = 61;
  private final byte[] alphabets;
  
  protected AbstractBase32Codec(byte[] alphabets)
  {
    this.alphabets = alphabets;
  }
  
  public final byte[] encode(byte[] src)
  {
    int num5bytes = src.length / 5;
    int remainder = src.length % 5;
    if (remainder == 0)
    {
      byte[] dest = new byte[num5bytes * 8];
      
      int s = 0;
      for (int d = 0; s < src.length; d += 8)
      {
        encode5bytes(src, s, dest, d);s += 5;
      }
      return dest;
    }
    byte[] dest = new byte[(num5bytes + 1) * 8];
    int s = 0;
    for (int d = 0; s < src.length - remainder; d += 8)
    {
      encode5bytes(src, s, dest, d);s += 5;
    }
    switch (remainder)
    {
    case 1: 
      encode1byte(src, s, dest, d);
      break;
    case 2: 
      encode2bytes(src, s, dest, d);
      break;
    case 3: 
      encode3bytes(src, s, dest, d);
      break;
    case 4: 
      encode4bytes(src, s, dest, d);
      break;
    default: 
      throw new IllegalStateException();
    }
    return dest;
  }
  
  private final void encode5bytes(byte[] src, int s, byte[] dest, int d)
  {
    byte p;
    dest[(d++)] = alphabets[((p = src[(s++)]) >>> 3 & 0x1F)];
    dest[(d++)] = alphabets[((p & 0x7) << 2 | (p = src[(s++)]) >>> 6 & 0x3)];
    dest[(d++)] = alphabets[(p >>> 1 & 0x1F)];
    dest[(d++)] = alphabets[((p & 0x1) << 4 | (p = src[(s++)]) >>> 4 & 0xF)];
    dest[(d++)] = alphabets[((p & 0xF) << 1 | (p = src[(s++)]) >>> 7 & 0x1)];
    dest[(d++)] = alphabets[(p >>> 2 & 0x1F)];
    dest[(d++)] = alphabets[((p & 0x3) << 3 | (p = src[s]) >>> 5 & 0x7)];
    dest[d] = alphabets[(p & 0x1F)];
  }
  
  private final void encode4bytes(byte[] src, int s, byte[] dest, int d)
  {
    byte p;
    dest[(d++)] = alphabets[((p = src[(s++)]) >>> 3 & 0x1F)];
    dest[(d++)] = alphabets[((p & 0x7) << 2 | (p = src[(s++)]) >>> 6 & 0x3)];
    dest[(d++)] = alphabets[(p >>> 1 & 0x1F)];
    dest[(d++)] = alphabets[((p & 0x1) << 4 | (p = src[(s++)]) >>> 4 & 0xF)];
    dest[(d++)] = alphabets[((p & 0xF) << 1 | (p = src[s]) >>> 7 & 0x1)];
    dest[(d++)] = alphabets[(p >>> 2 & 0x1F)];
    dest[(d++)] = alphabets[((p & 0x3) << 3)];
    dest[d] = 61;
  }
  
  private final void encode3bytes(byte[] src, int s, byte[] dest, int d)
  {
    byte p;
    dest[(d++)] = alphabets[((p = src[(s++)]) >>> 3 & 0x1F)];
    dest[(d++)] = alphabets[((p & 0x7) << 2 | (p = src[(s++)]) >>> 6 & 0x3)];
    dest[(d++)] = alphabets[(p >>> 1 & 0x1F)];
    dest[(d++)] = alphabets[((p & 0x1) << 4 | (p = src[s]) >>> 4 & 0xF)];
    dest[(d++)] = alphabets[((p & 0xF) << 1)];
    for (int i = 0; i < 3; i++) {
      dest[(d++)] = 61;
    }
  }
  
  private final void encode2bytes(byte[] src, int s, byte[] dest, int d)
  {
    byte p;
    dest[(d++)] = alphabets[((p = src[(s++)]) >>> 3 & 0x1F)];
    dest[(d++)] = alphabets[((p & 0x7) << 2 | (p = src[s]) >>> 6 & 0x3)];
    dest[(d++)] = alphabets[(p >>> 1 & 0x1F)];
    dest[(d++)] = alphabets[((p & 0x1) << 4)];
    for (int i = 0; i < 4; i++) {
      dest[(d++)] = 61;
    }
  }
  
  private final void encode1byte(byte[] src, int s, byte[] dest, int d)
  {
    byte p;
    dest[(d++)] = alphabets[((p = src[s]) >>> 3 & 0x1F)];
    dest[(d++)] = alphabets[((p & 0x7) << 2)];
    for (int i = 0; i < 6; i++) {
      dest[(d++)] = 61;
    }
  }
  
  private final void decode5bytes(byte[] src, int s, byte[] dest, int d)
  {
    int p = 0;
    
    dest[(d++)] = 
    
      ((byte)(pos(src[(s++)]) << 3 | (p = pos(src[(s++)])) >>> 2 & 0x7));
    
    dest[(d++)] = 
    
      ((byte)((p & 0x3) << 6 | pos(src[(s++)]) << 1 | (p = pos(src[(s++)])) >>> 4 & 0x1));
    
    dest[(d++)] = 
    
      ((byte)((p & 0xF) << 4 | (p = pos(src[(s++)])) >>> 1 & 0xF));
    
    dest[(d++)] = 
    
      ((byte)((p & 0x1) << 7 | pos(src[(s++)]) << 2 | (p = pos(src[(s++)])) >>> 3 & 0x3));
    
    dest[d] = 
    
      ((byte)((p & 0x7) << 5 | pos(src[s])));
  }
  
  private final void decode1to4bytes(int n, byte[] src, int s, byte[] dest, int d)
  {
    int p = 0;
    
    dest[(d++)] = 
    
      ((byte)(pos(src[(s++)]) << 3 | (p = pos(src[(s++)])) >>> 2 & 0x7));
    if (n == 1)
    {
      CodecUtils.sanityCheckLastPos(p, 3);
      return;
    }
    dest[(d++)] = ((byte)((p & 0x3) << 6 | pos(src[(s++)]) << 1 | (p = pos(src[(s++)])) >>> 4 & 0x1));
    if (n == 2)
    {
      CodecUtils.sanityCheckLastPos(p, 15);
      return;
    }
    dest[(d++)] = ((byte)((p & 0xF) << 4 | (p = pos(src[(s++)])) >>> 1 & 0xF));
    if (n == 3)
    {
      CodecUtils.sanityCheckLastPos(p, 1);
      return;
    }
    dest[d] = ((byte)((p & 0x1) << 7 | pos(src[(s++)]) << 2 | (p = pos(src[s])) >>> 3 & 0x3));
    
    CodecUtils.sanityCheckLastPos(p, 7);
  }
  
  public final byte[] decode(byte[] src, int length)
  {
    if (length % 8 != 0) {
      throw new IllegalArgumentException("Input is expected to be encoded in multiple of 8 bytes but found: " + length);
    }
    int pads = 0;
    int last = length - 1;
    for (; (pads < 6) && (last > -1); pads++)
    {
      if (src[last] != 61) {
        break;
      }
      last--;
    }
    int fq;
    int fq;
    int fq;
    int fq;
    int fq;
    switch (pads)
    {
    case 0: 
      fq = 5;
      break;
    case 1: 
      fq = 4;
      break;
    case 3: 
      fq = 3;
      break;
    case 4: 
      fq = 2;
      break;
    case 6: 
      fq = 1;
      break;
    case 2: 
    case 5: 
    default: 
      throw new IllegalArgumentException("Invalid number of paddings " + pads);
    }
    int fq;
    byte[] dest = new byte[length / 8 * 5 - (5 - fq)];
    int s = 0;
    for (int d = 0; d < dest.length - fq % 5; d += 5)
    {
      decode5bytes(src, s, dest, d);s += 8;
    }
    if (fq < 5) {
      decode1to4bytes(fq, src, s, dest, d);
    }
    return dest;
  }
  
  protected abstract int pos(byte paramByte);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AbstractBase32Codec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */