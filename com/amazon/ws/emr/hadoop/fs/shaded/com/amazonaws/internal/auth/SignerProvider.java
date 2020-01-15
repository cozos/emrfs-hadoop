package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.Signer;

public abstract class SignerProvider
{
  public abstract Signer getSigner(SignerProviderContext paramSignerProviderContext);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.SignerProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */