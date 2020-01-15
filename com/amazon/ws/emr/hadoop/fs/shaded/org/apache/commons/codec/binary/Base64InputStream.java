package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.binary;

import java.io.InputStream;

public class Base64InputStream
  extends BaseNCodecInputStream
{
  public Base64InputStream(InputStream in)
  {
    this(in, false);
  }
  
  public Base64InputStream(InputStream in, boolean doEncode)
  {
    super(in, new Base64(false), doEncode);
  }
  
  public Base64InputStream(InputStream in, boolean doEncode, int lineLength, byte[] lineSeparator)
  {
    super(in, new Base64(lineLength, lineSeparator), doEncode);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.binary.Base64InputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */