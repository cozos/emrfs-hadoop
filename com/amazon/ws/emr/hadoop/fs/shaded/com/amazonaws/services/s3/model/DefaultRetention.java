package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class DefaultRetention
  implements Serializable
{
  private String mode;
  private Integer days;
  private Integer years;
  
  public String getMode()
  {
    return mode;
  }
  
  public DefaultRetention withMode(String mode)
  {
    this.mode = mode;
    return this;
  }
  
  public DefaultRetention withMode(ObjectLockRetentionMode mode)
  {
    return withMode(mode.toString());
  }
  
  public void setMode(ObjectLockRetentionMode mode)
  {
    withMode(mode);
  }
  
  public void setMode(String mode)
  {
    withMode(mode);
  }
  
  public Integer getDays()
  {
    return days;
  }
  
  public DefaultRetention withDays(Integer days)
  {
    this.days = days;
    return this;
  }
  
  public void setDays(Integer days)
  {
    withDays(days);
  }
  
  public Integer getYears()
  {
    return years;
  }
  
  public DefaultRetention withYears(Integer years)
  {
    this.years = years;
    return this;
  }
  
  public void setYears(Integer years)
  {
    withYears(years);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DefaultRetention
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */