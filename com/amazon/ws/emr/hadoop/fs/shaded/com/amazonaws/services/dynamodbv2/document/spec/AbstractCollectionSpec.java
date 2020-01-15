package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;

abstract class AbstractCollectionSpec<T extends AmazonWebServiceRequest>
  extends AbstractSpec<T>
{
  private Integer maxPageSize;
  private Integer maxResultSize;
  
  AbstractCollectionSpec(T req)
  {
    super(req);
  }
  
  public AbstractCollectionSpec<T> withMaxResultSize(Integer maxResultSize)
  {
    this.maxResultSize = maxResultSize;
    return this;
  }
  
  public AbstractCollectionSpec<T> withMaxResultSize(int maxResultSize)
  {
    this.maxResultSize = Integer.valueOf(maxResultSize);
    return this;
  }
  
  public AbstractCollectionSpec<T> withMaxPageSize(Integer maxPageSize)
  {
    this.maxPageSize = maxPageSize;
    return this;
  }
  
  public AbstractCollectionSpec<T> withMaxPageSize(int maxPageSize)
  {
    this.maxPageSize = Integer.valueOf(maxPageSize);
    return this;
  }
  
  public Integer getMaxResultSize()
  {
    return maxResultSize;
  }
  
  public void setMaxResultSize(Integer maxResultSize)
  {
    this.maxResultSize = maxResultSize;
  }
  
  public void setMaxResultSize(int maxResultSize)
  {
    this.maxResultSize = Integer.valueOf(maxResultSize);
  }
  
  public Integer getMaxPageSize()
  {
    return maxPageSize;
  }
  
  public void setMaxPageSize(Integer value)
  {
    maxPageSize = value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.AbstractCollectionSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */