package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.presign;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.auth.AWSCredentialsProvider;

public class PresignerFacade$PresigningRequest
  extends AmazonWebServiceRequest
{
  public PresigningRequest withRequestCredentialsProvider(AWSCredentialsProvider credentialsProvider)
  {
    setRequestCredentialsProvider(credentialsProvider);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.presign.PresignerFacade.PresigningRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */