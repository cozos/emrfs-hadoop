package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException.ErrorType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AmazonS3Exception;
import java.util.HashMap;
import java.util.Map;

public class AmazonS3ExceptionBuilder
{
  private String requestId;
  private String errorCode;
  private String errorMessage;
  private int statusCode;
  private String extendedRequestId;
  private String cloudFrontId;
  private Map<String, String> additionalDetails;
  private String errorResponseXml;
  
  public String getRequestId()
  {
    return requestId;
  }
  
  public void setRequestId(String requestId)
  {
    this.requestId = requestId;
  }
  
  public void setErrorCode(String errorCode)
  {
    this.errorCode = errorCode;
  }
  
  public String getErrorCode()
  {
    return errorCode;
  }
  
  public String getErrorMessage()
  {
    return errorMessage;
  }
  
  public void setErrorMessage(String errorMessage)
  {
    this.errorMessage = errorMessage;
  }
  
  public void setStatusCode(int statusCode)
  {
    this.statusCode = statusCode;
  }
  
  public int getStatusCode()
  {
    return statusCode;
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
  
  public void addAdditionalDetail(String key, String detail)
  {
    if ((detail == null) || (detail.trim().isEmpty())) {
      return;
    }
    if (additionalDetails == null) {
      additionalDetails = new HashMap();
    }
    String additionalContent = (String)additionalDetails.get(key);
    if ((additionalContent != null) && (!additionalContent.trim().isEmpty())) {
      detail = additionalContent + "-" + detail;
    }
    if (!detail.isEmpty()) {
      additionalDetails.put(key, detail);
    }
  }
  
  public String getErrorResponseXml()
  {
    return errorResponseXml;
  }
  
  public void setErrorResponseXml(String errorResponseXml)
  {
    this.errorResponseXml = errorResponseXml;
  }
  
  public AmazonS3Exception build()
  {
    AmazonS3Exception s3Exception = errorResponseXml == null ? new AmazonS3Exception(errorMessage) : new AmazonS3Exception(errorMessage, errorResponseXml);
    
    s3Exception.setErrorCode(errorCode);
    s3Exception.setExtendedRequestId(extendedRequestId);
    s3Exception.setStatusCode(statusCode);
    s3Exception.setRequestId(requestId);
    s3Exception.setCloudFrontId(cloudFrontId);
    s3Exception.setAdditionalDetails(additionalDetails);
    s3Exception.setErrorType(errorTypeOf(statusCode));
    return s3Exception;
  }
  
  private AmazonServiceException.ErrorType errorTypeOf(int statusCode)
  {
    return statusCode >= 500 ? AmazonServiceException.ErrorType.Service : AmazonServiceException.ErrorType.Client;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.AmazonS3ExceptionBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */