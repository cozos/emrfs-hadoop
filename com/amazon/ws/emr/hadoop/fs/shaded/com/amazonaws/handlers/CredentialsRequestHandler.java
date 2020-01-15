package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers;

import com.amazonaws.auth.AWSCredentials;

@Deprecated
public abstract class CredentialsRequestHandler
  extends RequestHandler2
{
  protected AWSCredentials awsCredentials;
  
  public void setCredentials(AWSCredentials awsCredentials)
  {
    this.awsCredentials = awsCredentials;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.CredentialsRequestHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */