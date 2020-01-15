package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

class Base32Codec
  extends AbstractBase32Codec
{
  private static final int OFFSET_OF_2 = 24;
  
  private static class LazyHolder
  {
    private static final byte[] DECODED = ;
    
    private static byte[] decodeTable()
    {
      byte[] dest = new byte[123];
      for (int i = 0; i <= 122; i++) {
        if ((i >= 65) && (i <= 90)) {
          dest[i] = ((byte)(i - 65));
        } else if ((i >= 50) && (i <= 55)) {
          dest[i] = ((byte)(i - 24));
        } else if ((i >= 97) && (i <= 122)) {
          dest[i] = ((byte)(i - 97));
        } else {
          dest[i] = -1;
        }
      }
      return dest;
    }
  }
  
  private static byte[] alphabets()
  {
    return CodecUtils.toBytesDirect("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567");
  }
  
  Base32Codec()
  {
    super(alphabets());
  }
  
  protected int pos(byte in)
  {
    int pos = LazyHolder.DECODED[in];
    if (pos > -1) {
      return pos;
    }
    throw new IllegalArgumentException("Invalid base 32 character: '" + (char)in + "'");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Base32Codec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */