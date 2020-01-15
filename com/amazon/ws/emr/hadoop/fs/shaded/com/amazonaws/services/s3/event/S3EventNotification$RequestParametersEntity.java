package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.event;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonCreator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonProperty;

public class S3EventNotification$RequestParametersEntity
{
  private final String sourceIPAddress;
  
  @JsonCreator
  public S3EventNotification$RequestParametersEntity(@JsonProperty("sourceIPAddress") String sourceIPAddress)
  {
    this.sourceIPAddress = sourceIPAddress;
  }
  
  public String getSourceIPAddress()
  {
    return sourceIPAddress;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.event.S3EventNotification.RequestParametersEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */