package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;

public final class SelectObjectContentEventException
  extends SdkClientException
{
  private String errorCode;
  private String errorMessage;
  
  public SelectObjectContentEventException(String exceptionMessage)
  {
    super(exceptionMessage);
  }
  
  public SelectObjectContentEventException(String exceptionMessage, Exception cause)
  {
    super(exceptionMessage, cause);
  }
  
  public String getMessage()
  {
    return super.getMessage();
  }
  
  public String getErrorCode()
  {
    return errorCode;
  }
  
  public void setErrorCode(String errorCode)
  {
    this.errorCode = errorCode;
  }
  
  public String getErrorMessage()
  {
    return errorMessage;
  }
  
  public void setErrorMessage(String errorMessage)
  {
    this.errorMessage = errorMessage;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentEventException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */