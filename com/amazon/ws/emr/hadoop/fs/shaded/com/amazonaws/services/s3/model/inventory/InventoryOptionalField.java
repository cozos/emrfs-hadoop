package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory;

public enum InventoryOptionalField
{
  Size("Size"),  LastModifiedDate("LastModifiedDate"),  StorageClass("StorageClass"),  ETag("ETag"),  IsMultipartUploaded("IsMultipartUploaded"),  ReplicationStatus("ReplicationStatus"),  InventoryOptionalField("InventoryOptionalField"),  EncryptionStatus("EncryptionStatus"),  ObjectLockRetainUntilDate("ObjectLockRetainUntilDate"),  ObjectLockMode("ObjectLockMode"),  ObjectLockLegalHoldStatus("ObjectLockLegalHoldStatus");
  
  private final String field;
  
  private InventoryOptionalField(String field)
  {
    this.field = field;
  }
  
  public String toString()
  {
    return field;
  }
  
  public static InventoryOptionalField fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (InventoryOptionalField enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryOptionalField
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */