package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import java.io.IOException;

@Beta
public abstract interface ByteProcessor<T>
{
  public abstract boolean processBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract T getResult();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.ByteProcessor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */