package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryConfiguration;

public class GetBucketInventoryConfigurationResult
{
  private InventoryConfiguration inventoryConfiguration;
  
  public InventoryConfiguration getInventoryConfiguration()
  {
    return inventoryConfiguration;
  }
  
  public void setInventoryConfiguration(InventoryConfiguration inventoryConfiguration)
  {
    this.inventoryConfiguration = inventoryConfiguration;
  }
  
  public GetBucketInventoryConfigurationResult withInventoryConfiguration(InventoryConfiguration inventoryConfiguration)
  {
    setInventoryConfiguration(inventoryConfiguration);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketInventoryConfigurationResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */