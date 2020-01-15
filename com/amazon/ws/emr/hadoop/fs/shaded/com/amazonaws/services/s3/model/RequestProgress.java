package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class RequestProgress
  implements Serializable
{
  private Boolean enabled;
  
  public Boolean getEnabled()
  {
    return enabled;
  }
  
  public void setEnabled(Boolean enabled)
  {
    this.enabled = enabled;
  }
  
  public RequestProgress withEnabled(Boolean enabled)
  {
    setEnabled(enabled);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RequestProgress
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */