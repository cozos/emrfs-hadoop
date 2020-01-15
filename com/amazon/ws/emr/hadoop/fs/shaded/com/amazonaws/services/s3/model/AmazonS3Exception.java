package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import java.io.Serializable;
import java.util.Map;

public class AmazonS3Exception
  extends AmazonServiceException
  implements Serializable
{
  private static final long serialVersionUID = 7573680383273658477L;
  private String extendedRequestId;
  private String cloudFrontId;
  private Map<String, String> additionalDetails;
  private final String errorResponseXml;
  
  public AmazonS3Exception(String message)
  {
    super(message);
    errorResponseXml = null;
  }
  
  public AmazonS3Exception(String message, Exception cause)
  {
    super(message, cause);
    errorResponseXml = null;
  }
  
  public AmazonS3Exception(String message, String errorResponseXml)
  {
    super(message);
    if (errorResponseXml == null) {
      throw new IllegalArgumentException("Error Response XML cannot be null");
    }
    this.errorResponseXml = errorResponseXml;
  }
  
  public String getExtendedRequestId()
  {
    return extendedRequestId;
  }
  
  public void setExtendedRequestId(String extendedRequestId)
  {
    this.extendedRequestId = extendedRequestId;
  }
  
  public String getCloudFrontId()
  {
    return cloudFrontId;
  }
  
  public void setCloudFrontId(String cloudFrontId)
  {
    this.cloudFrontId = cloudFrontId;
  }
  
  public Map<String, String> getAdditionalDetails()
  {
    return additionalDetails;
  }
  
  public void setAdditionalDetails(Map<String, String> additionalDetails)
  {
    this.additionalDetails = additionalDetails;
  }
  
  public String toString()
  {
    return 
      super.toString() + ", S3 Extended Request ID: " + getExtendedRequestId();
  }
  
  public String getMessage()
  {
    return 
    
      getErrorMessage() + " (Service: " + getServiceName() + "; Status Code: " + getStatusCode() + "; Error Code: " + getErrorCode() + "; Request ID: " + getRequestId() + "; S3 Extended Request ID: " + getExtendedRequestId() + ")";
  }
  
  public String getErrorResponseXml()
  {
    return errorResponseXml;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AmazonS3Exception
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */