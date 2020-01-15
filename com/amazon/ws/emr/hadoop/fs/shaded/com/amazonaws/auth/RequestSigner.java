package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SignableRequest;

public abstract interface RequestSigner
{
  public abstract void sign(SignableRequest<?> paramSignableRequest);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.RequestSigner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */