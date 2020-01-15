package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class GlacierJobParameters
  implements Serializable
{
  private String tier;
  
  public String getTier()
  {
    return tier;
  }
  
  public void setTier(String tier)
  {
    this.tier = tier;
  }
  
  public void setTier(Tier tier)
  {
    setTier(tier == null ? null : tier.toString());
  }
  
  public GlacierJobParameters withTier(String tier)
  {
    setTier(tier);
    return this;
  }
  
  public GlacierJobParameters withTier(Tier tier)
  {
    setTier(tier);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GlacierJobParameters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */