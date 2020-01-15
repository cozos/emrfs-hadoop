package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

public abstract interface EndpointPrefixAwareSigner
  extends Signer
{
  public abstract void setEndpointPrefix(String paramString);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.EndpointPrefixAwareSigner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */