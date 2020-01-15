package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SignableRequest;
import com.amazonaws.auth.AWSCredentials;

public class NoOpSigner
  implements Signer
{
  public void sign(SignableRequest<?> request, AWSCredentials credentials) {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.NoOpSigner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */