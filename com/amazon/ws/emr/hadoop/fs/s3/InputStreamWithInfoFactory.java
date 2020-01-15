package com.amazon.ws.emr.hadoop.fs.s3;

import java.io.IOException;

public abstract interface InputStreamWithInfoFactory
{
  public abstract InputStreamWithInfo create(String paramString1, String paramString2, long paramLong1, long paramLong2, boolean paramBoolean)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.InputStreamWithInfoFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */