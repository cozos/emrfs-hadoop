package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.binary;

import java.io.InputStream;

public class Base32InputStream
  extends BaseNCodecInputStream
{
  public Base32InputStream(InputStream in)
  {
    this(in, false);
  }
  
  public Base32InputStream(InputStream in, boolean doEncode)
  {
    super(in, new Base32(false), doEncode);
  }
  
  public Base32InputStream(InputStream in, boolean doEncode, int lineLength, byte[] lineSeparator)
  {
    super(in, new Base32(lineLength, lineSeparator), doEncode);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.binary.Base32InputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */