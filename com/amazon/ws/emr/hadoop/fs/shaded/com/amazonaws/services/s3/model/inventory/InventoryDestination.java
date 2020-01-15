package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory;

import java.io.Serializable;

public class InventoryDestination
  implements Serializable
{
  private InventoryS3BucketDestination S3BucketDestination;
  
  public InventoryS3BucketDestination getS3BucketDestination()
  {
    return S3BucketDestination;
  }
  
  public void setS3BucketDestination(InventoryS3BucketDestination s3BucketDestination)
  {
    S3BucketDestination = s3BucketDestination;
  }
  
  public InventoryDestination withS3BucketDestination(InventoryS3BucketDestination s3BucketDestination)
  {
    setS3BucketDestination(s3BucketDestination);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryDestination
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */