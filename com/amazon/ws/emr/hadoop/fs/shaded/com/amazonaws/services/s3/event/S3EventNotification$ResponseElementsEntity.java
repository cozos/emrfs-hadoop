package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.event;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonCreator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonProperty;

public class S3EventNotification$ResponseElementsEntity
{
  private final String xAmzId2;
  private final String xAmzRequestId;
  
  @JsonCreator
  public S3EventNotification$ResponseElementsEntity(@JsonProperty("x-amz-id-2") String xAmzId2, @JsonProperty("x-amz-request-id") String xAmzRequestId)
  {
    this.xAmzId2 = xAmzId2;
    this.xAmzRequestId = xAmzRequestId;
  }
  
  @JsonProperty("x-amz-id-2")
  public String getxAmzId2()
  {
    return xAmzId2;
  }
  
  @JsonProperty("x-amz-request-id")
  public String getxAmzRequestId()
  {
    return xAmzRequestId;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.event.S3EventNotification.ResponseElementsEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */