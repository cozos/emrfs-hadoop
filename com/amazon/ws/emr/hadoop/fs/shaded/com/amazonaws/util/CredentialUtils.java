package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestConfig;
import com.amazonaws.auth.AWSCredentialsProvider;

public class CredentialUtils
{
  public static AWSCredentialsProvider getCredentialsProvider(AmazonWebServiceRequest req, AWSCredentialsProvider base)
  {
    if ((req != null) && (req.getRequestCredentialsProvider() != null)) {
      return req.getRequestCredentialsProvider();
    }
    return base;
  }
  
  public static AWSCredentialsProvider getCredentialsProvider(RequestConfig requestConfig, AWSCredentialsProvider base)
  {
    if (requestConfig.getCredentialsProvider() != null) {
      return requestConfig.getCredentialsProvider();
    }
    return base;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.CredentialUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */