package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec;

public abstract interface BinaryDecoder
  extends Decoder
{
  public abstract byte[] decode(byte[] paramArrayOfByte)
    throws DecoderException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.codec.BinaryDecoder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */