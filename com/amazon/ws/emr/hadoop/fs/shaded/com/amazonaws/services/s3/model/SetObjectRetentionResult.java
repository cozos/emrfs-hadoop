package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import java.io.Serializable;

public class SetObjectRetentionResult
  implements Serializable, S3RequesterChargedResult
{
  private boolean requesterCharged;
  
  public boolean isRequesterCharged()
  {
    return requesterCharged;
  }
  
  public SetObjectRetentionResult withRequesterCharged(Boolean requesterCharged)
  {
    this.requesterCharged = requesterCharged.booleanValue();
    return this;
  }
  
  public void setRequesterCharged(boolean isRequesterCharged)
  {
    withRequesterCharged(Boolean.valueOf(isRequesterCharged));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetObjectRetentionResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */