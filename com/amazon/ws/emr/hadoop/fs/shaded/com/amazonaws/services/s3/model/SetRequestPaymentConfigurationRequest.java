package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class SetRequestPaymentConfigurationRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucketName;
  private RequestPaymentConfiguration configuration;
  
  public SetRequestPaymentConfigurationRequest(String bucketName, RequestPaymentConfiguration configuration)
  {
    setBucketName(bucketName);
    this.configuration = configuration;
  }
  
  public RequestPaymentConfiguration getConfiguration()
  {
    return configuration;
  }
  
  public void setConfiguration(RequestPaymentConfiguration configuration)
  {
    this.configuration = configuration;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetRequestPaymentConfigurationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */