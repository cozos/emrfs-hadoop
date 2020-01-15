package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SignableRequest;
import com.amazonaws.auth.AWSCredentials;

public abstract interface Signer
{
  public abstract void sign(SignableRequest<?> paramSignableRequest, AWSCredentials paramAWSCredentials);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.Signer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */