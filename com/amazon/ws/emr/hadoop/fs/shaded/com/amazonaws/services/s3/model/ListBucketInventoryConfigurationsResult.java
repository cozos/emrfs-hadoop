package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryConfiguration;
import java.io.Serializable;
import java.util.List;

public class ListBucketInventoryConfigurationsResult
  implements Serializable
{
  private List<InventoryConfiguration> inventoryConfigurationList;
  private String continuationToken;
  private boolean isTruncated;
  private String nextContinuationToken;
  
  public List<InventoryConfiguration> getInventoryConfigurationList()
  {
    return inventoryConfigurationList;
  }
  
  public void setInventoryConfigurationList(List<InventoryConfiguration> inventoryConfigurationList)
  {
    this.inventoryConfigurationList = inventoryConfigurationList;
  }
  
  public ListBucketInventoryConfigurationsResult withInventoryConfigurationList(List<InventoryConfiguration> inventoryConfigurationList)
  {
    setInventoryConfigurationList(inventoryConfigurationList);
    return this;
  }
  
  public boolean isTruncated()
  {
    return isTruncated;
  }
  
  public void setTruncated(boolean isTruncated)
  {
    this.isTruncated = isTruncated;
  }
  
  public ListBucketInventoryConfigurationsResult withTruncated(boolean isTruncated)
  {
    setTruncated(isTruncated);
    return this;
  }
  
  public String getContinuationToken()
  {
    return continuationToken;
  }
  
  public void setContinuationToken(String continuationToken)
  {
    this.continuationToken = continuationToken;
  }
  
  public ListBucketInventoryConfigurationsResult withContinuationToken(String continuationToken)
  {
    setContinuationToken(continuationToken);
    return this;
  }
  
  public String getNextContinuationToken()
  {
    return nextContinuationToken;
  }
  
  public void setNextContinuationToken(String nextContinuationToken)
  {
    this.nextContinuationToken = nextContinuationToken;
  }
  
  public ListBucketInventoryConfigurationsResult withNextContinuationToken(String nextContinuationToken)
  {
    setNextContinuationToken(nextContinuationToken);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListBucketInventoryConfigurationsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */