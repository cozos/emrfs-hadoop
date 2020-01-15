package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

class Base16Codec$LazyHolder
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Base16Codec.LazyHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */