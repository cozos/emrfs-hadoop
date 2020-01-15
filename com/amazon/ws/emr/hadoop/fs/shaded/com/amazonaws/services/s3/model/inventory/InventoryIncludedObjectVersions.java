package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory;

public enum InventoryIncludedObjectVersions
{
  All("All"),  Current("Current");
  
  private final String name;
  
  private InventoryIncludedObjectVersions(String name)
  {
    this.name = name;
  }
  
  public String toString()
  {
    return name;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryIncludedObjectVersions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */