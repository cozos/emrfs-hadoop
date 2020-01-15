package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory;

import java.io.Serializable;

public class InventoryS3BucketDestination
  implements Serializable
{
  private String accountId;
  private String bucketArn;
  private String format;
  private String prefix;
  private InventoryEncryption encryption;
  
  public String getAccountId()
  {
    return accountId;
  }
  
  public void setAccountId(String accountId)
  {
    this.accountId = accountId;
  }
  
  public InventoryS3BucketDestination withAccountId(String accountId)
  {
    setAccountId(accountId);
    return this;
  }
  
  public String getBucketArn()
  {
    return bucketArn;
  }
  
  public void setBucketArn(String bucketArn)
  {
    this.bucketArn = bucketArn;
  }
  
  public InventoryS3BucketDestination withBucketArn(String bucketArn)
  {
    setBucketArn(bucketArn);
    return this;
  }
  
  public String getFormat()
  {
    return format;
  }
  
  public void setFormat(String format)
  {
    this.format = format;
  }
  
  public void setFormat(InventoryFormat format)
  {
    setFormat(format == null ? (String)null : format.toString());
  }
  
  public InventoryS3BucketDestination withFormat(String format)
  {
    setFormat(format);
    return this;
  }
  
  public InventoryS3BucketDestination withFormat(InventoryFormat format)
  {
    setFormat(format);
    return this;
  }
  
  public String getPrefix()
  {
    return prefix;
  }
  
  public void setPrefix(String prefix)
  {
    this.prefix = prefix;
  }
  
  public InventoryS3BucketDestination withPrefix(String prefix)
  {
    setPrefix(prefix);
    return this;
  }
  
  public InventoryEncryption getEncryption()
  {
    return encryption;
  }
  
  public void setEncryption(InventoryEncryption encryption)
  {
    this.encryption = encryption;
  }
  
  public InventoryS3BucketDestination withEncryption(InventoryEncryption encryption)
  {
    setEncryption(encryption);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryS3BucketDestination
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */