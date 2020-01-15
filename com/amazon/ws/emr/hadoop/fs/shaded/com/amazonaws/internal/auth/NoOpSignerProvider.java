package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.NoOpSigner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.Signer;

@SdkInternalApi
public class NoOpSignerProvider
  extends SignerProvider
{
  private Signer signer;
  
  public NoOpSignerProvider()
  {
    signer = new NoOpSigner();
  }
  
  public Signer getSigner(SignerProviderContext context)
  {
    return signer;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.NoOpSignerProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */