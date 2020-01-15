package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.AnonymousAWSCredentials;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazonaws.auth.AWSCredentials;

class S3CredentialsProviderChain
  extends DefaultAWSCredentialsProviderChain
{
  private static Log LOG = LogFactory.getLog(S3CredentialsProviderChain.class);
  
  public AWSCredentials getCredentials()
  {
    try
    {
      return super.getCredentials();
    }
    catch (AmazonClientException localAmazonClientException)
    {
      LOG.debug("No credentials available; falling back to anonymous access");
    }
    return new AnonymousAWSCredentials();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.S3CredentialsProviderChain
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */