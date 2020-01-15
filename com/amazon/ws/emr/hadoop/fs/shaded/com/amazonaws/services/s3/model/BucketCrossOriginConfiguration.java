package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class BucketCrossOriginConfiguration
  implements Serializable
{
  private List<CORSRule> rules;
  
  public List<CORSRule> getRules()
  {
    return rules;
  }
  
  public void setRules(List<CORSRule> rules)
  {
    this.rules = rules;
  }
  
  public BucketCrossOriginConfiguration withRules(List<CORSRule> rules)
  {
    setRules(rules);
    return this;
  }
  
  public BucketCrossOriginConfiguration withRules(CORSRule... rules)
  {
    setRules(Arrays.asList(rules));
    return this;
  }
  
  public BucketCrossOriginConfiguration(List<CORSRule> rules)
  {
    this.rules = rules;
  }
  
  public BucketCrossOriginConfiguration() {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketCrossOriginConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */