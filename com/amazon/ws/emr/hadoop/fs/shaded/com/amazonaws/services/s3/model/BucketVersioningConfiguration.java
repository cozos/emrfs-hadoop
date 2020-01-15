package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class BucketVersioningConfiguration
  implements Serializable
{
  public static final String OFF = "Off";
  public static final String SUSPENDED = "Suspended";
  public static final String ENABLED = "Enabled";
  private String status;
  private Boolean isMfaDeleteEnabled = null;
  
  public BucketVersioningConfiguration()
  {
    setStatus("Off");
  }
  
  public BucketVersioningConfiguration(String status)
  {
    setStatus(status);
  }
  
  public String getStatus()
  {
    return status;
  }
  
  public void setStatus(String status)
  {
    this.status = status;
  }
  
  public BucketVersioningConfiguration withStatus(String status)
  {
    setStatus(status);
    return this;
  }
  
  public Boolean isMfaDeleteEnabled()
  {
    return isMfaDeleteEnabled;
  }
  
  public void setMfaDeleteEnabled(Boolean mfaDeleteEnabled)
  {
    isMfaDeleteEnabled = mfaDeleteEnabled;
  }
  
  public BucketVersioningConfiguration withMfaDeleteEnabled(Boolean mfaDeleteEnabled)
  {
    setMfaDeleteEnabled(mfaDeleteEnabled);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketVersioningConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */