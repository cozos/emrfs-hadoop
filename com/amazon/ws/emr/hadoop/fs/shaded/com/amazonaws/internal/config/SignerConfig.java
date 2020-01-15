package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.config;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;

@Immutable
public class SignerConfig
{
  private final String signerType;
  
  SignerConfig(String signerType)
  {
    this.signerType = signerType;
  }
  
  SignerConfig(SignerConfig from)
  {
    signerType = from.getSignerType();
  }
  
  public String getSignerType()
  {
    return signerType;
  }
  
  public String toString()
  {
    return signerType;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.config.SignerConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */