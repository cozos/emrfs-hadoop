package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

abstract interface Codec
{
  public abstract byte[] encode(byte[] paramArrayOfByte);
  
  public abstract byte[] decode(byte[] paramArrayOfByte, int paramInt);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Codec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */