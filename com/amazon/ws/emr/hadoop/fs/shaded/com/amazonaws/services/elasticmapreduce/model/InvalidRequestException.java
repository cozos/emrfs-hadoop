package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonProperty;

public class InvalidRequestException
  extends AmazonElasticMapReduceException
{
  private static final long serialVersionUID = 1L;
  private String emrErrorCode;
  
  public InvalidRequestException(String message)
  {
    super(message);
  }
  
  @JsonProperty("ErrorCode")
  public void setEmrErrorCode(String emrErrorCode)
  {
    this.emrErrorCode = emrErrorCode;
  }
  
  @JsonProperty("ErrorCode")
  public String getEmrErrorCode()
  {
    return emrErrorCode;
  }
  
  public InvalidRequestException withEmrErrorCode(String emrErrorCode)
  {
    setEmrErrorCode(emrErrorCode);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InvalidRequestException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */