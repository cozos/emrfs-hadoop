package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.net;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.DecoderException;

class Utils
{
  static int digit16(byte b)
    throws DecoderException
  {
    int i = Character.digit((char)b, 16);
    if (i == -1) {
      throw new DecoderException("Invalid URL encoding: not a valid digit (radix 16): " + b);
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.net.Utils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */