package com.amazon.ws.emr.hadoop.fs.s3.lite.call;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.auth.AWSCredentialsProvider;

abstract class AbstractS3Call<O, I extends AmazonWebServiceRequest, C extends AmazonS3>
  implements S3Call<O, C>
{
  protected final I request;
  
  protected AbstractS3Call(I request)
  {
    this.request = request;
  }
  
  public void setCredentialsProvider(AWSCredentialsProvider credentialsProvider)
  {
    request.setRequestCredentialsProvider(credentialsProvider);
  }
  
  public void enableRequesterPays()
  {
    request.putCustomRequestHeader("x-amz-request-payer", "requester");
  }
  
  public String toString()
  {
    return request.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.call.AbstractS3Call
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */