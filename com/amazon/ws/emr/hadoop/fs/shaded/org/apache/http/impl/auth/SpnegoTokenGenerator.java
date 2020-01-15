package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth;

import java.io.IOException;

@Deprecated
public abstract interface SpnegoTokenGenerator
{
  public abstract byte[] generateSpnegoDERObject(byte[] paramArrayOfByte)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.auth.SpnegoTokenGenerator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */