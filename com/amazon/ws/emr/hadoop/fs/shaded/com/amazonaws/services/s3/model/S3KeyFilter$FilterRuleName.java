package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

public enum S3KeyFilter$FilterRuleName
{
  Prefix,  Suffix;
  
  private S3KeyFilter$FilterRuleName() {}
  
  public FilterRule newRule()
  {
    return new FilterRule().withName(toString());
  }
  
  public FilterRule newRule(String value)
  {
    return newRule().withValue(value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3KeyFilter.FilterRuleName
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */