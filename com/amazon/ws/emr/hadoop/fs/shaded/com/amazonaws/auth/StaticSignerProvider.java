package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.SignerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.SignerProviderContext;

@SdkProtectedApi
public class StaticSignerProvider
  extends SignerProvider
{
  private final Signer signer;
  
  public StaticSignerProvider(Signer signer)
  {
    this.signer = signer;
  }
  
  public Signer getSigner(SignerProviderContext context)
  {
    return signer;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.StaticSignerProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */