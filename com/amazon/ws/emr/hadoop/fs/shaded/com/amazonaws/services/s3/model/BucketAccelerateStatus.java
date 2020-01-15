package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

public enum BucketAccelerateStatus
{
  Enabled("Enabled"),  Suspended("Suspended");
  
  private final String accelerateStatus;
  
  public static BucketAccelerateStatus fromValue(String statusString)
    throws IllegalArgumentException
  {
    for (BucketAccelerateStatus accelerateStatus : ) {
      if (accelerateStatus.toString().equals(statusString)) {
        return accelerateStatus;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + statusString + " value!");
  }
  
  private BucketAccelerateStatus(String status)
  {
    accelerateStatus = status;
  }
  
  public String toString()
  {
    return accelerateStatus;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketAccelerateStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */