package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

public abstract interface ServiceAwareSigner
  extends Signer
{
  public abstract void setServiceName(String paramString);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.ServiceAwareSigner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */