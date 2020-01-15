package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class Filter
  implements Serializable
{
  private S3KeyFilter s3KeyFilter;
  
  public S3KeyFilter getS3KeyFilter()
  {
    return s3KeyFilter;
  }
  
  public void setS3KeyFilter(S3KeyFilter s3KeyFilter)
  {
    this.s3KeyFilter = s3KeyFilter;
  }
  
  public Filter withS3KeyFilter(S3KeyFilter s3KeyFilter)
  {
    setS3KeyFilter(s3KeyFilter);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Filter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */