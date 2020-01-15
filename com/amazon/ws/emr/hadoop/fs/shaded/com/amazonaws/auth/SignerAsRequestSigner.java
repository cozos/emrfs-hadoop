package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SignableRequest;
import com.amazonaws.auth.AWSCredentialsProvider;

public final class SignerAsRequestSigner
  implements RequestSigner
{
  private final Signer signer;
  private final AWSCredentialsProvider credentialsProvider;
  
  public SignerAsRequestSigner(Signer signer, AWSCredentialsProvider credentialsProvider)
  {
    this.signer = signer;
    this.credentialsProvider = credentialsProvider;
  }
  
  public void sign(SignableRequest<?> request)
  {
    signer.sign(request, credentialsProvider.getCredentials());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.SignerAsRequestSigner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */