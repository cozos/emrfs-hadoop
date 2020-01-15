package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

class Base64Codec$LazyHolder
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Base64Codec.LazyHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */