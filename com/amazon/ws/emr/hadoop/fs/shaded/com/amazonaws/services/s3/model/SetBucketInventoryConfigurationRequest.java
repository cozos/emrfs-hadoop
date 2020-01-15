package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryConfiguration;
import java.io.Serializable;

public class SetBucketInventoryConfigurationRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucketName;
  private InventoryConfiguration inventoryConfiguration;
  
  public SetBucketInventoryConfigurationRequest() {}
  
  public SetBucketInventoryConfigurationRequest(String bucketName, InventoryConfiguration inventoryConfiguration)
  {
    this.bucketName = bucketName;
    this.inventoryConfiguration = inventoryConfiguration;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public SetBucketInventoryConfigurationRequest withBucketName(String bucketName)
  {
    setBucketName(bucketName);
    return this;
  }
  
  public InventoryConfiguration getInventoryConfiguration()
  {
    return inventoryConfiguration;
  }
  
  public void setInventoryConfiguration(InventoryConfiguration inventoryConfiguration)
  {
    this.inventoryConfiguration = inventoryConfiguration;
  }
  
  public SetBucketInventoryConfigurationRequest withInventoryConfiguration(InventoryConfiguration inventoryConfiguration)
  {
    setInventoryConfiguration(inventoryConfiguration);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketInventoryConfigurationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */