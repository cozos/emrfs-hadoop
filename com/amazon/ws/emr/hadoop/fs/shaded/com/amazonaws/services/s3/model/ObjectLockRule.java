package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class ObjectLockRule
  implements Serializable
{
  private DefaultRetention defaultRetention;
  
  public DefaultRetention getDefaultRetention()
  {
    return defaultRetention;
  }
  
  public ObjectLockRule withDefaultRetention(DefaultRetention defaultRetention)
  {
    this.defaultRetention = defaultRetention;
    return this;
  }
  
  public void setDefaultRetention(DefaultRetention defaultRetention)
  {
    withDefaultRetention(defaultRetention);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectLockRule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */