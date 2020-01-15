package com.amazonaws.services.sqs.internal.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.Signer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.SignerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.SignerProviderContext;

public class SQSSignerProvider
  extends SignerProvider
{
  private final AmazonWebServiceClient awsClient;
  
  public SQSSignerProvider(AmazonWebServiceClient awsClient, Signer signer)
  {
    this.awsClient = awsClient;
  }
  
  public Signer getSigner(SignerProviderContext context)
  {
    return awsClient.getSignerByURI(context.getUri());
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.internal.auth.SQSSignerProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */