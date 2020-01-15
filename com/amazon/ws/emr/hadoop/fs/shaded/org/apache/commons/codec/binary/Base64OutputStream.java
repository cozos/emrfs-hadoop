package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.binary;

import java.io.OutputStream;

public class Base64OutputStream
  extends BaseNCodecOutputStream
{
  public Base64OutputStream(OutputStream out)
  {
    this(out, true);
  }
  
  public Base64OutputStream(OutputStream out, boolean doEncode)
  {
    super(out, new Base64(false), doEncode);
  }
  
  public Base64OutputStream(OutputStream out, boolean doEncode, int lineLength, byte[] lineSeparator)
  {
    super(out, new Base64(lineLength, lineSeparator), doEncode);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.binary.Base64OutputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */