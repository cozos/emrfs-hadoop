package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec;

public abstract interface BinaryEncoder
  extends Encoder
{
  public abstract byte[] encode(byte[] paramArrayOfByte)
    throws EncoderException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.BinaryEncoder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */