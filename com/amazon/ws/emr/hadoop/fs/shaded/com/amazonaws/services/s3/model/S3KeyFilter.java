package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class S3KeyFilter
  implements Serializable
{
  private List<FilterRule> filterRules;
  
  public static enum FilterRuleName
  {
    Prefix,  Suffix;
    
    private FilterRuleName() {}
    
    public FilterRule newRule()
    {
      return new FilterRule().withName(toString());
    }
    
    public FilterRule newRule(String value)
    {
      return newRule().withValue(value);
    }
  }
  
  public S3KeyFilter()
  {
    filterRules = new ArrayList();
  }
  
  public List<FilterRule> getFilterRules()
  {
    return Collections.unmodifiableList(filterRules);
  }
  
  public void setFilterRules(List<FilterRule> filterRules)
  {
    this.filterRules = new ArrayList(filterRules);
  }
  
  public S3KeyFilter withFilterRules(List<FilterRule> filterRules)
  {
    setFilterRules(filterRules);
    return this;
  }
  
  public S3KeyFilter withFilterRules(FilterRule... filterRules)
  {
    setFilterRules(Arrays.asList(filterRules));
    return this;
  }
  
  public void addFilterRule(FilterRule filterRule)
  {
    filterRules.add(filterRule);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3KeyFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */