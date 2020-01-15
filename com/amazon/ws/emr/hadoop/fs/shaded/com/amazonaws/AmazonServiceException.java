package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.Map;

public class AmazonServiceException
  extends SdkClientException
{
  private static final long serialVersionUID = 1L;
  private String requestId;
  private String errorCode;
  
  public static enum ErrorType
  {
    Client,  Service,  Unknown;
    
    private ErrorType() {}
  }
  
  private ErrorType errorType = ErrorType.Unknown;
  private String errorMessage;
  private int statusCode;
  private String serviceName;
  private Map<String, String> httpHeaders;
  private byte[] rawResponse;
  
  public AmazonServiceException(String errorMessage)
  {
    super((String)null);
    this.errorMessage = errorMessage;
  }
  
  public AmazonServiceException(String errorMessage, Exception cause)
  {
    super(null, cause);
    this.errorMessage = errorMessage;
  }
  
  public void setRequestId(String requestId)
  {
    this.requestId = requestId;
  }
  
  public String getRequestId()
  {
    return requestId;
  }
  
  public void setServiceName(String serviceName)
  {
    this.serviceName = serviceName;
  }
  
  public String getServiceName()
  {
    return serviceName;
  }
  
  public void setErrorCode(String errorCode)
  {
    this.errorCode = errorCode;
  }
  
  public String getErrorCode()
  {
    return errorCode;
  }
  
  public void setErrorType(ErrorType errorType)
  {
    this.errorType = errorType;
  }
  
  public ErrorType getErrorType()
  {
    return errorType;
  }
  
  public String getErrorMessage()
  {
    return errorMessage;
  }
  
  public void setErrorMessage(String value)
  {
    errorMessage = value;
  }
  
  public void setStatusCode(int statusCode)
  {
    this.statusCode = statusCode;
  }
  
  public int getStatusCode()
  {
    return statusCode;
  }
  
  public String getMessage()
  {
    return 
    
      getErrorMessage() + " (Service: " + getServiceName() + "; Status Code: " + getStatusCode() + "; Error Code: " + getErrorCode() + "; Request ID: " + getRequestId() + ")";
  }
  
  public String getRawResponseContent()
  {
    return rawResponse == null ? null : new String(rawResponse, StringUtils.UTF8);
  }
  
  public void setRawResponseContent(String rawResponseContent)
  {
    rawResponse = (rawResponseContent == null ? null : rawResponseContent.getBytes(StringUtils.UTF8));
  }
  
  public byte[] getRawResponse()
  {
    return rawResponse == null ? null : (byte[])rawResponse.clone();
  }
  
  public void setRawResponse(byte[] rawResponse)
  {
    this.rawResponse = (rawResponse == null ? null : (byte[])rawResponse.clone());
  }
  
  public Map<String, String> getHttpHeaders()
  {
    return httpHeaders;
  }
  
  public void setHttpHeaders(Map<String, String> httpHeaders)
  {
    this.httpHeaders = httpHeaders;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */